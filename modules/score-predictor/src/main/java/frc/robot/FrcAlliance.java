package frc.robot;

public class FrcAlliance {
  private final String colour;
  private final FrcTeam[] teams;

  public FrcAlliance(String colour, FrcTeam[] teams) {
    this.colour = colour;
    this.teams = teams;
  }

  public double predictAllianceScore() {
    // TODO: Add the predicted scores from every team in this alliance.
    return 0.0;
  }

  public String getColour() {
    return colour;
  }
}
