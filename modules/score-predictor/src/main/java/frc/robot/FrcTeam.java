package frc.robot;

public class FrcTeam {
  private final int teamNumber;
  private final int[] lastThreeMatchScores;
  private final double averagePointsScored;

  public FrcTeam(int teamNumber, int[] lastThreeMatchScores) {
    this.teamNumber = teamNumber;
    this.lastThreeMatchScores = lastThreeMatchScores;

    // TODO: Calculate the average from lastThreeMatchScores.
    this.averagePointsScored = 0.0;
  }

  public double predictScore() {
    // TODO: Return the team's predicted score.
    return 0.0;
  }

  public int getTeamNumber() {
    return teamNumber;
  }
}
