package premierLeague;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.*;


public class DataViewTable extends Application {
    // launch the application
    public static void main(String[] args) {
        launch(args);
    }

    //Creating object for premierLeagueManager class
    private final static LeagueManager premierLeagueManager = new PremierLeagueManager();


    public static void show() {
        //-----------------------Creates a new empty observable list that is backed by an arraylist--------------------------//
        ObservableList<FootballClub> footballClubsObservableList = FXCollections.observableArrayList(premierLeagueManager.getFootballClubArrayList());
        //----create a Stage----//
        Stage clubStage = new Stage();
        // create a scene
        Scene scene = new Scene(new Group());
        // set title for the Stage
        clubStage.setTitle("Premier League Management System");

        // create a labelRandom
        Label lab = new Label("Premier League Championship");
        lab.setStyle("-fx-font: 70px Georgia;" + "-fx-font-weight: bold;" + "-fx-text-fill:#ccddff;" + "-fx-text-alignment: center;");

        // create table view
        TableView tableVw = new TableView();
        tableVw.setStyle("-fx-background-color: black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-insets: 4;");
        tableVw.setPrefSize(1000, 625);
        tableVw.setLayoutY(100);
        tableVw.setEditable(false);

        // create clubName column
        TableColumn<String, FootballClub> clubName = new TableColumn<>("Club Name");
        clubName.setCellValueFactory(new PropertyValueFactory<>("nameOfTheSportsClub"));
        clubName.setPrefWidth(150);
        clubName.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:white;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // create win column
        TableColumn<Integer, FootballClub> noOfMatchWin = new TableColumn<>("Win");
        noOfMatchWin.setCellValueFactory(new PropertyValueFactory<>("numberOfFootballMatchWins"));
        noOfMatchWin.setPrefWidth(100);
        noOfMatchWin.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // create loss column
        TableColumn<Integer, FootballClub> noOfMatchLoss = new TableColumn<>("Loss");
        noOfMatchLoss.setCellValueFactory(new PropertyValueFactory<>("numberOfFootballMatchLoss"));
        noOfMatchLoss.setPrefWidth(100);
        noOfMatchLoss.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // create draw column
        TableColumn<Integer, FootballClub> noOfMatchDraw = new TableColumn<>("Draw");
        noOfMatchDraw.setCellValueFactory(new PropertyValueFactory<>("numberOfFootballMatchDraw"));
        noOfMatchDraw.setPrefWidth(100);
        noOfMatchDraw.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // create total match played column
        TableColumn<Integer, FootballClub> totalMatchPlayed = new TableColumn<>("Total Match Played");
        totalMatchPlayed.setCellValueFactory(new PropertyValueFactory<>("numberOfFootballMatchesPlayed"));
        totalMatchPlayed.setPrefWidth(150);
        totalMatchPlayed.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // create goal scored column
        TableColumn<Integer, FootballClub> goalScored = new TableColumn<>("Goal Scored");
        goalScored.setCellValueFactory(new PropertyValueFactory<>("numberOfFootballGoalsScored"));
        goalScored.setPrefWidth(120);
        goalScored.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // create goal conceded column
        TableColumn<Integer, FootballClub> goalConceded = new TableColumn<>("Goal Conceded");
        goalConceded.setCellValueFactory(new PropertyValueFactory<>("numberOfFootballGoalsReceived"));
        goalConceded.setPrefWidth(120);
        goalConceded.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // create goal difference column
        TableColumn<Integer, FootballClub> goalDifference = new TableColumn<>("Goal Difference");
        goalDifference.setCellValueFactory(new PropertyValueFactory<>("goalDifference"));
        goalDifference.setPrefWidth(120);
        goalDifference.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // create points column
        TableColumn<Integer, FootballClub> goalPoints = new TableColumn<>("Points");
        goalPoints.setCellValueFactory(new PropertyValueFactory<>("numberOfPoints"));
        goalPoints.setPrefWidth(148);
        goalPoints.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // Adding all columns to table
        tableVw.getColumns().addAll(clubName, totalMatchPlayed, noOfMatchWin, noOfMatchLoss, noOfMatchDraw, goalScored, goalConceded, goalDifference, goalPoints);

        // Sorting according to the points
        Collections.sort(footballClubsObservableList, new PremierLeagueManager.pointsSorting());
        // Adding details to the column
        for (FootballClub details : footballClubsObservableList) {
            FootballClub addRecord = new FootballClub(details.getNameOfTheSportsClub(), null, details.getNumberOfFootballMatchesPlayed(), details.getNumberOfFootballMatchWins(), details.getNumberOfFootballMatchLoss(), details.getNumberOfFootballMatchDraw(), details.getNumberOfFootballGoalsScored(), details.getNumberOfFootballGoalsReceived(), details.getGoalDifference(), details.getNumberOfPoints());
            tableVw.getItems().addAll(addRecord);
        }

        //------------Sort Button by goal scored----------//
        Button sortScoredButton = new Button();
        sortScoredButton.setText("Sort By Goal Scored");
        sortScoredButton.setLayoutX(95);
        sortScoredButton.setLayoutY(750);
        sortScoredButton.setStyle("-fx-background-color: linear-gradient(black,#265164);" + "-fx-text-fill:whitesmoke;" + "-fx-font-size: 16;" + "-fx-border-color: white;" + "-fx-pref-height: 60;" + "-fx-pref-width: 250;");
        sortScoredButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //--------------Sorting by Goal scored in descending order--------------//
                goalScored.setSortType(TableColumn.SortType.DESCENDING);
                tableVw.getSortOrder().setAll(goalScored);
            }
        });

        //------------Sort Button by no of wins----------//
        Button sortNoOfWin = new Button();
        sortNoOfWin.setText("Sort By No Of Wins");
        sortNoOfWin.setLayoutX(384);
        sortNoOfWin.setLayoutY(750);
        sortNoOfWin.setStyle("-fx-background-color: linear-gradient(black,#265164);" + "-fx-text-fill:whitesmoke;" + "-fx-font-size: 16;" + "-fx-border-color: white;" + "-fx-pref-height: 60;" + "-fx-pref-width: 250;");
        sortNoOfWin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //--------------Sorting by No of win in descending order--------------//
                noOfMatchWin.setSortType(TableColumn.SortType.DESCENDING);
                tableVw.getSortOrder().setAll(noOfMatchWin);
            }
        });

        //------Creating labelRandom to display random played match details--------//
        Label labelRandom = new Label();
        labelRandom.setLayoutX(550);
        labelRandom.setLayoutY(850);
        labelRandom.setStyle("-fx-font-weight: bolder;-fx-font-size: 18px;-fx-text-fill: white;-fx-font-size: 30px;-fx-background-color: linear-gradient(black,indigo); -fx-border-color: black;");

        //---------Random Played match details button----------//
        //Reference:https://stackoverflow.com/questions/3985392/generate-random-date-of-birth#:~:text=Random%20has%20a%20method%20that,but%20those%20should%20do%20it.&text=Snippet%20for%20a%20Java%208,minDay%20%3D%20(int)%20LocalDate.
        Button randomPlayedMatch = new Button();
        randomPlayedMatch.setText("Random Match");
        randomPlayedMatch.setLayoutX(675);
        randomPlayedMatch.setLayoutY(750);
        randomPlayedMatch.setStyle("-fx-background-color: linear-gradient(black,#265164);" + "-fx-text-fill:whitesmoke;" + "-fx-font-size: 16;" + "-fx-border-color: white;" + "-fx-pref-height: 60;" + "-fx-pref-width: 250;");
        randomPlayedMatch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // create instance of Random class
                Random rand = new Random();
                int year = (int) (35 * Math.random() + 1990);// Generating random for year
                int day;
                int month = (int) (12 * Math.random() + 1);// Generating random for month
                if (month == 2) {
                    day = (int) (28 * Math.random() + 1);// Generating random for day
                } else {
                    day = (int) (31 * Math.random() + 1);
                }

                Date matchPlayedDate = new Date(day, month, year);//Creating date object

                FootballClub club1 = anyClub();// Calling anyClub to generate random for club1 name
                FootballClub club2 = anyClub();//  Calling anyClub to generate random for club2 name

                // Checking whether generated club name are same
                if (club1 == club2) {
                    return;
                }

                int rand_score1 = rand.nextInt(10);// Generating random score for club 1
                int rand_score2 = rand.nextInt(10);// Generating random score for club 2

                try {
                    // Add match
                    premierLeagueManager.addPlayedMatch(matchPlayedDate, club1.getNameOfTheSportsClub(), club2.getNameOfTheSportsClub(), rand_score1, rand_score2);
                    tableVw.getItems();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    // save club details
                    premierLeagueManager.saveClubDetails("clubDetails.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    // save match details
                    premierLeagueManager.saveMatchDetails("matchDetails.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                labelRandom.setText(club1.getNameOfTheSportsClub() + "   " + rand_score1 + "    " + " -    " + rand_score2 + "    " + club2.getNameOfTheSportsClub());
            }

            // method to generate random football club name
            public FootballClub anyClub() {
                Random rand2 = new Random();
                int index = rand2.nextInt(footballClubsObservableList.size());
                FootballClub indexValue = footballClubsObservableList.get(index);
                return indexValue;
            }
        });

        //----------played match button----------//
        Button randomPlayedMatchDate = new Button();
        randomPlayedMatchDate.setText("Played Matches Details");
        randomPlayedMatchDate.setLayoutX(954);
        randomPlayedMatchDate.setLayoutY(750);
        randomPlayedMatchDate.setStyle("-fx-background-color: linear-gradient(black,#265164);" + "-fx-text-fill:whitesmoke;" + "-fx-font-size: 16;" + "-fx-border-color: white;" + "-fx-pref-height: 60;" + "-fx-pref-width: 250;");
        randomPlayedMatchDate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                matchTable();// Calling matchTable method
            }
        });

        //------------------Adding background image-----------------------------//
        Image image = new Image("file:football1.jpeg");
        ImageView img = new ImageView(image);
        img.setFitHeight(1300);
        img.setFitWidth(1290);
        Group rt1 = new Group();
        rt1.getChildren().addAll(img);

        //-------------create Vbox---------------//
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(20, 90, 0, 90));
        vbox.getChildren().addAll(lab, tableVw);

        //-------------------Returns the children of the pane------------------//
        ((Group) scene.getRoot()).getChildren().addAll(img, vbox, sortScoredButton, sortNoOfWin, randomPlayedMatch, labelRandom, randomPlayedMatchDate);

        clubStage.setScene(scene);
        clubStage.show();
        clubStage.setWidth(1300);
        clubStage.setHeight(990);
    }

    public static void matchTable() {
        //-----------------------Creates a new empty observable list that is backed by an arraylist--------------------------//
        final ObservableList<AddMatch> matchObservableList = FXCollections.observableArrayList(premierLeagueManager.getMatchArrayListList());
        //----create a stage----//
        Stage matchStage1 = new Stage();
        Scene scene1 = new Scene(new Group());
        //----------Set title for stage---------//
        matchStage1.setTitle("Match Details");

        //-----------------Label For heading----------//
        Label labelHead = new Label("Played matches");
        labelHead.setStyle("-fx-font: 70px Georgia;" + "-fx-font-weight: bold;" + "-fx-text-fill:#cfe2ff;" + "-fx-text-alignment: center;");

        // create tableView
        TableView tableVw1 = new TableView();
        tableVw1.setStyle("-fx-background-color: black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-insets: 4;");
        tableVw1.setPrefSize(740, 622);
        tableVw1.setLayoutY(200);
        tableVw1.setEditable(false);

        // create home team column
        TableColumn<String, AddMatch> homeClub = new TableColumn<>("Home Team");
        homeClub.setCellValueFactory(new PropertyValueFactory<>("team1Name"));
        homeClub.setPrefWidth(150);
        homeClub.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // create away club column
        TableColumn<String, AddMatch> awayClub = new TableColumn<>("Away Team");
        awayClub.setCellValueFactory(new PropertyValueFactory<>("team2Name"));
        awayClub.setPrefWidth(150);
        awayClub.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // create home club score column
        TableColumn<Integer, AddMatch> homeGoalScored = new TableColumn<>("Home Team Goals");
        homeGoalScored.setCellValueFactory(new PropertyValueFactory<>("team1Score"));
        homeGoalScored.setPrefWidth(150);
        homeGoalScored.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // create away club score column
        TableColumn<Integer, AddMatch> awayGoalScored = new TableColumn<>("Away Team Goals");
        awayGoalScored.setCellValueFactory(new PropertyValueFactory<>("team2Score"));
        awayGoalScored.setPrefWidth(150);
        awayGoalScored.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // create date column
        TableColumn<Date, AddMatch> matchPlayedDate = new TableColumn<>("Date");
        matchPlayedDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        matchPlayedDate.setPrefWidth(150);
        matchPlayedDate.setStyle("-fx-background-color: linear-gradient(#2a476e,#849fc4);" + "-fx-font-weight: bold;" + "-fx-text-fill:black;" + "-fx-border-color: -fx-box-border;" + "-fx-border-color: black;" + "-fx-text-alignment: center;");

        // Adding all columns to table
        tableVw1.getColumns().addAll(homeClub, awayClub, homeGoalScored, awayGoalScored, matchPlayedDate);

        // Sorting according to the points
        Collections.sort(matchObservableList, new PremierLeagueManager.dateSorting());

        // Adding details to the column
        for (AddMatch addMatchDetails : matchObservableList) {
            AddMatch addRecord = new AddMatch(addMatchDetails.getTeam1Name(), addMatchDetails.getTeam2Name(), addMatchDetails.getTeam1Score(), addMatchDetails.getTeam2Score(), String.valueOf(addMatchDetails.getDate()));
            tableVw1.getItems().addAll(addRecord);
        }

        //Passing the data to a filtered list
        FilteredList<AddMatch> filteredListDate = new FilteredList(matchObservableList, p -> true);
        tableVw1.setItems(filteredListDate);//Set the table's items using the filtered list

        //https://stackoverflow.com/questions/47559491/making-a-search-bar-in-javafx
        //-----------------------Search-----------------------------//
        // Label for date
        Label dateLabel = new Label("Search By Date: ");
        dateLabel.setStyle("-fx-font: 30px Georgia;" + "-fx-font-weight: bold;" + "-fx-text-fill:white;" );

        // Creating textFieldDate
        TextField textFieldDate = new TextField();
        textFieldDate.setPrefWidth(200);
        textFieldDate.setLayoutX(500);
        textFieldDate.setPromptText("Search date here!");

        // Create searchButton
        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-background-color: linear-gradient(black,#265164);" + "-fx-text-fill:whitesmoke;" + "-fx-font-size: 16;" + "-fx-border-color: white;" + "-fx-pref-height: 50;" + "-fx-pref-width: 150;");
        Image imgI = new Image("file:search.png");
        ImageView view2 = new ImageView(imgI);
        view2.setFitHeight(30);
        view2.setPreserveRatio(true);
        searchButton.setGraphic(view2);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                filteredListDate.setPredicate(p -> p.getDate().toLowerCase().contains(textFieldDate.getText().toLowerCase().trim()));//filter table by date
            }
        });

        HBox hBox = new HBox(dateLabel,textFieldDate,searchButton);//Add dateLabel , textFieldDate , searchButton to hBox
        hBox.setAlignment(Pos.CENTER);//Center HBox
        hBox.setPadding(new Insets(15, 15, 15, 15));
        hBox.setSpacing(10);

        //------------------Adding background image-----------------------------//
        Image image = new Image("file:football2.jpeg");
        ImageView img = new ImageView(image);
        img.setFitHeight(900);
        img.setFitWidth(945);
        Group rt1 = new Group();
        rt1.getChildren().addAll(img);

        // Create vBox
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setAlignment(Pos.TOP_CENTER);//Center VBox
        vbox.setPadding(new Insets(20, 200, 0, 100));
        vbox.getChildren().addAll(labelHead, tableVw1, hBox);

        //-------------------Returns the children of the pane------------------//
        ((Group) scene1.getRoot()).getChildren().addAll(img, vbox);

        matchStage1.setScene(scene1);
        matchStage1.show();
        matchStage1.setWidth(945);
        matchStage1.setHeight(900);
    }


    //--------------Launch the Application----------------//
    @Override
    public void start(Stage primaryStage) throws Exception {
        show();
    }
}
