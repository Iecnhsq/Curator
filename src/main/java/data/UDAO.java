package data;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import service.HibernateUtil;

public class UDAO {

    private static final Logger LOGGER = Logger.getLogger(UDAO.class);

    public User getUserByLogin(String login) {
        Session s = HibernateUtil.getSESSIONFACTORY().openSession();
        User out;
        s.beginTransaction();
        out = (User) s.createQuery("FROM User WHERE login='" + login + "'").uniqueResult();
        s.getTransaction().commit();
        s.close();
        LOGGER.info(out);
        return out;
    }

}
