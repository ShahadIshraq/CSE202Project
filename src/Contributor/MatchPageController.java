

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
        System.out.println("now");
    }

    @FXML
    void logoutAction(ActionEvent event) throws Exception {
        main.showFirstPage();
    }

    void init()
    {
        gameState=0;
        g1=3;
        g2=0;
        team1.setText("Man Utd");
        team2.setText("Chelsea");
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
