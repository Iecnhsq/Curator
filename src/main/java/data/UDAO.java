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

    public User getUserByMail(String mail) {
        Session s = HibernateUtil.getSESSIONFACTORY().openSession();
        User out;
        s.beginTransaction();
        out = (User) s.createQuery("FROM User WHERE mail='" + mail + "'").uniqueResult();
        s.getTransaction().commit();
        s.close();
        LOGGER.info(out);
        return out;
    }

    public void addUser(User u) {
        Session s = HibernateUtil.getSESSIONFACTORY().openSession();
        s.beginTransaction();
        s.save(u);
        s.getTransaction().commit();
        s.close();
        LOGGER.info("Add user:" + u);
    }

    /* public boolean registerUserInDb(String login, String password, String city, String phone, String email) {
        User user = new User(new Random().nextInt(), login, password, new Date(), 0, 0, new Gson().toJson(new Deck()), "Mage", 0, city, phone, email, 'n');
        udao.addUser(user);
        LOGGER.info("Registre User in DB!");
        return true;
    }
     */
}
