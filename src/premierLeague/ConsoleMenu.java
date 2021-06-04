package premierLeague;

import javafx.application.Application;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenu {
    //Creating object for premierLeagueManager class
    public final static LeagueManager premierLeaguesManagerObj = new PremierLeagueManager();
    public static void main(String[] args) throws IOException {
        retrieveData();//Calling retrieve method

        //--creating a new scanner variable--//
        Scanner input = new Scanner(System.in);
        System.out.println("**************************************************************************************************");
        System.out.print("*                                       W E L C O M E                                            *\n");
        System.out.print("*                                            T O                                                 *\n");
        System.out.print("*                        P R E M I E R   L E A G U E   C H A M P I O N S H I P                   *\n");
        System.out.println("**************************************************************************************************");
        menu://Used to exit the program

        while (true){
            //-----------------------------------------------display message---------------------------------------------//
            System.out.println(" ");
            System.out.println("|----------Select an option----------|");
            System.out.println("Premier League menu: ");
            System.out.println("Enter \"1\" to add a football club  ");
            System.out.println("Enter \"2\" to delete a football club ");
            System.out.println("Enter \"3\" to display statistics of the club ");
            System.out.println("Enter \"4\" to display the premier league table ");
            System.out.println("Enter \"5\" to add match ");
            System.out.println("Enter \"6\" to save details ");
            System.out.println("Enter \"7\" to display GUI in javafx ");
            System.out.println("Enter \"8\" to quit ");
            System.out.print("Enter option: ");
            String enteredOption = input.next();

            //-----Converting string input into integer----//
            int choice = 0;
            try {
                choice = Integer.parseInt(enteredOption);
            } catch (Exception e) {}

            //------Switch and case statement------//
            switch (choice) {
                case 1:
                    addClub();//calls the addClub method
                    break;
                case 2:
                    deleteClub();//calls the deleteClub method
                    break;
                case 3:
                    displayStatistics();//calls the displayStatistics method
                    break;
                case 4:
                    premierLeaguesManagerObj.displayPremierLeagueTable();//calls displayPremierLeagueTable method from premierLeaguesManager class
                    break;
                case 5:
                    addPlayedMatch();//calls the addMatch method
                    break;
                case 6:
                    premierLeaguesManagerObj.saveClubDetails("clubDetails.txt");//calls saveData method from premierLeaguesManager class
                    premierLeaguesManagerObj.saveMatchDetails("matchDetails.txt");//calls saveData method from premierLeaguesManager class
                    System.out.println("Saved successfully");
                    break ;
                case 7:
                    Application.launch(DataViewTable.class,args);//calls application
                    break;
                case 8:
                    break menu;//exits the program
                default:
                    System.out.print("You have entered an incorrect option...\nPlease enter a correct option from (1,2,3,4,5,6) only...\n\n ");
            }
        }
    }

    //--------Implementing a method to add the club details--------//
    private static void addClub() throws IOException {
        FootballClub club;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter name of the club: ");
        String nameOfTheSportsClub = input.nextLine();

        //-----------Checking whether user entered name correctly-----------//
        while(!nameOfTheSportsClub.matches("[a-zA-Z]+"))//Reference:/https://www.javatpoint.com/java-regex
             {
                 System.out.println("Invalid name entered! Please enter valid club name ");
                 System.out.println("Enter name of the club: ");
                 nameOfTheSportsClub = input.nextLine();
            }

        System.out.println("Enter location of the club: ");
        String locationOfTheSportsClub = input.nextLine();

        //-----------Checking whether user entered location name correctly-----------//
        while(!locationOfTheSportsClub.matches("[a-zA-Z]+"))//Reference:/https://www.javatpoint.com/java-regex
            {
                System.out.println("Invalid name entered! Please enter valid location name ");
                System.out.println("Enter location of the club: ");
                locationOfTheSportsClub = input.nextLine();
            }


        club = new FootballClub(nameOfTheSportsClub, locationOfTheSportsClub, 0, 0, 0, 0, 0, 0, 0, 0 );//Creating object
        premierLeaguesManagerObj.addClub(club);//Calling addClub method from premierLeagueManager class
        premierLeaguesManagerObj.saveClubDetails("clubDetails.txt");//calls saveData method from premierLeaguesManager class
        premierLeaguesManagerObj.saveMatchDetails("matchDetails.txt");//calls saveData method from premierLeaguesManager class
    }


    //--------Implementing a method to  delete the club using name of the club--------//
    private  static void deleteClub() throws IOException {
        System.out.println("Enter the name of the club you want to remove: ");
        Scanner sc =new Scanner(System.in);
        String nameOfTheClub = sc.nextLine();

        //-----------Checking whether user entered correct name correctly-----------//
        while(!nameOfTheClub.matches("[a-zA-Z]+"))//Reference:/https://www.javatpoint.com/java-regex
             {
                 System.out.println("Invalid name entered! Please enter valid club name ");
                 System.out.println("Enter the name of the club you want to remove: ");
                 nameOfTheClub = sc.nextLine();
            }

        premierLeaguesManagerObj.deleteClub(nameOfTheClub);//Calling deleteClub method from premierLeagueManager class
        premierLeaguesManagerObj.saveClubDetails("clubDetails.txt");//calls saveData method from premierLeaguesManager class
        premierLeaguesManagerObj.saveMatchDetails("matchDetails.txt");//calls saveData method from premierLeaguesManager class
    }


    //--------Implementing a method to to display statistics using club name--------//
    private static void displayStatistics() {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the name of club that should display statistics: ");
        String name = sc.nextLine();

        //-----------Checking whether user entered correct name correctly-----------//
        while(!name.matches("[a-zA-Z]+"))//Reference:/https://www.javatpoint.com/java-regex
            {
                System.out.println("Invalid name entered! Please enter valid club name ");
                System.out.println("Enter the name of club that should display statistics: ");
                name = sc.nextLine();
            }
        premierLeaguesManagerObj.displayStatistics(name);//Calling displayStatistics method from premierLeagueManager class
    }

    //--------Implementing a method to to add played match details--------//
    private static void addPlayedMatch() throws IOException {
        Scanner sc = new Scanner(System.in);
        //----------------Checking whether user enter day between 1-31------------//
        int day = 0 ;//Reference-https://www.javacodex.com/Other-Java-Examples/Scanner-That-Only-Takes-Valid-Numbers
        boolean validDay = false;
        while(! validDay ) {
            System.out.print("Enter day between 1-31: ");
            try {
                day = sc.nextInt();
                if(day >= 1 && day <= 31){
                    validDay = true;
                } else {
                    System.out.println("Out of range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid day!!");
                sc.next();
            }
        }

        //----------------Checking whether user enter month between 1-12------------//
        int month=0;//Reference-https://www.javacodex.com/Other-Java-Examples/Scanner-That-Only-Takes-Valid-Numbers
        boolean validMonth = false;
        while(! validMonth ) {
            System.out.print("Month: ");
            try {
                month = sc.nextInt();
                if (month>0 && month<=12) {
                    validMonth = true;
                } else {
                    System.out.println("Out of range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid number!!");
                sc.next();
            }
        }

        //----------------Checking whether user enter year above 2000------------//
        int year=0;//Reference-https://www.javacodex.com/Other-Java-Examples/Scanner-That-Only-Takes-Valid-Numbers
        boolean validYear = false;
        while(! validYear ) {
            System.out.print("Year: ");
            try {
                year = sc.nextInt();
                if(year >= 1990){
                    validYear = true;
                } else {
                    System.out.println("Out of range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid number!!");
                sc.next();
            }
        }

        Date date =new Date(day,month,year);

        System.out.println("Match played date: " + date.toString());
        System.out.println("Enter Home Team name: ");
        String homeTeam = sc.next();
        //-----------Checking whether user entered home team name correctly-----------//
        while(!homeTeam.matches("[a-zA-Z]+")){
            System.out.println("Invalid name entered! Please enter valid home team name ");
            System.out.println("Enter Home Team name: ");
            homeTeam=sc.next();
        }

        //----------------Checking whether user entered integer for number of home goals ------------//
        int  homeGoal=0;
        System.out.println("Enter home team goals: ");
        boolean homeGoalValid = false;
        while (!homeGoalValid) {
            if (sc.hasNextInt()) {
                homeGoal = sc.nextInt();
                homeGoalValid = true;
            } else if (!sc.hasNextInt()) {
                System.out.println("Please enter number only");
                System.out.println("Enter the home team goals: ");
                sc.next();
            }
        }

        System.out.println("Enter Away Team: ");
        String awayTeam = sc.next();
        //-----------Checking whether user entered away team name correctly-----------//
        while(!awayTeam.matches("[a-zA-Z]+")){
            System.out.println("Invalid name entered! Please enter valid away team name ");
            System.out.println("Enter Away Team name: ");
            awayTeam=sc.next();
        }

        //----------------Checking whether user entered integer for number of away goals ------------//
        int awayGoal=0;
        System.out.println("Enter away team goals: ");
        boolean awayGoalValid = false;
        while (!awayGoalValid) {
            if (sc.hasNextInt()) {
                awayGoal = sc.nextInt();
                awayGoalValid = true;
            } else if (!sc.hasNextInt()) {
                System.out.println("Please enter number only");
                System.out.println("Enter the home team goals: ");
                sc.next();
            }
        }
        premierLeaguesManagerObj.addPlayedMatch(date,homeTeam,awayTeam,homeGoal,awayGoal);//Calling addPlayedMatch method from premierLeagueManager class
        premierLeaguesManagerObj.saveClubDetails("clubDetails.txt");//calls saveData method from premierLeaguesManager class
        premierLeaguesManagerObj.saveMatchDetails("matchDetails.txt");//calls saveData method from premierLeaguesManager class
    }


    //--------Implementing a method to retrieve club details--------//
    private static void retrieveData(){
        try{
            premierLeaguesManagerObj.retrieveClubDetails("clubDetails.txt");
            premierLeaguesManagerObj.retrieveMatchDetails("matchDetails.txt");
            premierLeaguesManagerObj.getFootballClubArrayList();
            premierLeaguesManagerObj.getMatchArrayListList();
        }catch (IOException E){
            System.out.println("Nothing found");
        }catch (ClassNotFoundException e ){
            System.out.println("Nothing found");
        }
    }

}

