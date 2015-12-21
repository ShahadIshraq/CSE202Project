package Subscriber;

import Contributor.*;
import Server.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import CommonClasses.*;

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
            System.out.println("Got here");
            ArrayList<Match> ma= (ArrayList<Match>) nc.read();
            ObservableList<Match> mam=FXCollections.observableArrayList();
            for(Match m: ma) mam.add(m);
            main.matches=mam;
            for(Match m: ma) mam.add(m);

            System.out.println(main.matches);
        }
    }
}
