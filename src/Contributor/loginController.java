package Contributor;

import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.StringTokenizer;

import static java.lang.System.exit;

/**
 * Created by user on 14-Dec-15.
 */
public class loginController {
    private Main main;
    private Contributor reporter;
    @FXML
    public TextField userName;
    @FXML
    public TextField password;
    @FXML
    public Button loginButton;
    @FXML
    public Button cancelButton;

    @FXML
    public void buttonAction(ActionEvent e) throws Exception
    {
        if(e.getSource()==loginButton)
        {
            //System.out.println("login");
            System.out.println("Name: "+userName.getText()+"  Password: "+password.getText());
            main.reporter.setName(userName.getText());
            main.reporter.setPassword(password.getText());
            System.out.println("Got here");
            NetworkUtil nc=new NetworkUtil("127.0.0.1",33333);
            System.out.println("Connection established");
            nc.write("contributor");
            System.out.println("Said that am an contributor");
            String up=userName.getText()+" "+password.getText();
            nc.write(up);
            System.out.println("Sent reporter profile");
            String m=(String) nc.read();
            if(m.equals("oka"))
            {

                System.out.println("got oka");
                m=(String)nc.read();
                StringTokenizer st=new StringTokenizer("vs");
                main.showUpdatePage(st.nextToken(),st.nextToken());
            }
            else if(m.equals("Alert"))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Credentials");
                alert.setHeaderText("Incorrect Credentials");
                alert.setContentText("The username and password you provided is not correct.");
                alert.showAndWait();
            }

        }
        if(e.getSource()==cancelButton)
        {
            System.out.println("cancle");
            exit(1);
        }
    }

    public void setMain(Main main){
        this.main=main;
        this.reporter=main.reporter;
    }
}
