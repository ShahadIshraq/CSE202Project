

/**
 * Created by ABIR BINDU on 12/8/2015.
 */

package Server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MatchController {

    @FXML
    public TextField firstTeam;

    @FXML
    public TextField score1;

    @FXML
    public TextField score2;

    @FXML
    public TextField lastTeam;
    @FXML
    public TextField timer;

    @FXML
    private Button update;

    @FXML
    private TextArea field;

    //@FXML
    //private Button commentry;

    @FXML
    private Button summarry;

    @FXML
    private Button playingXI;

    @FXML
    private TextArea addField;

    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    @FXML
    public ListView<String> pxi1;

    @FXML
    public ListView<String> pxi2;

    @FXML
    public TextField newPlayer1;

    @FXML
    public TextField newPlayer2;

    @FXML
    public Button adp1;

    @FXML
    public Button adp2;

    @FXML
    void addPlayer1(ActionEvent event) {
    String name=newPlayer1.getText();
        if(name!=null){
            pxi1.getItems().add(name);
            newPlayer1.setText(null);
        }
    }

    @FXML
    void addPlayer2(ActionEvent event) {
        String name=newPlayer2.getText();
        if(name!=null){
            pxi2.getItems().add(name);
            newPlayer2.setText(null);
        }
    }

    League league;
    Match Match;

    public void setLeague(League league) {
        this.league = league;
    }

    public void setMatch(Server.Match match) {
        Match = match;
    }

    FirstMain firstMain;

    public void setFirstMain(FirstMain firstMain) {
        this.firstMain = firstMain;
    }

    public FirstMain getFirstMain() {
        return firstMain;
    }

    public Server.Match getMatch() {
        return Match;
    }

    public League getLeague() {
        return league;
    }

    @FXML
    void addAction(ActionEvent event) {
        field.setText(field.getText()+addField.getText()+'\n');
    }

   /* @FXML
    void showCommentry(ActionEvent event) {

    }
*/
    @FXML
    void showPlayingXI(ActionEvent event) {

        pxi1.setVisible(true);
        pxi2.setVisible(true);
        newPlayer1.setVisible(true);
        newPlayer2.setVisible(true);
        adp1.setVisible(true);
        adp2.setVisible(true );
        field.setVisible(false);
        addField.setVisible(false);
        addButton.setVisible(false);
    }

    @FXML
    void showSummarry(ActionEvent event) {

        pxi1.setVisible(false);
        pxi2.setVisible(false);
        newPlayer1.setVisible(false);
        newPlayer2.setVisible(false);
        adp1.setVisible(false);
        adp2.setVisible(false);
        field.setVisible(true);
        addField.setVisible(true);
        addButton.setVisible(true);
    }

    @FXML
    void updateAction(ActionEvent event) {
        int sc1=Integer.parseInt(score1.getText());
        int sc2=Integer.parseInt(score2.getText());
        getMatch().setScoreFirst(sc1);
        getMatch().setScoreLast(sc2);
        int t=Integer.parseInt(timer.getText());
        getMatch().setMinute(t);
    }

    @FXML
    void backAction(ActionEvent event) {
        try {
            firstMain.showSecondPage(league);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}