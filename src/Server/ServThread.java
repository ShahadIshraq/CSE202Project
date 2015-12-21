package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

/**
 * Created by user on 19-Dec-15.
 */
public class ServThread implements Runnable{

    private NetworkUtil nc;
    private Main main;
    private Thread t;
    private ServerSocket ss;
    ServThread(Main main) throws IOException {
        this.main=main;
        ss=new ServerSocket(33333);
        t=new Thread(this);
        t.start();
    }
    @Override
    public void run() {

        System.out.println("got into ServThread");
        while(true){
            try {
                nc=new NetworkUtil(ss.accept());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String msg= (String) nc.read();
            if(msg.equals("contributor"))
            {
                System.out.println("A contributor is trying to log in");
                String up=(String) nc.read();
                StringTokenizer st=new StringTokenizer(up," ");
                String n=st.nextToken();
                String p=st.nextToken();

                System.out.println("got acc name: "+n+ " and pass: "+p);
                if(main.mTable.containsValue(up))
                {
                    System.out.println("Matched");
                    nc.write("oka");
                    nc.write(main.cTable.get(up).toString());
                    System.out.println("Match details sent");
                    ContributorThread ct=new ContributorThread(this.main,nc,main.cTable.get(up));
                }
                else nc.write("Alert");

            }
            if(msg.equals("client"))
            {
                main.clientList.add(nc);
                new ClientThread(nc,main);
            }

        }
    }
}
