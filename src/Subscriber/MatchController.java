package Subscriber;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import CommonClasses.*;

public class MatchController {



    @FXML
    public Label time;

    @FXML
    public Label team1;

    @FXML
    public Label score1;

    @FXML
    public Label score2;

    @FXML
    public Label team2;

    Match match;

    Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
    @FXML
    private Button back;

    @FXML
    private Button refresh;

    @FXML
    void backAction(ActionEvent event) {
        try {
            main.showHomePage();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void refreshaction(ActionEvent event)
    {
        try {
            main.showMatchPage(main.mTable.get(match.toString()));
        } catch (Exception e) {
            System.out.println("Refreshing error");
        }
    }
}
