package Subscriber;

import Contributor.*;
import Server.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.StringTokenizer;

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
            String m=(String)nc.read();
            StringTokenizer st=new StringTokenizer(m,",");
            String msg,ft,lt,sf,sl,t;
            msg=st.nextToken();
            ft=st.nextToken();
            lt=st.nextToken();
            sf=st.nextToken();
            sl=st.nextToken();
            t=st.nextToken();
            if(msg.equals("add"))
            {
                System.out.println("In add");
                sMatch match=new sMatch(ft,lt);
                match.setScoreFirst(Integer.parseInt(sf));
                match.setScoreLast(Integer.parseInt(sl));
                match.setMinute(Integer.parseInt(t));
                main.matches.add(match);
                main.sMatches.add(match.toString());
                main.mTable.put(match.toString(),match);
            }
            else
            {

                System.out.println("In update");

                String ms=ft+" vs "+lt;
                main.mTable.get(ms).setScoreFirst(Integer.parseInt(sf));
                main.mTable.get(ms).setScoreLast(Integer.parseInt(sl));
                main.mTable.get(ms).setMinute(Integer.parseInt(t));
            }
        }
    }
}
