package data;

import org.hibernate.Session;
import service.HibernateUtil;

public class UDAO {

    public User getUserByLogin(String login) {
        Session s = HibernateUtil.getSESSIONFACTORY().openSession();
        User out;
        s.beginTransaction();
        out = (User) s.createQuery("FROM User WHERE login='" + login + "'").uniqueResult();
        s.getTransaction().commit();
        s.close();
        return out;
    }

}
