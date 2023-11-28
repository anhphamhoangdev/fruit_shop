package Data;

import business.Product;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Date;
import java.util.List;

public class ProductDB {
    public static void insert(String name, String origin, Integer price, Date exp, Date input, String decription) {
        Product product = new Product();
        product.setName(name);
        product.setOrigin(origin);
        product.setPrice(price);
        product.setExp(exp);
        product.setDateInput(input);
        product.setDescription(decription);
        EntityManager em2 = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em2.getTransaction();
        trans.begin();
        try {
            Query query =em2.createQuery("select p from Product p ORDER BY p.fruitID DESC");
            query.setMaxResults(1);
            Product lastProduct = (Product) query.getSingleResult();
            int index= lastProduct != null ? Integer.parseInt(lastProduct.getFruitID().substring(1))+1:1;
            String FruitID= "F" + String.format("%03d",index);
            product.setFruitID(FruitID);
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
