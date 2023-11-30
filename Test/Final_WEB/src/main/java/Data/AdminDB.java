package Data;

import business.Admin;
import business.Customer;
import business.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class AdminDB {
    public static void insert(Admin admin){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(admin);
            trans.commit();
        }
        catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public Admin login(String username, String passwd){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT c FROM Admin c ";
        TypedQuery<Admin> q = em.createQuery(qString, Admin.class);
        List<Admin> admins = new ArrayList<>();
        admins = q.getResultList();
        for (var admin : admins)
        {
            if (admin.getUserName().equals(username) && admin.getPasswd().equals(passwd)){
                return admin;
            }
        }

        return null;

    }
    public static Admin selectadmin( String adminID){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT a FROM Admin a " +
                "WHERE a.adminID = :adminID";
        TypedQuery<Admin> q = em.createQuery(qString, Admin.class);
        q.setParameter("adminID", adminID);
        Admin result = null;
        try {
            result = q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }

        return (Admin) result;
    }
}
