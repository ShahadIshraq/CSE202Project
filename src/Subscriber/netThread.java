package Subscriber;

import Contributor.*;
import Server.*;
import Server.Match;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by user on 21-Dec-15.
 */
public class netThread implements Runnable{

    private Main main;
    private Thread t;
    private NetworkUtil nc;

    netThread(Main main)
    {
        this.main=main;
        t=new Thread(this);
        t.start();
    }


    @Override
    public void run() {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        nc = new NetworkUtil(serverAddress, serverPort);
        System.out.println("Connected");
        nc.write("client");
        while(true)
        {
            ObservableList<Match> matches= (ObservableList<Match>) nc.read();
            main.matches=matches;
        }
    }
}
