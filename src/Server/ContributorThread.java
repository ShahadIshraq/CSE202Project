package Server;

import java.util.ArrayList;
import java.util.StringTokenizer;
import CommonClasses.*;

/**
 * Created by user on 19-Dec-15.
 */
public class ContributorThread implements Runnable {
    private Main main;
    private NetworkUtil nc;
    private Thread t;
    private Match mtch;

    ContributorThread(Main main,NetworkUtil nc,Match m)
    {
        this.main=main;
        this.nc=nc;
        this.mtch=m;
        t=new Thread(this);
        t.start();
    }
    @Override
    public void run()  {
        System.out.println("Thread for recieving update has been started");
        while (true) {
            String m = (String) nc.read();
            System.out.println("Recieved update: "+m);

            if (m.equals("g1")) {
                mtch.setScoreFirst(mtch.getScoreFirst() + 1);
                int time=(Integer) nc.read();
                mtch.setMinute(time/60);
                System.out.println(mtch.getMinute());
                if(!main.clientList.isEmpty())for(NetworkUtil nc:main.clientList) nc.write("update,"+mtch.toString()+","+mtch.getScoreFirst()+","+mtch.getScoreLast()+","+mtch.getMinute());

            } else if (m.equals("g2")) {
                mtch.setScoreLast(mtch.getScoreLast() + 1);
                int time = (Integer) nc.read();
                mtch.setMinute(time/60);
                System.out.println(mtch.getMinute());
                if(!main.clientList.isEmpty())for(NetworkUtil nc:main.clientList) nc.write("update,"+mtch.toString()+","+mtch.getScoreFirst()+","+mtch.getScoreLast()+","+mtch.getMinute());
            } else if (m.equals("ut")){
                int time=(Integer)nc.read();
                System.out.println(time);
                mtch.setMinute(time/60);
                System.out.println(mtch.getMinute());
                if(!main.clientList.isEmpty())for(NetworkUtil nc:main.clientList) nc.write("update,"+mtch.toString()+","+mtch.getScoreFirst()+","+mtch.getScoreLast()+","+mtch.getMinute());
            }
            else if (m.equals("out")){
                main.f.put(main.mTable.get(mtch),0);
                break;
            }

        }
    }
}
