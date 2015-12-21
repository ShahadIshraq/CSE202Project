

/**
 * Created by ABIR BINDU on 12/16/2015.
 */
package Subscriber;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.ListView;
        import CommonClasses.*;

public class FirstController {

    @FXML
    public ListView<String> ScoreCard;

    Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private Button exploreButton;

    @FXML
    private Button backButton;

    @FXML
    void backAction(ActionEvent event) {


        //Here will be the code of exit of client
    }

    @FXML
    void exploreAction(ActionEvent event) {

        String matchName=ScoreCard.getSelectionModel().getSelectedItem();
        Match match=main.mTable.get(matchName);
        try {
            main.showMatchPage(match);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

