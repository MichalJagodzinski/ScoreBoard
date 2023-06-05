package src;


import src.scoreBoardDisplay.ScoreBoard;
import src.teamSpecify.Match;

import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add match\n2. Update score\n3. Finish game\n4. Display live matches summary\n5. Display ended matches summary\n6. Exit");
            System.out.println("Choose option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter home team: ");
                    String homeTeam = scanner.next();
                    System.out.println("Enter away team: ");
                    String awayTeam = scanner.next();
                    int homeScore = 0;
                    int awayScore = 0;
                    scoreBoard.newMatch(homeTeam, awayTeam, homeScore, awayScore);
                    System.out.println("New game started: " + homeTeam + " " + homeScore + " - " + awayScore + " " + awayTeam);
                    break;
                case 2:
                    System.out.println("Enter home team: ");
                    homeTeam = scanner.next();
                    System.out.println("Enter away team");
                    awayTeam = scanner.next();
                    System.out.println("Enter home team score");
                    homeScore = scanner.nextInt();
                    System.out.println("Enter away team score");
                    awayScore = scanner.nextInt();
                    scanner.nextLine();
                    scoreBoard.updateScore(homeTeam, homeScore, awayScore, awayTeam);
                    System.out.println("Score updated: " + homeTeam + " " + homeScore + " - " + awayScore + " " + awayTeam);
                    break;
                case 3:
                    System.out.println("Enter home team: ");
                    homeTeam = scanner.next();
                    System.out.println("Enter away team");
                    awayTeam = scanner.next();
                    System.out.println("Enter home team score");
                    homeScore = scanner.nextInt();
                    System.out.println("Enter away team score");
                    awayScore = scanner.nextInt();
                    scoreBoard.finishGame(homeTeam, awayTeam, homeScore, awayScore);
                    System.out.println("Game finished: " + homeTeam + " " + homeScore + " - " + awayScore + " " + awayTeam);
                    break;
                case 4:
                    List<Match> liveSummary = scoreBoard.liveMatchesSummary();
                    System.out.println("Live matches Summary: ");
                    int place = 1;
                    for (Match match : liveSummary) {
                        System.out.println(place + ". " + match.toString());
                        place++;
                    }
                    break;
                case 5:
                    List<Match> endedSummary = scoreBoard.endedMatchesSummary();
                    System.out.println("Ended matches summary: ");
                    place = 1;
                    for (Match match : endedSummary){
                        System.out.println(place + ". " + match.toString());
                        place++;
                    }
                    break;
                case 6:
                    System.out.println("Breaking");
                    System.exit(0);
                default:
                    System.out.println("Choice not found");
                    break;
            }
        }
    }
}
