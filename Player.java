 public class Player {
  //defines all the attributes of the class
  private String name;
  private String team;
  private String position;
  private double pointsPG;
  private double reboundsPG;
  private double assistsPG;
  private double stealsPG;
  private double blocksPG;

  public Player(String name, String team, String position, double pointsPG, double reboundsPG, double assistsPG, double stealsPG, double blocksPG) {//makes a public statement where the code uses the above strings
    this.name = name;
    this.team = team;
    this.position = position;
    this.pointsPG = pointsPG;
    this.reboundsPG = reboundsPG;
    this.assistsPG = assistsPG;
    this.stealsPG = stealsPG;
    this.blocksPG = blocksPG;
  }
  //these functions are used so that we can easily access certain attributes for a specific object
  public double getPoints() {
    return this.pointsPG;
  }//returns PointsPG
  
  public double getRebounds() {
    return this.reboundsPG;
  }// returns rebounds

  public double getAssists() {
    return this.assistsPG;
  }//returns the # of assists

  public double getSteals() {
    return this.stealsPG;
  }//return the # of steals

  public double getBlocks() {
    return this.blocksPG;
  }//return the # of blocks

  public String getName() {
    return this.name;
  }//return the name of the player

  //this returns all the attributes of an object at once
  public String toString() {
    return name + ", " + team + ", " + position + ", " + pointsPG + " ppg, " + reboundsPG + " rpg, " + assistsPG + " apg, " + stealsPG + " spg, " + blocksPG + " bpg";
  }
}