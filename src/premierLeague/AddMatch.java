package premierLeague;

import java.io.Serializable;

public class AddMatch implements Serializable {
    //----------------Instance Variable----------//
    private String team1Name;
    private String team2Name;
    private int team1Score;
    private int team2Score;
    private String date;

    //---------------Parameterized Constructor---------------//
    public AddMatch(String team1Name, String team2Name, int team1Score, int team2Score, String date) {
        this.team1Name = team1Name;
        this.team2Name = team2Name;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.date = date;
    }

    //------------------Getter for teamName1----------//
    public String getTeam1Name() {
        return team1Name;
    }

    //-----------------Setter for teamName1-----------//
    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    //----------------Getter for teamName2---------//
    public String getTeam2Name() {
        return team2Name;
    }

    //----------------Setter for teamName2---------//
    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    //----------------Getter for teamScore1---------//
    public int getTeam1Score() {
        return team1Score;
    }

    //----------------Setter for teamScore1---------//
    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    //----------------Getter for teamScore2---------//
    public int getTeam2Score() {
        return team2Score;
    }

    //----------------Setter for teamScore2---------//
    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    //-----------------getter for date-------------//
    public String getDate() {
        return date;
    }

    //-----------------setter for date-------------//
    public void setDate(String date) {
        this.date = date;
    }

    //------------------ToString method----------------//
    @Override
    public String toString() {
        return "Added Match Details --> { " +
                "Home Team Name = " + team1Name +
                ", Away Team Name = " + team2Name +
                ", Home Team Score = " + team1Score +
                ", Away Team Score = " + team2Score +
                ", Date =" + date +
                '}';
    }
}
