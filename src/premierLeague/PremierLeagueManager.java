/*
Name-Vishani Raveendran
Uow Id-W1789961
IIT Id-2019710
References
==========
https://www.geeksforgeeks.org/comparator-interface-java/
https://www.javatpoint.com/Comparator-interface-in-collection-framework
https://www.tutorialspoint.com/java/java_interfaces.htm#:~:text=An%20interface%20is%20a%20reference,static%20methods%2C%20and%20nested%20types
https://drive.google.com/file/d/1jrjR7DW7ZzkJNZw9otE452o_xzSPqD57/view?usp=sharing
 */


package premierLeague;


import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.Integer.parseInt;


public class PremierLeagueManager implements LeagueManager {
    public static final int MAX_COUNT = 20;//Declaring maximum clubs in league as 20
    public ArrayList<FootballClub> footballClubsArrayList = new ArrayList<>();//Arraylist to store the details of football club
    public ArrayList<AddMatch> matchPlayedArrayList = new ArrayList<>();//Arraylist to store the details of added matches


    //----------------Adding a club----------------//
    //Reference: https://drive.google.com/drive/folders/1ohFI-awWUFmPvaTSuPQkRSCji1HLbhJT
    @Override
    public void addClub(FootballClub club) throws IOException {
        //------------Checking whether club is already added to the premier league---------//
        for (FootballClub club1 : footballClubsArrayList) {
            if (club.equals(club1)) {
                System.out.println(club.getNameOfTheSportsClub() + " is already added in the league");
                return;
            }
        }
        //--------Checking whether footBallClub arraylist is less than maximum count of club-------//
        if (footballClubsArrayList.size() < MAX_COUNT)
        {
            //---Adding club details to the arraylist---//
            footballClubsArrayList.add(club);
            System.out.println(club.getNameOfTheSportsClub() + " is successfully added.");
            System.out.println("No of free slots: " + (20 - footballClubsArrayList.size()));
        } else {
            System.out.println("No free slots are available to add club");
        }
    }

    //---------------------Deleting a member-----------------//
    //Reference: https://drive.google.com/drive/folders/1ohFI-awWUFmPvaTSuPQkRSCji1HLbhJT
    @Override
    public void deleteClub(String nameOfTheSportsClub) {
        //------------Checking whether clubArrayList contains any clubs---------//
        if (footballClubsArrayList.isEmpty()) {
            System.out.println("No sports clubs are added");
        } else {
            boolean footballClubFound = false;
            for (FootballClub club : footballClubsArrayList) {
                //-------If club name entered equals to the name of the club in the football club arraylist---------//
                if (club.getNameOfTheSportsClub().equals(nameOfTheSportsClub)) {
                    footballClubFound = true;
                    //-------------Removing the club from arraylist----------//
                    footballClubsArrayList.remove(club);
                    System.out.printf("%s is successfully removed", nameOfTheSportsClub);
                    System.out.println(" ");
                    System.out.println("No of free slots: " + (20 - footballClubsArrayList.size()));
                    break;
                }
            }
            if (!footballClubFound) {
                System.out.printf("%s is not available\n", nameOfTheSportsClub);
                System.out.println(" ");
            }
        }
    }


    //------------------Display statistics---------------------------//
    //Reference: https://drive.google.com/drive/folders/1ohFI-awWUFmPvaTSuPQkRSCji1HLbhJT
    @Override
    public void displayStatistics(String nameOfTheSportsClub) {
        //------------Checking whether clubArrayList contains any clubs---------//
        if (footballClubsArrayList.isEmpty()) {
            System.out.println("No sports clubs are added");
        } else {
            boolean footballClubFound = false;
            for (FootballClub club : footballClubsArrayList) {
                if (club.getNameOfTheSportsClub().equals(nameOfTheSportsClub)) {
                    footballClubFound = true;
                    System.out.println("Statistics");
                    System.out.println("----------");
                    System.out.println("Club name                : " + club.getNameOfTheSportsClub());
                    System.out.println("Number of matches won    : " + club.getNumberOfFootballMatchWins());
                    System.out.println("Number of matches lost   : " + club.getNumberOfFootballMatchLoss());
                    System.out.println("Number of matches draw   : " + club.getNumberOfFootballMatchDraw());
                    System.out.println("Total matches played     : " + (club.getNumberOfFootballMatchWins() + club.getNumberOfFootballMatchLoss() + club.getNumberOfFootballMatchDraw()));
                    System.out.println("Number of goals scored   : " + club.getNumberOfFootballGoalsScored());
                    System.out.println("Number of goals conceded : " + club.getNumberOfFootballGoalsReceived());
                    System.out.println("Goal Difference          : " + (club.getNumberOfFootballGoalsScored() - club.getNumberOfFootballGoalsReceived()));
                    System.out.println("Total points             : " + club.getNumberOfPoints());
                    return;
                }
            }
            if (!footballClubFound) {
                System.out.printf("%s is not available\n", nameOfTheSportsClub);
                System.out.println("");
            }
        }
    }

    //-----------------------------Display statistics---------------------------//
    //Reference:https://stackoverflow.com/questions/2745206/output-in-a-table-format-in-javas-system-out
    @Override
    public void displayPremierLeagueTable() {
        if (footballClubsArrayList.isEmpty()) {
            System.out.println("No sports clubs are added");
        } else {
            System.out.println("                                                        PREMIERE LEAGUE TABLE                                                                     ");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("|   %8s   |   %13s   |  %4s   |   %4s   |   %4s   |   %10s   |   %10s   |   %10s   |   %6s   |\n", "CLUB NAME", "MATCHES PLAYED", "WIN", "DRAW", "LOSS", "GOALS SCORED", "GOALS CONCEDED", "GOALS DIFFERENCE", "POINTS");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
            //--------------------Sorting points in descending order--------------------//
            Collections.sort(footballClubsArrayList, new pointsSorting());
            //-------------------Adding data into table-----------------//
            for (FootballClub leagueTable : footballClubsArrayList) {
                System.out.printf("|%9s %18s %14s %10s %10s %14s %19s %20s %15s       |\n", leagueTable.getNameOfTheSportsClub(), leagueTable.getNumberOfFootballMatchesPlayed(), leagueTable.getNumberOfFootballMatchWins(), leagueTable.getNumberOfFootballMatchDraw(), leagueTable.getNumberOfFootballMatchLoss(), leagueTable.getNumberOfFootballGoalsScored(), leagueTable.getNumberOfFootballGoalsReceived(), (leagueTable.getNumberOfFootballGoalsScored() - leagueTable.getNumberOfFootballGoalsReceived()), leagueTable.getNumberOfPoints());
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }

    // -----------Sorting in descending order of points-------------//
    /*Reference:https://www.geeksforgeeks.org/comparator-interface-java/
                https://www.javatpoint.com/Comparator-interface-in-collection-framework */
    static class pointsSorting implements Comparator<FootballClub> {
        @Override
        public int compare(FootballClub club1, FootballClub club2) {
            // -----------Sorting numberOfPoints descending order-------------//
            if (club1.getNumberOfPoints() > club2.getNumberOfPoints())
                return -1;
            else if (club1.getNumberOfPoints() < club2.getNumberOfPoints())
                return 1;
            else {
                // -----------Sorting goalDifference descending order-------------//
                int goalDifference1 = club1.getNumberOfFootballGoalsScored() - club1.getNumberOfFootballGoalsReceived();
                int goalDifference2 = club2.getNumberOfFootballGoalsScored() - club2.getNumberOfFootballGoalsReceived();
                if (goalDifference1 > goalDifference2)
                    return -1;
                else if (goalDifference1 < goalDifference2)
                    return 1;
                else return 0;
            }
        }
    }


    //--------------------------------Adding Played match--------------------------------------//
    @Override
    public void addPlayedMatch(Date date, String homeTeam, String awayTeam, int homeTeamGoalScored, int awayTeamGoalScored) throws IOException {
        //Checking whether list is empty or not
        if (footballClubsArrayList.isEmpty()) {
            System.out.println("No sports clubs are added");
        } else {
            //------------Initialising null value--------//
            FootballClub homeClub = null;

            //-------------Checking whether home team name is equal to name of the sport club-----------//
            for (FootballClub club : footballClubsArrayList) {
                if (club.getNameOfTheSportsClub().equals(homeTeam)) {
                    homeClub = club;
                }
            }

            //-------------Checking whether homeTeam is available in premier league--------------//
            if (homeClub == null) {
                System.out.printf("%s is not available in the premier league", homeTeam);
                System.out.println(" ");
                return;
            }

            //------------Initialising null value--------//
            FootballClub awayClub = null;

            //-------------Checking whether awayTeam name is equal to name of the sport club-----------//
            for (FootballClub club : footballClubsArrayList) {
                if (club.getNameOfTheSportsClub().equals(awayTeam)) {
                    awayClub = club;
                }
            }

            //-------------Checking whether homeTeam is available in premier league-----------//
            if (awayClub == null) {
                System.out.printf("%s is not available in the premier league", awayTeam);
                System.out.println(" ");
                return;
            }

            //-------------Checking whether homeTeam number of goals are greater than -1-----------//
            if (homeTeamGoalScored <= -1) {
                System.out.println("You have to enter number of goals(number of goals always positive)");
                return;
            }

            //-------------Checking whether awayTeam number of goals are greater than -1-----------//
            if (awayTeamGoalScored <= -1) {
                System.out.println("You have to enter number of goals(number of goals always positive)");
                return;
            }

            //-------------------creating object of class newMatch-----------------//
            AddMatch newMatch = new AddMatch(homeTeam, awayTeam, homeTeamGoalScored, awayTeamGoalScored,date.toString());
            //------------setting homeClub to team1--------//
            newMatch.setTeam1Name(homeTeam);
            //------------setting awayClub to team2--------//
            newMatch.setTeam2Name(awayTeam);
            //------------setting homeClubScore to team1Score--------//
            newMatch.setTeam1Score(homeTeamGoalScored);
            //------------setting awayClubScore to team2Score--------//
            newMatch.setTeam2Score(awayTeamGoalScored);
            //----------Adding new match details to the arraylist--------//
            matchPlayedArrayList.add(newMatch);
            System.out.println(newMatch.toString());
            System.out.println("Match is successfully added");
            //----------Setting numberOfGoalScores for homeClub---------//
            homeClub.setNumberOfFootballGoalsScored(homeClub.getNumberOfFootballGoalsScored() + homeTeamGoalScored);
            //----------Setting numberOfGoalScores for awayClub---------//
            awayClub.setNumberOfFootballGoalsScored(awayClub.getNumberOfFootballGoalsScored() + awayTeamGoalScored);
            //----------Setting numberOfGoalReceived for homeClub---------//
            homeClub.setNumberOfFootballGoalsReceived(homeClub.getNumberOfFootballGoalsReceived() + awayTeamGoalScored);
            //----------Setting numberOfGoalReceived for awayClub---------//
            awayClub.setNumberOfFootballGoalsReceived(awayClub.getNumberOfFootballGoalsReceived() + homeTeamGoalScored);
            //----------Setting numberOfMatchPlayed for homeClub---------//
            homeClub.setNumberOfFootballMatchesPlayed(homeClub.getNumberOfFootballMatchesPlayed() + 1);
            //----------Setting numberOfMatchPlayed for awayClub---------//
            awayClub.setNumberOfFootballMatchesPlayed(awayClub.getNumberOfFootballMatchesPlayed() + 1);

            //--------If homeTeam goalsScored is high---------//
            if (homeTeamGoalScored > awayTeamGoalScored) {
                homeClub.setNumberOfPoints(homeClub.getNumberOfPoints() + 3);// adding 3 points to the homeClub
                homeClub.setNumberOfFootballMatchWins(homeClub.getNumberOfFootballMatchWins() + 1);// Increasing count of match win to the homeClub
                awayClub.setNumberOfFootballMatchLoss(awayClub.getNumberOfFootballMatchLoss() + 1);// Increasing count of match loss to the awayClub
            }

            //--------If awayTeam goalsScored is high---------//
            else if (homeTeamGoalScored < awayTeamGoalScored) {
                awayClub.setNumberOfPoints(awayClub.getNumberOfPoints() + 3);// adding 3 points to the awayClub
                awayClub.setNumberOfFootballMatchWins(awayClub.getNumberOfFootballMatchWins() + 1);// Increasing count of match win to the awayClub
                homeClub.setNumberOfFootballMatchLoss(homeClub.getNumberOfFootballMatchLoss() + 1);// Increasing count of match win to the awayClub
            }
            //----------------If homeTeam goalsScored equals to awayTeam goalScored-----------//
            else {
                homeClub.setNumberOfPoints(homeClub.getNumberOfPoints() + 1);//adding 1 point to home club
                awayClub.setNumberOfPoints(awayClub.getNumberOfPoints() + 1);//adding 1 point away club
                homeClub.setNumberOfFootballMatchDraw(homeClub.getNumberOfFootballMatchDraw() + 1);// Increasing count of match draw to the homeClub
                awayClub.setNumberOfFootballMatchDraw(awayClub.getNumberOfFootballMatchDraw() + 1);// Increasing count of match draw to the awayClub
            }
        //saving details
        saveClubDetails("clubDetails.txt");
        saveMatchDetails("matchDetails.txt");
        }
    }

    //---------------------Converting clubDetails file into arraylist-----------------//
    public ArrayList<FootballClub> getFootballClubArrayList() {
        //-------------------Pass the filename--------------------//
        File footballClubDetailsFile = new File("clubDetails.txt");
        try {
            //-----------------Attaching the file to FileInputStream-----------//
            FileInputStream fInputStream = new FileInputStream(footballClubDetailsFile);
            //-----------Create an ObjectInputStream for the file-----------//
            ObjectInputStream oInputStream = new ObjectInputStream(fInputStream);
            //--------------Reading all objects from file----------//
            footballClubsArrayList = (ArrayList<FootballClub>) oInputStream.readObject();//Reference:https://stackoverflow.com/questions/52791259/java-how-to-make-objectinputstream-read-all-objects-from-file
            oInputStream.close();
            return footballClubsArrayList;
        } catch (IOException e) {
            return footballClubsArrayList;
        }catch (ClassNotFoundException f){
            return footballClubsArrayList;
        }
    }

    //---------------------Converting matchDetails into arraylist-----------------//
    public ArrayList<AddMatch> getMatchArrayListList() {
        //-------------------Pass the filename--------------------//
        File matchPlayedDetailsFile = new File("matchDetails.txt");
        try {
            //-----------------Attaching the file to FileInputStream-----------//
            FileInputStream fInputStream = new FileInputStream(matchPlayedDetailsFile);
            //-----------Create an ObjectInputStream for the file-----------//
            ObjectInputStream oInputStream = new ObjectInputStream(fInputStream);
            //--------------Reading all objects from file----------//
            matchPlayedArrayList =(ArrayList<AddMatch>)oInputStream.readObject();//Reference:https://stackoverflow.com/questions/52791259/java-how-to-make-objectinputstream-read-all-objects-from-file
            //--closing the stream--//
            oInputStream.close();
            return matchPlayedArrayList;
        } catch (Exception e) {
            return matchPlayedArrayList;
        }
    }

    //---------------------Saving club details-----------------------//
    public void saveClubDetails(String fileName){
        try {
            //-----------------Attaching the file to FileInputStream-----------//
            FileOutputStream fOutputStream = new FileOutputStream(fileName);
            //-----------Create an ObjectInputStream for the file-----------//
            ObjectOutputStream oOutStream = new ObjectOutputStream(fOutputStream);
            //------Write the specified object to the ObjectOutputStream------//
            oOutStream.writeObject(footballClubsArrayList);
            //--flushing the stream--//
            oOutStream.flush();
            //--closing the stream--//
            fOutputStream.close();
            //--closing the stream--//
            oOutStream.close();
        } catch (IOException e) {
            System.out.println("Oops!! Something went wrong.");
        }
    }

    //---------------------Saving matches details-----------------------//
    public void saveMatchDetails(String fileName) {
        try {
            //-----------------Attaching the file to FileInputStream-----------//
            FileOutputStream fOutStream = new FileOutputStream(fileName);
            //-----------Create an ObjectInputStream for the file-----------//
            ObjectOutputStream oOutStream = new ObjectOutputStream(fOutStream);
            //------Write the specified object to the ObjectOutputStream------//
            oOutStream.writeObject(matchPlayedArrayList);
            //--flushing the stream--//
            oOutStream.flush();
            //--closing the stream--//
            fOutStream.close();
            //--closing the stream--//
            oOutStream.close();
        }catch (IOException e){
            System.out.println("Oops!! Something went wrong.");
        }

    }

    //-----------------------Retrieving data from the club details---------------------//
    public void retrieveClubDetails(String fileName) throws IOException, ClassNotFoundException {
        //-----------------Attaching the file to FileInputStream-----------//
        FileInputStream fInputStream = new FileInputStream(fileName);
        //-----------Create an ObjectInputStream for the file-----------//
        ObjectInputStream oInputStream = new ObjectInputStream(fInputStream);
        for (; ; ) {
            try {
                FootballClub club = (FootballClub) oInputStream.readObject();
                footballClubsArrayList.add(club);
            } catch (EOFException e) {
                break;
            }catch (ClassCastException e){}
        }
        //--closing the stream--//
        fInputStream.close();
        //--closing the stream--//
        oInputStream.close();
        System.out.println("Club details has been loaded successfully");
    }

    //-----------------------Retrieving data from the club details---------------------//
    public void retrieveMatchDetails(String fileName) throws IOException {
        //-----------------Attaching the file to FileInputStream-----------//
        FileInputStream fInputStream = new FileInputStream(fileName);
        //-----------Create an ObjectInputStream for the file-----------//
        ObjectInputStream oInputStream = new ObjectInputStream(fInputStream);
        for (; ; ) {
            try {
                AddMatch match1 = (AddMatch) oInputStream.readObject();
                matchPlayedArrayList.add(match1);
            } catch (Exception e) {
                break;
            }
        }
        //--closing the stream--//
        fInputStream.close();
        //--closing the stream--//
        oInputStream.close();
        System.out.println("Match details has been loaded successfully");
        }


        //Reference:https://www.geeksforgeeks.org/compare-dates-in-java/
        static class dateSorting implements Comparator<AddMatch>{
        @Override
        public int compare(AddMatch playedMatchDate1, AddMatch matchPlayed2) {
            String slash = "/";
            // Get the two dates to be compared
            String[] matchDate1;
            matchDate1 = playedMatchDate1.getDate().split(slash);
            String[] matchDate2;
            matchDate2 = matchPlayed2.getDate().split(slash);
            if (parseInt(matchDate1[2]) > parseInt(matchDate2[2]))
                return 1;
            else if (parseInt(matchDate1[2]) < parseInt(matchDate2[2]))
                return -1;
            else {
                if (parseInt(matchDate1[1]) > parseInt(matchDate2[1]))
                    return 1;
                else if (parseInt(matchDate1[1]) < parseInt(matchDate2[1]))
                    return -1;
                else {
                    if (parseInt(matchDate1[0]) > parseInt(matchDate2[0]))
                        return 1;
                    else if (parseInt(matchDate1[0]) < parseInt(matchDate2[0]))
                        return -1;
                    else
                        return 0;
                }
            }
        }



        }

    public void openCustomerGUI(){
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("http://localhost:4200");
            desktop.browse(oURL);
        } catch (Exception e) {
            System.out.println("Please check your connection, something went wrong!");
        }
    }
}
