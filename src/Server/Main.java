package Server;/**
 * Created by ABIR BINDU on 12/14/2015.
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import CommonClasses.*;

public class Main extends Application {
    Stage stage;

    Hashtable<String, Match> cTable=new Hashtable<>();
    Hashtable<Match, String> mTable=new Hashtable<>();
    Hashtable<String,Integer> f=new Hashtable<>();
    ObservableList<Match> matches= FXCollections.observableArrayList();

    ObservableList<NetworkUtil> clientList=FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
       stage = primaryStage;

        ServThread t=new ServThread(this);
        try {
            showHomePage();
        } catch (Exception e) {
            System.out.println("here");
            e.printStackTrace();
        }








    }

    public void showHomePage() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("league.fxml"));
        Parent root = loader.load();
        HomeController controller = loader.getController();
        controller.setMain(this);
        controller.setMatches(matches);
        stage.setTitle("LIVE SCORE");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }


    public void showMatchPage(Match match)throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("matchScore.fxml"));
        Parent root = loader.load();
        MatchController controller = loader.getController();
        controller.setMain(this);
        controller.setMatch(match);
        controller.minute.setText((match.getSimpleMinute()));
        controller.team1.setText(match.getSimpleFirstTeam());
        controller.team2.setText(match.getSimpleLastTeam());
        controller.score1.setText(match.getSimpleScoreFirst());
        controller.score2.setText(match.getSimpleScoreLast());
        stage.setTitle("LIVE SCORE");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}
