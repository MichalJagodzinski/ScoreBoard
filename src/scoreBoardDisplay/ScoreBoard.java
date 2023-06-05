package src.scoreBoardDisplay;

import src.teamSpecify.Match;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreBoard {
    List<Match> newMatches;
    List<Match> endedMatches;
    public ScoreBoard(){
        this.newMatches = new ArrayList<>();
        this.endedMatches = new ArrayList<>();
    }

    public void newMatch(String homeTeam, String awayTeam, int homeScore, int awayScore){
        Match match = new Match(homeTeam, awayTeam, homeScore, awayScore);
        newMatches.add(match);
    }

    public String updateScore(String homeTeam, int homeScore, int awayScore, String awayTeam) {
        for (Match match : newMatches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                match.updateScore(homeScore, awayScore);
                return match.toString();
            }
        }
        return "Wrong teams";
    }

    public String finishGame(String homeTeam, String awayTeam, int homeScore, int awayScore){
        if (newMatches.removeIf(match -> match.homeTeam.equals(homeTeam) && match.awayTeam.equals(awayTeam)
                && match.homeScore == homeScore && match.awayScore == awayScore)) {
            Match match = new Match(homeTeam, awayTeam, homeScore, awayScore);
            endedMatches.add(match);
            return match.toString();
        }
        return "Wrong teams";
    }

    public List<Match> liveMatchesSummary(){
        List<Match> liveSummary = new ArrayList<>(newMatches);
        liveSummary.sort(Comparator.comparingInt(Match::getTotalScore).reversed().thenComparing(Match::toString));
        return liveSummary;
    }

    public List<Match> endedMatchesSummary(){
        List<Match> endedSummary = new ArrayList<>(endedMatches);
        endedSummary.sort(Comparator.comparingInt(Match::getTotalScore).reversed().thenComparing(Match::toString));
        return endedSummary;
    }
}
