package Contributor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static java.lang.System.exit;

/**
 * Created by user on 14-Dec-15.
 */
public class loginController {
    private Main main;
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
            main.showUpdatePage();
        }
        if(e.getSource()==cancelButton)
        {
            System.out.println("cancle");
            exit(1);
        }
    }

    public void setMain(Main main){this.main=main;}
}
