package Contributor;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

/**
 * Created by ABIR BINDU on 12/7/2015.
 */
public class Match implements Serializable {
    String firstTeam;
    String lastTeam;
    int scoreFirst;
    int scoreLast;
    int minute;
    SimpleStringProperty simpleFirstTeam;
    SimpleStringProperty simpleLastTeam;
    SimpleStringProperty simpleScoreFirst;
    SimpleStringProperty simpleScoreLast;
    SimpleStringProperty simpleMinute;

    Match(String firstTeam, String lastTeam){
        this.firstTeam=firstTeam;
        this.lastTeam=lastTeam;
        this.scoreFirst=0;
        this.scoreLast=0;
        this.minute=0;
        simpleFirstTeam=new SimpleStringProperty(firstTeam);
        simpleLastTeam=new SimpleStringProperty(lastTeam);
        simpleScoreFirst=new SimpleStringProperty("0");
        simpleScoreLast=new SimpleStringProperty("0");
        simpleMinute=new SimpleStringProperty("0");

    }

    public String getFirstTeam(){
        return this.firstTeam;
    }
    public String getLastTeam(){
        return this.lastTeam;
    }
    public int getScoreFirst(){
        return this.scoreFirst;
    }
    public int getScoreLast(){
        return this.getScoreLast();
    }
    public void setFirstTeam(String firstTeam){
        this.firstTeam=firstTeam;
    }

    public void setLastTeam(String lastTeam) {
        this.lastTeam = lastTeam;
    }

    public void setScoreFirst(int scoreFirst) {

        this.scoreFirst = scoreFirst;
        simpleScoreFirst.set(String.valueOf(scoreFirst));
    }

    public void setScoreLast(int scoreLast) {
        this.scoreLast = scoreLast;
        simpleScoreLast.set(String.valueOf(scoreLast));
    }

    public void setMinute(int minute) {
        this.minute = minute;
        simpleMinute.set(String.valueOf(minute));
;    }

    public String getSimpleFirstTeam() {
        return simpleFirstTeam.get();
    }

    public SimpleStringProperty simpleFirstTeamProperty() {
        return simpleFirstTeam;
    }

    public String getSimpleLastTeam() {
        return simpleLastTeam.get();
    }

    public SimpleStringProperty simpleLastTeamProperty() {
        return simpleLastTeam;
    }

    public String getSimpleScoreFirst() {
        return simpleScoreFirst.get();
    }

    public SimpleStringProperty simpleScoreFirstProperty() {
        return simpleScoreFirst;
    }

    public String getSimpleScoreLast() {
        return simpleScoreLast.get();
    }

    public SimpleStringProperty simpleScoreLastProperty() {
        return simpleScoreLast;
    }

    public String getSimpleMinute() {
        return simpleMinute.get();
    }

    public SimpleStringProperty simpleMinuteProperty() {
        return simpleMinute;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        String string=firstTeam+","+lastTeam;
        return string;
    }

    public boolean isEqualTo(Match m)
    {
        if(m.firstTeam.equals(this.firstTeam) && m.lastTeam.equals(this.getLastTeam())) return true;
        else return false;
    }

    public void updateMatch(Match match)
    {

        this.setScoreFirst(match.getScoreFirst());
        this.setScoreLast(match.getScoreLast());
        this.setMinute(match.getMinute());
    }
}
