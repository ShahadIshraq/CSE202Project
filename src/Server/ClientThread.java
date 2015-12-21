package Server;
import CommonClasses.*;

import java.util.ArrayList;

/**
 * Created by user on 20-Dec-15.
 */
public class ClientThread implements Runnable {

    private NetworkUtil nc;
    private Main main;
    Thread t;

    ClientThread(NetworkUtil nc,Main main)
    {
        this.nc=nc;
        this.main=main;
        t=new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        if(!main.matches.isEmpty()){
            for(Match m:main.matches)
            {
                nc.write("add,"+m.toString()+","+m.getScoreFirst()+","+m.getScoreLast()+","+m.getMinute());
            }

        }

        String msg=(String) nc.read();
        if(msg.equals("oka bye"))
        {
            main.clientList.remove(nc);
            nc.closeConnection();
        }
    }
}
