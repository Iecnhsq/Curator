package service;

import data.UDAO;
import data.User;
import java.util.Random;
import org.apache.log4j.Logger;

public class ServiceImpl implements Service {

    private static final Logger LOGGER = Logger.getLogger(ServiceImpl.class);
    private final UDAO udao = new UDAO();

    @Override
    public User isLogin(String login) {
        User u;
        u = udao.getUserByLogin(login);
        return u;
    }

    @Override
    public String isPass(String login) {
        User u;
        u = udao.getUserByLogin(login);
        String s;
        s = u.getPassword();
        return s;
    }

    @Override
    public User isMail(String mail) {
        User u;
        u = udao.getUserByMail(mail);
        return u;
    }

    @Override
    public boolean registerUserInDb(String login, String password, String mail) {
        User user = new User(new Random().nextInt(), "Ф. І. О.", login, password, mail, "+380", "Група");
        udao.addUser(user);
        LOGGER.info("Registre User in DB!");
        return true;
    }

}
