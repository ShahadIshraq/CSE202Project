package Server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.List;

public class firstController {

    FirstMain firstMain;
    void setFirstMain(FirstMain firstMain ){
        this.firstMain=firstMain;
    }
    @FXML
    public ListView<String> leagueList;

    HashMap<String, League> leagueHashMap=new HashMap<>();

    @FXML
    public TextField addLeague;

    @FXML
    public Button addButton;

    @FXML
    public Button removeButton;

    @FXML
    public Button exploreButton;

    @FXML
    public Label firstLabel;

    @FXML
    void addAction(ActionEvent event) {
        String leagueName=addLeague.getText();

        if(leagueName!=null){
            League league=new League(addLeague.getText());
            leagueHashMap.put(addLeague.getText(), league);
            leagueList.getItems().add(leagueName);
            addLeague.setText(null);
            firstMain.addLeague(league);
        }


    }
    public void setLeagueList(List<League> list){
        leagueList.getItems().removeAll();
        leagueHashMap.clear();
        for(League l: list){
            leagueList.getItems().add(l.getName());
            leagueHashMap.put(l.getName(), l);
        }

    }

    @FXML
    void exploreAction(ActionEvent event) {
        String leagueName=leagueList.getSelectionModel().getSelectedItem();
        League league=leagueHashMap.get(leagueName);
        try {
            firstMain.showSecondPage(league);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void removeAction(ActionEvent event) {

        String leagueName=leagueList.getSelectionModel().getSelectedItem();
        League league=leagueHashMap.get(leagueName);
        leagueList.getItems().remove(leagueName);
        leagueHashMap.remove(leagueName, league);
        firstMain.removeLeague(league);
    }

}
