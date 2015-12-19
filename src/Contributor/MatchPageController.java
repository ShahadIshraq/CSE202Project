

/**
 * Created by user on 14-Dec-15.
 */
package Contributor;

        import javafx.animation.AnimationTimer;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;


public class MatchPageController {


    int g1,g2,gameState=0;
    private Main main;
    //MyTimer t=new MyTimer();

    @FXML
    private Label team1;

    @FXML
    private Label team2;

    @FXML
    private Label score1;

    @FXML
    private Label score2;

    @FXML
    private Label timer;

    @FXML
    private Button updateTimeButton;

    @FXML
    private Button agt1;

    @FXML
    private Button agt2;

    @FXML
    private Button logout;
    @FXML
    private Button start;
    Match match;

    public void setMatch(Match match) {
        this.match = match;
    }

    /*
       @FXML
       private void updateTime(long now)
        {
                timer.setText(String.valueOf(now));
        }
    */
    @FXML
    void startAction(ActionEvent event) {
        if(gameState==0)
        {
            gameState=1;
            start.setText("Half Time");
           // t.start();
        }
        else if(gameState==1)
        {
            gameState=2;
            start.setText("Second Half Start");
            //t.stop();
        }
        else if(gameState==2)
        {
            gameState=3;
            start.setText("Second Half Finish");
            //t.stop();
        }

    }

    @FXML
    void addGoalTeam1(ActionEvent event) {
        match.setScoreLast(match.getScoreFirst()+1);
    }

    @FXML
    void addGoalTeam2(ActionEvent event) {
        match.setScoreLast(match.getScoreLast()+1);
    }

    @FXML
    void updateTimeAction(ActionEvent event) {
        System.out.println("now");
    }

    @FXML
    void logoutAction(ActionEvent event) throws Exception {
        main.showFirstPage();
    }

    void init()
    {
        timer.setText(match.getSimpleMinute());
        team1.setText(match.getSimpleFirstTeam());
        team2.setText(match.getSimpleLastTeam());
        score1.setText(match.getSimpleScoreFirst());
        score2.setText(match.getSimpleScoreLast());
    }

    /*class MyTimer extends AnimationTimer
    {
        @Override
        public void handle(long now) {
            updateTime(now);
        }
    }*/

    public void setMain(Main main){this.main=main;}
}
