package Server;

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
        String msg=(String) nc.read();
        if(msg.equals("oka bye"))
        {
            main.clientList.remove(nc);
            nc.closeConnection();
        }
    }
}
