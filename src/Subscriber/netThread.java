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
            if(st.nextToken().equals("add"))
            {
                System.out.println("In add");
                Match match=new Match(st.nextToken(),st.nextToken());
                match.setScoreFirst(Integer.parseInt(st.nextToken()));
                match.setScoreLast(Integer.parseInt(st.nextToken()));
                match.setMinute(Integer.parseInt(st.nextToken()));
                main.matches.add(match);
                main.sMatches.add(match.toString());
                main.mTable.put(match.toString(),match);
            }
            else
            {
                st.nextToken();
                System.out.println("In update");
                String ms=st.nextToken()+","+st.nextToken();
                main.mTable.get(ms);
                main.mTable.get(ms).setScoreFirst(Integer.parseInt(st.nextToken()));
                main.mTable.get(ms).setScoreLast(Integer.parseInt(st.nextToken()));
                main.mTable.get(ms).setMinute(Integer.parseInt(st.nextToken()));
            }
        }
    }
}
