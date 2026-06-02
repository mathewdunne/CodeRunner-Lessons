package frc.robot;

import org.littletonrobotics.junction.Logger;

public class FrcMatch {
  private final FrcAlliance redAlliance;
  private final FrcAlliance blueAlliance;

  public FrcMatch(FrcAlliance redAlliance, FrcAlliance blueAlliance) {
    this.redAlliance = redAlliance;
    this.blueAlliance = blueAlliance;
  }

  public void predictWinner() {
    // TODO: Use each alliance's predictAllianceScore() method.
    double redScore = 0.0;
    double blueScore = 0.0;

    Logger.recordOutput("Prediction/RedScore", redScore);
    Logger.recordOutput("Prediction/BlueScore", blueScore);

    System.out.println("Red predicted score: " + redScore);
    System.out.println("Blue predicted score: " + blueScore);

    // TODO: Replace these placeholder conditions with score comparisons.
    boolean redWins = false;
    boolean blueWins = false;

    if (redWins) {
      System.out.println("The red alliance is predicted to win!");
    } else if (blueWins) {
      System.out.println("The blue alliance is predicted to win!");
    } else {
      System.out.println("It's predicted to be a tie!");
    }
  }
}
