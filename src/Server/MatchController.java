
/**
 * Created by ABIR BINDU on 12/14/2015.
 */
package Server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import CommonClasses.*;

public class MatchController {

    @FXML
    public Label score1;

    @FXML
    public Label minute;

    @FXML
    public Label team1;

    @FXML
    public Label team2;

    @FXML
    public Label score2;

    @FXML
    public TextArea commentry;

    Main main;

    Match match;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @FXML
    private Button backButton;

    @FXML
    void backAction(ActionEvent event) {
        try {
            main.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}