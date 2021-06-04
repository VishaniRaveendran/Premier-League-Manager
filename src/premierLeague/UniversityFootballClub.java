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


public class UniversityFootballClub extends FootballClub{
    //---------Instance Variables----------//
    private String nameOfTheUniversity;
    private String coachName;

    //-------------------Default Constructor-------------------//
    public UniversityFootballClub(){

    }

    //-------------------Parameterized Constructor-------------------//
    public UniversityFootballClub(String nameOfTheSportsClub, String locationOfTheSportsClub, int numberOfFootballMatchesPlayed, int numberOfFootballMatchWins, int numberOfFootballMatchLoss, int numberOfFootballMatchDraw, int numberOfFootballGoalsScored, int numberOfFootballGoalsReceived, int goalDifference, int numberOfPoints, String nameOfTheUniversity, String coachName) {
        super(nameOfTheSportsClub, locationOfTheSportsClub, numberOfFootballMatchesPlayed, numberOfFootballMatchWins, numberOfFootballMatchLoss, numberOfFootballMatchDraw, numberOfFootballGoalsScored, numberOfFootballGoalsReceived, goalDifference, numberOfPoints);
        this.nameOfTheUniversity = nameOfTheUniversity;
        this.coachName = coachName;
    }

    //-------------------Getter for name of the university-------------------//
    public String getNameOfTheUniversity() {
        return nameOfTheUniversity;
    }

    //-------------------Setter for name of the university-------------------//
    public void setNameOfTheUniversity(String nameOfTheUniversity) {
        this.nameOfTheUniversity = nameOfTheUniversity;
    }

    //-------------------Getter for name of the coach-------------------//
    public String getCoachName() {
        return coachName;
    }

    //-------------------Setter for name of the coach-------------------//
    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    //-----------------------toString() method-----------------------//
    @Override
    public String toString() {
        return "UniversityFootballClub{" +
                "Name of the university='" + nameOfTheUniversity + '\'' +
                ", Coach name='" + coachName + '\'' +
                '}';
    }
}
