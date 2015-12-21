package Contributor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.StringTokenizer;

import static java.lang.System.exit;
import CommonClasses.*;

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
    public void buttonAction(ActionEvent e) throws Exception {
        if (e.getSource() == loginButton) {

            String uName=userName.getText()==null?"_":userName.getText();
            String pass=password.getText()==null?"_":password.getText();
            System.out.println("Name: " + uName + "  Password: " + pass);
            main.reporter = userName.getText() + " " + password.getText();
            String serverAddress = "127.0.0.1";
            int serverPort = 33333;
            main.nc = new NetworkUtil(serverAddress, serverPort);
            System.out.println("Connected");
            main.nc.write("contributor");
            main.nc.write(main.reporter);
            System.out.println("Credentials sent");
            String m = (String) main.nc.read();

            if (m.equals("Alert")) {
                System.out.println("Error: User name and password don't match");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect Credentials");
                alert.setHeaderText("Incorrect Credentials");
                alert.setContentText("The username and password you provided is not correct.");
                alert.showAndWait();
            }
            if (m.equals("oka")) {
                System.out.println("Got access");
                String mt = (String) main.nc.read();
                System.out.println("atch detail: "+mt);
                StringTokenizer st = new StringTokenizer(mt, ",");
                Match match = new Match(st.nextToken(), st.nextToken());
                try {
                    main.showUpdatePage(match);
                } catch (Exception E) {
                    E.printStackTrace();
                }

            }
            if (e.getSource() == cancelButton) {
                System.out.println("cancle");
                exit(1);
            }
        }
    }

    public void setMain(Main main){this.main=main;}
}
