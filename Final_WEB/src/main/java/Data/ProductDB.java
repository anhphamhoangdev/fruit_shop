package Data;

import business.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductDB {
    public static void insert(Product product) {
        EntityManager em2 = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em2.getTransaction();
        trans.begin();
        try {
            em2.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em2.close();
        }
    }
    public static List<Product> getAllProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    public static Product selectProduct(String fruitID){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Product p " +
                "WHERE p.fruitID = :fruitID";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("fruitID", fruitID);
        Product result = null;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return (Product)result;

    }

}
