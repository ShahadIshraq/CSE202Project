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

import java.util.Hashtable;

public class Main extends Application {
    Stage stage;
    Hashtable<Contributor, Match> cTable=new Hashtable<>();
    ObservableList<Match> matches= FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
       stage = primaryStage;
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
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }
}
