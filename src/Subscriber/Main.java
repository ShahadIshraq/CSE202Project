package Subscriber;/**
 * Created by ABIR BINDU on 12/16/2015.
 */

import Server.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import CommonClasses.*;
import java.util.Hashtable;
import java.util.Observable;

public class Main extends Application {
    Stage stage;
    ObservableList<sMatch> matches= FXCollections.observableArrayList();
    ObservableList<String> sMatches=FXCollections.observableArrayList();
    Hashtable<String, sMatch> mTable=new Hashtable<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        netThread nt=new netThread(this);
        stage=primaryStage;
        try {
            showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showHomePage()throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Homepage.fxml"));
        Parent root = loader.load();
        FirstController controller = loader.getController();
        controller.setMain(this);
        controller.ScoreCard.setItems(sMatches);
        stage.setTitle("LIVE SCORE");
        stage.setScene(new Scene(root, 580, 450));
        stage.show();
    }

    public void showMatchPage(sMatch match)throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("match.fxml"));
        Parent root = loader.load();
        MatchController controller = loader.getController();
        controller.setMain(this);
        controller.setMatch(match);
        controller.time.setText(match.getSimpleMinute());
        controller.team1.setText(match.getSimpleFirstTeam());
        controller.team2.setText(match.getLastTeam());
        controller.score1.setText(match.getSimpleScoreFirst());
        controller.score2.setText(match.getSimpleScoreLast());

        stage.setTitle("LIVE SCORE");
        stage.setScene(new Scene(root, 580, 450));
        stage.show();
    }
}
