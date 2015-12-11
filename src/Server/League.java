package Server;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by ABIR BINDU on 12/7/2015.
 */
public class League {
    //Match[] matches;
    ObservableList<Match> matches= FXCollections.observableArrayList();
    String name;

    public League(String name) {
        this.name = name;
    }

    public void setName(String name){
        this.name=name;
    }

    public ObservableList<Match> getMatches() {
        return matches;
    }

    public void addMatch(Match match){
        matches.add(match);
    }
    public String getName(){
        return this.name;
    }
}
