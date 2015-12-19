

/**
 * Created by user on 14-Dec-15.
 */
package Contributor;

        import javafx.animation.AnimationTimer;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;

        import java.time.LocalDateTime;


public class MatchPageController {


    int g1,g2,gameState=0;
    private Main main;
    LocalDateTime startPoint = LocalDateTime.now();
    LocalDateTime secondStartPoint = LocalDateTime.now();
    LocalDateTime currentPoint = LocalDateTime.now();
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

<<<<<<< HEAD
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
=======


   /*@FXML
   private void updateTime(ActionEvent event)
    {
            timer.setText(String.valueOf(now));
    }*/

>>>>>>> NetworkAndTime
    @FXML
    void startAction(ActionEvent event) {
        if(gameState==0)
        {
            startPoint=LocalDateTime.now();
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
            secondStartPoint=LocalDateTime.now();
            gameState=3;
            start.setText("Second Half Finish");
            //t.stop();
        }
        else if(gameState==3)
        {
            gameState=4;
            start.setOpacity(0.0);
        }
    }

    @FXML
    void addGoalTeam1(ActionEvent event) {
        match.setScoreLast(match.getScoreFirst()+1);
        main.nc.write("g1"+','+match.toString()+','+match.getSimpleMinute());
    }

    @FXML
    void addGoalTeam2(ActionEvent event) {
        match.setScoreLast(match.getScoreLast() + 1);
        main.nc.write("g2" + ',' + match.toString() + ',' + match.getSimpleMinute());
    }

    @FXML
    void updateTimeAction(ActionEvent event) {
        if(gameState==1){
            currentPoint=LocalDateTime.now();
            int time=currentPoint.getHour()*24+currentPoint.getMinute()*60+currentPoint.getSecond()-(startPoint.getHour()*24+startPoint.getMinute()*60+startPoint.getSecond());
            timer.setText(String.valueOf(time/60)+":"+String.valueOf(time%60));
        }
        else if(gameState==3)
        {
            currentPoint=LocalDateTime.now();
            int time=currentPoint.getHour()*24+currentPoint.getMinute()*60+currentPoint.getSecond()-(secondStartPoint.getHour()*24+secondStartPoint.getMinute()*60+secondStartPoint.getSecond());
            timer.setText(String.valueOf(time/60)+":"+String.valueOf(time%60));
        }
        System.out.println("now");
        main.nc.write("ut" + ',' + match.toString() + ',' + match.getSimpleMinute());
    }

    @FXML
    void logoutAction(ActionEvent event) throws Exception {
        main.showFirstPage();
        main.nc.write("out"+','+match.toString()+','+match.getSimpleMinute());
        main.nc.closeConnection();
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
