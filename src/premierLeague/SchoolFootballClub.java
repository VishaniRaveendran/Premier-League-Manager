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

public class SchoolFootballClub extends FootballClub{
    //---------Instance Variables----------//
    private String nameOfTheSchool;
    private String teacherInCharge;

    //-------------------Default Constructor-------------------//
    public SchoolFootballClub(){

    }

    //-------------------Parameterized Constructor-------------------//


    public SchoolFootballClub(String nameOfTheSchool, String teacherInCharge) {
        this.nameOfTheSchool = nameOfTheSchool;
        this.teacherInCharge = teacherInCharge;
    }

    public SchoolFootballClub(String nameOfTheSportsClub, String locationOfTheSportsClub, int numberOfFootballMatchesPlayed, int numberOfFootballMatchWins, int numberOfFootballMatchLoss, int numberOfFootballMatchDraw, int numberOfFootballGoalsScored, int numberOfFootballGoalsReceived, int goalDifference, int numberOfPoints, String nameOfTheSchool, String teacherInCharge) {
        super(nameOfTheSportsClub, locationOfTheSportsClub, numberOfFootballMatchesPlayed, numberOfFootballMatchWins, numberOfFootballMatchLoss, numberOfFootballMatchDraw, numberOfFootballGoalsScored, numberOfFootballGoalsReceived, goalDifference, numberOfPoints);
        this.nameOfTheSchool = nameOfTheSchool;
        this.teacherInCharge = teacherInCharge;
    }

    //-------------------Getter for name of the school-------------------//
    public String getNameOfTheSchool() {
        return nameOfTheSchool;
    }

    //-------------------Setter for name of the school-------------------//
    public void setNameOfTheSchool(String nameOfTheSchool) {
        this.nameOfTheSchool = nameOfTheSchool;
    }

    //-------------------Getter for name of the teacher in charge-------------------//
    public String getTeacherInCharge() {
        return teacherInCharge;
    }

    //-------------------Setter for name of the teacher in charge-------------------//
    public void setTeacherInCharge(String teacherInCharge) {
        this.teacherInCharge = teacherInCharge;
    }

    //-----------------------toString() method-----------------------//
    @Override
    public String toString() {
        return "SchoolFootballClub{" +
                "Name of the school='" + nameOfTheSchool + '\'' +
                ", Teacher in charge='" + teacherInCharge + '\'' +
                '}';
    }
}
