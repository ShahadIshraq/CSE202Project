package Server;/**
 * Created by ABIR BINDU on 12/7/2015.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FirstMain extends Application {

    Stage stage;
    List <League> leagueList=new ArrayList<>();
    public void addLeague(League league){
        leagueList.add(league);
    }
    public void removeLeague(League league){
        leagueList.remove(league);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage=primaryStage;
        showFirstPage();

    }

    public void showFirstPage()throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("first.fxml"));
        Parent root;
        root = loader.load();
        firstController controller = loader.getController();
        controller.setFirstMain(this);
        controller.setLeagueList(leagueList);
        stage.setTitle("LIVE SCORE");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }

    public void showSecondPage(League league) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("league.fxml"));
        Parent root;
        root = loader.load();
        secondScreenController controller = loader.getController();
        controller.setFirstMain(this);
        controller.setLeague(league);
        stage.setTitle("LIVE SCORE");
        stage.setScene(new Scene(root, 700, 500));
        stage.show();
    }

    public void showMatchPage(League league, Match match) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("match.fxml"));
        Parent root;
        root = loader.load();
        MatchController controller = loader.getController();
        controller.setFirstMain(this);
        controller.setLeague(league);
        controller.setMatch(match);
        controller.firstTeam.setText(match.getSimpleFirstTeam());
        controller.lastTeam.setText(match.getSimpleLastTeam());
        controller.timer.setText(match.getSimpleMinute());
        controller.score1.setText(match.getSimpleScoreFirst());
        controller.score2.setText(match.getSimpleScoreLast());

        controller.pxi1.setVisible(false);
        controller.pxi2.setVisible(false);
        controller.newPlayer1.setVisible(false);
        controller.newPlayer2.setVisible(false);
        controller.adp1.setVisible(false);
        controller.adp2.setVisible(false);

        stage.setTitle("Match Score");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }
}


