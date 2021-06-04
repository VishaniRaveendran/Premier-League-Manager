package premierLeague;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Date implements Serializable {
    private int month; //1-12
    private int day;   //1-31 based on month
    private int year;  //any year
    Scanner obj=new Scanner(System.in);


    //----------------Constructor--------------//
    public Date(int day, int month, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public Date() {

    }

    //--------------getter for month--------------//
    public int getMonth() {
        return month;
    }

    //-------------setter for month------------//
    public void setMonth(int month) {
        this.month=month;
    }

    //-----------------getter for day--------------//
    public int getDay() {
        return day;
    }

    //--------------setter for day-------------//
    public void setDay(int day) {
        this.day=day;
    }

    //-------------getter for year----------//
    public int getYear() {
        return year;
    }

    //------------setter for year----------//
    public void setYear(int year) {
        this.year=year;
    }

    //----------------toString------------------//
    public String toString(){
        return String.format(day+"/"+month+"/"+year);
    }
}
