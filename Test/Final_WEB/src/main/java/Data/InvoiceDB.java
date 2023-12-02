package Data;

import business.Invoice;
import business.LineItem;
import business.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public class InvoiceDB {
    public static void insert(Invoice invoice) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(invoice);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static List<Invoice> getAllInvoice() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Invoice> query = em.createQuery("SELECT i FROM Invoice i", Invoice.class);
        return query.getResultList();
    }
}
