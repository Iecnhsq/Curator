package service;

import data.User;

public interface Service {

    public User isLogin(String login);

    public String isPass(String login);

    public User isMail(String mail);

    public boolean registerUserInDb(String login, String password, String mail);

}
