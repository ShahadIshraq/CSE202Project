package Server;

import java.util.StringTokenizer;

/**
 * Created by user on 19-Dec-15.
 */
public class ContributorThread implements Runnable {
    private Main main;
    private NetworkUtil nc;
    private Thread t;
    private Contributor c;
    private Match mtch;

    ContributorThread(Main main,NetworkUtil nc,Contributor c)
    {
        this.main=main;
        this.nc=nc;
        this.c=c;
        mtch=main.cTable.get(c);
        t=new Thread();
        t.start();
    }
    @Override
    public void run() {
        while (true) {
            String m = (String) nc.read();
            StringTokenizer st = new StringTokenizer(m, ",");
            if (st.nextToken().equals("g1")) {
                mtch.setScoreFirst(mtch.getScoreFirst() + 1);
                st.nextToken();
                mtch.setMinute(Integer.parseInt(st.nextToken()));
            } else if (st.nextToken().equals("g2")) {
                mtch.setScoreLast(mtch.getScoreLast() + 1);
                st.nextToken();
                mtch.setMinute(Integer.parseInt(st.nextToken()));
            } else if (st.nextToken().equals("ut")) mtch.setMinute(Integer.parseInt(st.nextToken()));
            else if (st.nextToken().equals("out")) break;

        }
    }
}
