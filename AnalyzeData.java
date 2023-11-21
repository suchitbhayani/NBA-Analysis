import java.util.ArrayList; //imports the arraylist package
import java.util.HashMap; //imports the hashmap package
import java.nio.file.Paths;
import java.util.Scanner; //imports the scanner package
import java.util.Collections;

public class AnalyzeData {
  private ArrayList<Player> playerList;
  private HashMap<String, Player> playerMap;
  
  public AnalyzeData() {
    this.playerList = new ArrayList<>();
    this.playerMap = new HashMap<>();
    this.readFile(); // reads data.txt file
  }
  
  private void readFile() {
    try (Scanner fileScan = new Scanner(Paths.get("data.txt"))) { //creates a scanner for the data.txt file to read it
      while (fileScan.hasNextLine()) {
        String line = fileScan.nextLine();
        line = line.replace("\t"," "); //adds spaces between each data
        boolean extraName = false;
        if (line.contains("Jr.") || //checks if their name has additional characters
            line.contains("Sr.") ||
            line.contains("II ") || 
            line.contains("III ") ||
            line.contains("IV ")) {
          extraName = true;
        }
        String[] stats = line.split(" ");
            
        // creates player object with its stats
        // add player to ArrayList
        // set the player's name as a key for the Player object value
        if (extraName) {
          String fullName = stats[1] + " " + stats[2] + " " + stats[3];
          Player playerToAdd = new Player(fullName,
            stats[4],
            stats[5],
            Double.parseDouble(stats[20]),
            Double.parseDouble(stats[21]),
            Double.parseDouble(stats[23]),
            Double.parseDouble(stats[25]),
            Double.parseDouble(stats[26]));
          this.playerList.add(playerToAdd);
          this.playerMap.put(fullName, playerToAdd);
        } else {
          String fullName = stats[1] + " " + stats[2];
          Player playerToAdd = new Player(fullName,
            stats[3],
            stats[4],
            Double.parseDouble(stats[19]),
            Double.parseDouble(stats[20]),
            Double.parseDouble(stats[22]),
            Double.parseDouble(stats[24]),
            Double.parseDouble(stats[25]));
          this.playerList.add(playerToAdd);
          this.playerMap.put(fullName, playerToAdd);
        }
      }
      fileScan.close();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
  
  public void playerStat(String player) {
    if (this.playerMap.get(player) == null) { //checks if the given value is valid
      System.out.println("Player not found\n");
      return;
    }
    System.out.println(this.playerMap.get(player) + "\n"); //prints the stats if given input was valid
  }

  public void pointsLeader() { //returns the player if the greatest amount of points
    ArrayList<Double> plot2 = new ArrayList<>();
    for (int i=0; i<playerList.size(); i++){
      double plot = playerList.get(i).getPoints();
      plot2.add(plot);
    }
    double john = (Collections.max(plot2));
    for (int i=0; i<playerList.size(); i++){
      double plot3 = playerList.get(i).getPoints();
      if (plot3 == john){
        System.out.println(playerList.get(i).getName()+": "+john + " points \n");
      }
    }
  }

  public void reboundsLeader() { //returns the player if the greatest amount of rebounds
    int greatest = 0;
    for (int i=0; i<playerList.size(); i++) {
      double rl = playerList.get(i).getRebounds();
      if (rl > playerList.get(greatest).getRebounds()) {
        greatest = i;
      }
    }
    System.out.println(playerList.get(greatest).getName() + ": " + playerList.get(greatest).getRebounds() + " rebounds \n");
  }

  public void assistsLeader() { //returns the player if the greatest amount of assists
    int x = 0;
    double y = 0;
    for (int i=0; i<playerList.size(); i++){
      double check = playerList.get(i).getAssists();
      if (check>y){
        y = check;
        x = i;
      }
    }
    System.out.println(playerList.get(x).getName() + ": " +playerList.get(x).getAssists() + " assists \n");
  }

  public void stealsLeader() { //returns the player if the greatest amount of steals
    int x = 0;
    double y = 0;
    for (int i=0; i<playerList.size(); i++){
      double check = playerList.get(i).getSteals();
      if (check>y){
        y = check;
        x = i;
      }
    }
    System.out.println(playerList.get(x).getName() + ": " +playerList.get(x).getSteals() + " steals \n");
  }

  public void blocksLeader() { //returns the player if the greatest amount of blocks
    int x = 0;
    double y = 0;
    for (int i=0; i<playerList.size(); i++){
      double check = playerList.get(i).getBlocks();
      if (check>y){
        y = check;
        x = i;
      }
    }
    System.out.println(playerList.get(x).getName() + ": " +playerList.get(x).getBlocks() + " blocks \n");
  }
  
}