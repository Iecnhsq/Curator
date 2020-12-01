package main;

import view.AccountFrame;
//import view.LoginFrame;

//import view.RegisterFrame;
import java.io.IOException;
import service.WordWorker;

//import view.RegisterFrame;
public class Main {

    public static void main(String[] args) throws IOException {
        //new LoginFrame().setVisible(true);

        //new RegisterFrame().setVisible(true);
        new AccountFrame().setVisible(true);

        //new RegisterFrame().setVisible(true);
        WordWorker wordWorker = new WordWorker();

    }

}
