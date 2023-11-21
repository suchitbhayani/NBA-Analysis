import java.util.Scanner;

public class UserInterface {
  private Scanner scanner;
  private AnalyzeData analyze; 

  public UserInterface() {
    this.scanner = new Scanner(System.in); //creates scanner to recieve user input
    this.analyze = new AnalyzeData(); //creates instance of AnalyzeData
  }

  public void start() {
    System.out.println("");
    while (true) {
      System.out.println("Please select an action:"); // gives user options to analyze the data
      System.out.println("1: Stats for 1 player");
      System.out.println("2: League leader for a stat");
      System.out.println("X: Exit\n");
      
      String input = scanner.nextLine();
      System.out.println("");

      if (input.equals("1")) { // checks the user input and triggers different methods depending on input
        this.onePlayerStats();
      } else if (input.equals("2")) {
        this.leagueLeaderStats();
      } else if (input.equalsIgnoreCase("X")) {
        System.out.println("");
        break;
      } else {
        System.out.println("Invalid input, please try again \n");
      }
    }
  }

  private void onePlayerStats() {
    System.out.println("Which player's stats would you like to see?"); // Asks for player name to run search
    System.out.println("X to go back\n");
      
    String input = scanner.nextLine();
    System.out.println("");
    
    if (input.equalsIgnoreCase("X")) { // allows you to go back to previous screen
      return;
    }
    this.analyze.playerStat(input); // analyzes the data to find the player's stats
  }

  private void leagueLeaderStats() {
    System.out.println("Which stat would you like to see the leader in?"); // asks what kind of data the user wants
    System.out.println("1: points");
    System.out.println("2: rebounds");
    System.out.println("3: assists");
    System.out.println("4: steals");
    System.out.println("5: blocks");
    System.out.println("X: go back\n");

    String input = scanner.nextLine();
    System.out.println("");
    
    if (input.equalsIgnoreCase("X")) { // allows you to go back to previous screen
      return;
    } else if (input.equals("1")) { // runs different analyzes depending on user input
      this.analyze.pointsLeader();
    } else if (input.equals("2")) {
      this.analyze.reboundsLeader();
    } else if (input.equals("3")) {
      this.analyze.assistsLeader();
    } else if (input.equals("4")) {
      this.analyze.stealsLeader();
    } else if (input.equals("5")) {
      this.analyze.blocksLeader();
    } else {
      System.out.println("Invalid input, please try again \n");
    }
  }

}