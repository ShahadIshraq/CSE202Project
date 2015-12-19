package Contributor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by user on 14-Dec-15.
 */
public class Main extends Application {
    Stage stage;
    Contributor reporter=new Contributor();
    NetworkUtil nc;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        showFirstPage();

    }

    public void showFirstPage()throws Exception{

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("loginPage.fxml"));
        Parent root=loader.load();
        loginController controller = loader.getController();
        controller.setMain(this);
        //controller.setLeagueList(leagueList);
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 300, 173));
        stage.show();
    }
    void Login()
    {
        String serverAddress="127.0.0.1";
        int serverPort=33333;
        nc = new NetworkUtil(serverAddress,serverPort);
        nc.write(reporter);
        Object o=nc.read();
        if(o!=null)
        {
            if(o instanceof String)
            {
                String msg=(String) o;
                if(msg.equals("Alert")) System.out.println("Error");
                if(msg.equals("OK")) {
                    Object o1=nc.read();
                    Match match=(Match)o1;
                    try {
                        showUpdatePage(match);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }

    void showUpdatePage(Match  match) throws Exception {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("matchPageContributor.fxml"));
        Parent root=loader.load();
        MatchPageController controller = loader.getController();
        controller.init();
        controller.setMain(this);
        controller.setMatch(match);

        stage.setTitle("Update");
        stage.setScene(new Scene(root, 600, 345));
        stage.show();
    }
}
