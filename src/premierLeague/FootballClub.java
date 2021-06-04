package premierLeague;
/*
Name-Vishani Raveendran
Uow Id-W1789961
IIT Id-2019710
References
==========
https://medium.com/@abdjabbar110/what-is-java-pojo-class-and-java-bean-class-with-example-e63c4c0811a9
https://data-flair.training/blogs/pojo-class-in-java/
https://www.tutorialspoint.com/pojo-vs-java-beans
https://www.edureka.co/blog/pojo-in-java/
*/


public class FootballClub extends SportsClub{
    //---------Instance Variables----------//
    private int numberOfFootballMatchWins;
    private int numberOfFootballMatchLoss;
    private int numberOfFootballMatchDraw;
    private int numberOfFootballGoalsScored;
    private int numberOfFootballGoalsReceived;
    private int numberOfFootballMatchesPlayed;
    private int numberOfPoints;
    private int goalDifference;


    //-------------------Default Constructor-------------------//
    public FootballClub(){

    }

    //-------------------Parameterized Constructor-------------------//
    public FootballClub(String nameOfTheSportsClub, String locationOfTheSportsClub, int numberOfFootballMatchesPlayed, int numberOfFootballMatchWins, int numberOfFootballMatchLoss, int numberOfFootballMatchDraw, int numberOfFootballGoalsScored, int numberOfFootballGoalsReceived, int goalDifference , int numberOfPoints) {
        super(nameOfTheSportsClub, locationOfTheSportsClub);
        this.numberOfFootballMatchWins = numberOfFootballMatchWins;
        this.numberOfFootballMatchLoss = numberOfFootballMatchLoss;
        this.numberOfFootballMatchDraw = numberOfFootballMatchDraw;
        this.numberOfFootballGoalsScored = numberOfFootballGoalsScored;
        this.numberOfFootballGoalsReceived = numberOfFootballGoalsReceived;
        this.numberOfFootballMatchesPlayed = numberOfFootballMatchesPlayed;
        this.numberOfPoints = numberOfPoints;
        this.goalDifference= numberOfFootballGoalsScored - numberOfFootballGoalsReceived;
    }

    //-----------------------Getter for number of match wins-----------------------//
    public int getNumberOfFootballMatchWins() {
        return numberOfFootballMatchWins;
    }

    //-----------------------Setter for number of match wins-----------------------//
    public void setNumberOfFootballMatchWins(int numberOfFootballMatchWins) {
        this.numberOfFootballMatchWins = numberOfFootballMatchWins;
    }

    //-----------------------Getter for number of match loss-----------------------//
    public int getNumberOfFootballMatchLoss() {
        return numberOfFootballMatchLoss;
    }

    //-----------------------Setter for number of match loss-----------------------//
    public void setNumberOfFootballMatchLoss(int numberOfFootballMatchLoss) {
        this.numberOfFootballMatchLoss = numberOfFootballMatchLoss;
    }

    //-----------------------Getter for number of match draw-----------------------//
    public int getNumberOfFootballMatchDraw() {
        return numberOfFootballMatchDraw;
    }

    //-----------------------Setter for number of match draw-----------------------//
    public void setNumberOfFootballMatchDraw(int numberOfFootballMatchDraw) {
        this.numberOfFootballMatchDraw = numberOfFootballMatchDraw;
    }

    //-----------------------Getter for number of Goals scored-----------------------//
    public int getNumberOfFootballGoalsScored() {
        return numberOfFootballGoalsScored;
    }

    //-----------------------Setter for number of Goals scored-----------------------//
    public void setNumberOfFootballGoalsScored(int numberOfFootballGoalsScored) {
        this.numberOfFootballGoalsScored = numberOfFootballGoalsScored;
    }

    //-----------------------Getter for number of Goals received-----------------------//
    public int getNumberOfFootballGoalsReceived() {
        return numberOfFootballGoalsReceived;
    }

    //-----------------------Setter for number of Goals received-----------------------//
    public void setNumberOfFootballGoalsReceived(int numberOfFootballGoalsReceived) {
        this.numberOfFootballGoalsReceived = numberOfFootballGoalsReceived;
    }

    //-----------------------Getter for number of match played-----------------------//
    public int getNumberOfFootballMatchesPlayed() {
        return numberOfFootballMatchesPlayed;
    }

    //-----------------------Setter for number of match played-----------------------//
    public void setNumberOfFootballMatchesPlayed(int numberOfFootballMatchesPlayed) {
        this.numberOfFootballMatchesPlayed = numberOfFootballMatchesPlayed;
        numberOfFootballMatchesPlayed = numberOfFootballMatchWins + numberOfFootballMatchDraw + numberOfFootballMatchWins;
    }

    //-----------------------Getter for number of points-----------------------//
    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    //-----------------------Setter for number of points-----------------------//
    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }


    //-----------------------Getter for goalDifference-----------------------//
    public int getGoalDifference(){return goalDifference;}

    //-----------------------Setter for goalDifference-----------------------//
    public void setGoalDifference(int goalDifference){this.goalDifference=goalDifference;}



    //-----------------------toString() method-----------------------//
    @Override
    public String toString() {
        return "FootballClub{" +
                "Number Of Match Wins=" + numberOfFootballMatchWins +
                ", Number of match loss=" + numberOfFootballMatchLoss +
                ", Number of match draw=" + numberOfFootballMatchDraw +
                ", Number of goals scored=" + numberOfFootballGoalsScored +
                ", Number Of goals received=" + numberOfFootballGoalsReceived +
                ", Number Of matches played=" + numberOfFootballMatchesPlayed +
                ", Number of points='" + numberOfPoints + '\'' +
                '}';
    }

}
