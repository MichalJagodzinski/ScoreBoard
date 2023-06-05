package src.scoreBoardDisplay;

import src.teamSpecify.Match;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
    List<Match> newMatches = new ArrayList<>();
    public List<Match> addMatch(String homeTeam, String awayTeam) {
        Match match = new Match(homeTeam, awayTeam);
        newMatches.add(match);
        return newMatches;
    }

    public String updateScore(String homeTeam, int homeScore, int awayScore, String awayTeam) {
        for (Match match : newMatches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                match.setHomeScore(homeScore);
                match.setAwayScore(awayScore);
                return match.toString();
            }
        }
        return "Teams not found";
    }
}
