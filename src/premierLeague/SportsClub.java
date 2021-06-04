package premierLeague;
/*
Name-Vishani Raveendran
Uow Id-W1789961
IIT Id-2019710
References
==========
https://medium.com/110/what-is-java-pojo-class-and-java-bean-class-with-example-e63c4c0811a9
https://data-flair.training/blogs/pojo-class-in-java/
https://www.tutorialspoint.com/pojo-vs-java-beans
https://www.edureka.co/blog/pojo-in-java/
*/

import java.io.Serializable;
import java.util.Objects;

public class SportsClub implements Serializable {
    //---------Instance Variables----------//
    private String nameOfTheSportsClub;
    private String locationOfTheSportsClub;


    //-------------------Default Constructor-------------------//
    public SportsClub(){
    }

    //-------------------Parameterized Constructor-------------------//
    public SportsClub(String nameOfTheSportsClub, String locationOfTheSportsClub) {
        this.nameOfTheSportsClub = nameOfTheSportsClub;
        this.locationOfTheSportsClub = locationOfTheSportsClub;
    }

    //-----------------------Getter for name of the club-----------------------//
    public String getNameOfTheSportsClub() {
        return nameOfTheSportsClub;
    }

    //-----------------------Setter for name of the club-----------------------//
    public void setNameOfTheSportsClub(String nameOfTheSportsClub) {
        this.nameOfTheSportsClub = nameOfTheSportsClub;
    }

    //-----------------------Getter for location of the club-----------------------//
    public String getLocationOfTheSportsClub() {
        return locationOfTheSportsClub;
    }

    //-----------------------Setter for location of the club-----------------------//
    public void setLocationOfTheSportsClub(String locationOfTheSportsClub) {
        this.locationOfTheSportsClub = locationOfTheSportsClub;
    }

    //-----------------------toString() method-----------------------//
    @Override
    public String toString() {
        return "SportsClub{" +
                "Name of the club = '" + nameOfTheSportsClub + '\'' +
                ", Location of the club ='" + locationOfTheSportsClub + '\'' +
                '}';
    }

    //-----------------------Equals method-----------------------//
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub club = (SportsClub) o;
        return Objects.equals(nameOfTheSportsClub, club.nameOfTheSportsClub);
    }

    //-----------------------Hash code-----------------------//
    @Override
    public int hashCode() {
        return Objects.hash(nameOfTheSportsClub, locationOfTheSportsClub);
    }
}

