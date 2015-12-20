

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



   /*@FXML
   private void updateTime(ActionEvent event)
    {
            timer.setText(String.valueOf(now));
    }*/

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
        System.out.println("G1");
        g1++;
        score1.setText(String.valueOf(g1));

    }

    @FXML
    void addGoalTeam2(ActionEvent event) {
        System.out.println("G2");
        g2++;
        score2.setText(String.valueOf(g2));
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
    }

    @FXML
    void logoutAction(ActionEvent event) throws Exception {
        main.showFirstPage();
    }

    void init(String f,String l)
    {
        gameState=0;
        g1=0;
        g2=0;
        team1.setText(f);
        team2.setText(l);
        score1.setText(String.valueOf(g1));
        score2.setText(String.valueOf(g2));
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
