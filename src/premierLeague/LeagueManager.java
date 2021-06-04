/*
Name-Vishani Raveendran
Uow Id-W1789961
IIT Id-2019710
References
==========
https://www.geeksforgeeks.org/comparator-interface-java/
https://www.javatpoint.com/Comparator-interface-in-collection-framework
https://www.tutorialspoint.com/java/java_interfaces.htm#:~:text=An%20interface%20is%20a%20reference,static%20methods%2C%20and%20nested%20types.
 */
package premierLeague;

import java.io.IOException;
import java.util.ArrayList;

public interface LeagueManager {

    //----------------Adding a club----------------//
    public void addClub(FootballClub club) throws IOException;
    //---------------------Deleting a member-----------------//
    public void deleteClub(String nameOfTheSportsClub);
    //------------------Display statistics---------------------------//
    public void displayStatistics(String nameOfTheSportsClub);
    //------------------Display table---------------------------//
    public void displayPremierLeagueTable();
    //------------------Adding played match---------------------------//
    public void addPlayedMatch(Date date,String homeTeam, String awayTeam, int homeTeamGoalScored, int awayTeamGoalScored) throws IOException;
    //------------------Saving club details to file ---------------------------//
    public void saveClubDetails(String fileName) throws IOException;
    //------------------Saving match details to file ---------------------------//
    public void saveMatchDetails(String fileName) throws IOException;
    //--------------------Retrieving club details-----------------//
    public void retrieveClubDetails(String fileName) throws IOException, ClassNotFoundException;
    //--------------------Retrieving match details-----------------//
    public void retrieveMatchDetails(String fileName) throws IOException, ClassNotFoundException;
    public ArrayList<FootballClub> getFootballClubArrayList();
    public ArrayList<AddMatch> getMatchArrayListList();
    void openCustomerGUI();






}
