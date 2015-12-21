package Contributor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import CommonClasses.*;


/**
 * Created by user on 14-Dec-15.
 */
public class Main extends Application {
    Stage stage;
    String reporter;
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


    void showUpdatePage(Match  match) throws Exception {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("matchPageContributor.fxml"));
        Parent root=loader.load();
        MatchPageController controller = loader.getController();
        controller.setMain(this);
        controller.setMatch(match);
        controller.init();
        stage.setTitle("Update");
        stage.setScene(new Scene(root, 600, 345));
        System.out.println("Got up to staging the update page.Will show it now...");
        stage.show();
    }
}
