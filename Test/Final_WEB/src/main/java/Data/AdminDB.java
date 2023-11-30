package Data;

import business.Admin;
import business.Customer;
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
}
