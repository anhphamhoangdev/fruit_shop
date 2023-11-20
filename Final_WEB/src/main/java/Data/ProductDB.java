package Data;

import business.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
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
}
