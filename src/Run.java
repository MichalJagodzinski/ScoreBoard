package src;


import src.scoreBoardDisplay.ScoreBoard;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose option");
            System.out.println("1. Add match\n2.Update score");
            System.out.println(
                    switch (scanner.nextInt()) {
                        case 1 -> scoreBoard.addMatch(scanner.next(), scanner.next());
                        case 2 -> scoreBoard.updateScore(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.next());
                        default -> "Chose not found";
                    });
        }
    }
}
