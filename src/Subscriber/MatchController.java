package Subscriber;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class MatchController {

    @FXML
    private TextArea Commentry;

    @FXML
    private Label time;

    @FXML
    private Label team1;

    @FXML
    private Label score1;

    @FXML
    private Label score2;

    @FXML
    private Label team2;

    Match match;

    public void setMatch(Match match) {
        this.match = match;
    }
}
