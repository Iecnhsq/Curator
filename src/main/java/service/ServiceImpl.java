package service;

import data.UDAO;
import data.User;

public class ServiceImpl implements Service {

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

}
