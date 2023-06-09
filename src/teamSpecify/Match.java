package src.teamSpecify;

public class Match {
    public String homeTeam;
    public String awayTeam;
    public int homeScore = 0;
    public int awayScore = 0;

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public void updateScore(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    @Override
    public String toString() {
        return homeTeam + " " + homeScore + "-" + awayScore + " " + awayTeam + "\n";
    }
}
