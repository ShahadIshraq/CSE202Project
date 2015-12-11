

/**
 * Created by ABIR BINDU on 12/8/2015.
 */

package Server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    @FXML
    private Button commentry;

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

    @FXML
    void showCommentry(ActionEvent event) {

    }

    @FXML
    void showPlayingXI(ActionEvent event) {

    }

    @FXML
    void showSummarry(ActionEvent event) {

    }

    @FXML
    void updateAction(ActionEvent event) {

    }

    @FXML
    void backAction(ActionEvent event) {

    }
}