package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
        t=new Thread();
        ss=new ServerSocket(33333);
        t.start();
    }
    @Override
    public void run() {

        while(true){
            try {
                nc=new NetworkUtil(ss.accept());
            } catch (IOException e) {
                e.printStackTrace();
            }
            String msg= (String) nc.read();
            if(msg.equals("contributor"))
            {
                Contributor c=(Contributor) nc.read();
                if(main.mTable.containsValue(c))
                {
                    nc.write("oka");
                    nc.write(main.cTable.get(c));
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
