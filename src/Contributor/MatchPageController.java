

/**
 * Created by user on 14-Dec-15.
 */
package Contributor;


        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;

        import java.time.LocalDateTime;
        import CommonClasses.*;


public class MatchPageController {

    LocalDateTime startPoint;
    LocalDateTime secondStartPoint;
    LocalDateTime currentPoint;
    int g1,g2,gameState=0;
    private Main main;

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







    @FXML
    void startAction(ActionEvent event) {
        if(gameState==0)
        {
            startPoint=LocalDateTime.now();
            gameState=1;
            start.setText("Half Time");

        }
        else if(gameState==1)
        {
            gameState=2;
            timer.setText("45:00");
            main.nc.write("ut");
            main.nc.write(45*60);
            start.setText("Second Half Start");

        }
        else if(gameState==2)
        {
            secondStartPoint=LocalDateTime.now();
            gameState=3;
            start.setText("Second Half Finish");

        }
        else if(gameState==3)
        {
            timer.setText("90:00");
            main.nc.write("ut");
            main.nc.write(90*60);
            gameState=4;
            start.setOpacity(0.0);

        }
    }

    @FXML
    void addGoalTeam1(ActionEvent event) {
        //match.setScoreLast(match.getScoreFirst()+1);
        score1.setText(String.valueOf(Integer.parseInt(score1.getText())+1));
        currentPoint=LocalDateTime.now();
        int time=currentPoint.getHour()*60*60+currentPoint.getMinute()*60+currentPoint.getSecond()-(startPoint.getHour()*60*60+startPoint.getMinute()*60+startPoint.getSecond());
        timer.setText(String.valueOf(time/60)+":"+String.valueOf(time%60));
        //match.setMinute(time);
        main.nc.write("g1");
        main.nc.write(time);
    }

    @FXML
    void addGoalTeam2(ActionEvent event) {
        //match.setScoreLast(match.getScoreLast() + 1);
        score2.setText(String.valueOf(Integer.parseInt(score2.getText())+1));
        currentPoint=LocalDateTime.now();
        int time=currentPoint.getHour()*24*60+currentPoint.getMinute()*60+currentPoint.getSecond()-(startPoint.getHour()*24*60+startPoint.getMinute()*60+startPoint.getSecond());
        timer.setText(String.valueOf(time/60)+":"+String.valueOf(time%60));
        //match.setMinute(time);
        main.nc.write("g2");
        main.nc.write(time);
    }

    @FXML
    void updateTimeAction(ActionEvent event) {
        currentPoint=LocalDateTime.now();

        if(gameState==1){
            int time=currentPoint.getHour()*60*60+currentPoint.getMinute()*60+currentPoint.getSecond()-(startPoint.getHour()*60*60+startPoint.getMinute()*60+startPoint.getSecond());
            timer.setText(String.valueOf(time/60)+":"+String.valueOf(time%60));
            match.setMinute(time);
            System.out.println("now: "+time);
            main.nc.write("ut");
            main.nc.write(time);
        }
        else if(gameState==3)
        {
            int time=currentPoint.getHour()*60*60+currentPoint.getMinute()*60+currentPoint.getSecond()-(secondStartPoint.getHour()*60*60+secondStartPoint.getMinute()*60+secondStartPoint.getSecond());
            timer.setText(String.valueOf(time/60)+":"+String.valueOf(time%60));
            match.setMinute(time);
            System.out.println("now: "+time);
            main.nc.write("ut");
            main.nc.write(time);
        }



    }

    @FXML
    void logoutAction(ActionEvent event) throws Exception {
        main.nc.write("out");
        main.nc.closeConnection();
        main.showFirstPage();
    }

    void init()
    {
        LocalDateTime startPoint = LocalDateTime.now();
        LocalDateTime secondStartPoint = LocalDateTime.now();
        LocalDateTime currentPoint = LocalDateTime.now();
        timer.setText(match.getSimpleMinute());
        team1.setText(match.getSimpleFirstTeam());
        team2.setText(match.getSimpleLastTeam());
        score1.setText(match.getSimpleScoreFirst());
        score2.setText(match.getSimpleScoreLast());
    }



    public void setMain(Main main){this.main=main;}
}
