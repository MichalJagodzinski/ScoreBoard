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

    public void updateScore(String homeTeam, int homeScore, int awayScore, String awayTeam) {
        for (Match match : newMatches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                match.updateScore(homeScore, awayScore);
            }
        }
    }

    public void finishGame(String homeTeam, String awayTeam, int homeScore, int awayScore){
        if (newMatches.removeIf(match -> match.homeTeam.equals(homeTeam) && match.awayTeam.equals(awayTeam)
                && match.homeScore == homeScore && match.awayScore == awayScore)) {
            Match match = new Match(homeTeam, awayTeam, homeScore, awayScore);
            endedMatches.add(match);
        }
    }

    public List<Match> liveMatchesSummary(){
        List<Match> liveSummary = new ArrayList<>(newMatches);
        liveSummary.sort(Comparator.comparingInt(Match::getTotalScore).reversed().thenComparing(Match::toString));
        return liveSummary;
    }

    public List<Match> endedMatchesSummary(){
        List<Match> endedSummary = new ArrayList<>();
        for (Match match : endedMatches){
            if (match.getTotalScore() != 0){
                endedSummary.add(match);
            }
        }
        endedSummary.sort(Comparator.comparingInt(Match::getTotalScore).reversed().thenComparing(Match::toString));
        return endedSummary;
    }
}
