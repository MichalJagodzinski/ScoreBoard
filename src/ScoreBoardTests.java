package src;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.scoreBoard.ScoreBoard;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTests {
    private ScoreBoard scoreBoard;

    @BeforeEach
    private void setUp() {
        this.scoreBoard = new ScoreBoard();
    }

    @Test
    public void newMatchTest() {
        scoreBoard.newMatch("Poland", "Spain");
        assertEquals(1, scoreBoard.liveMatchesSummary().size());
    }

    @Test
    public void updateScoreTest() {
        scoreBoard.newMatch("Poland", "Spain");
        scoreBoard.updateScore("Poland", 1, 0, "Spain");
        assertEquals(1, scoreBoard.liveMatchesSummary().size());
    }

    @Test
    public void finishGameTest() {
        scoreBoard.newMatch("Poland", "Spain");
        scoreBoard.finishGame("Poland", "Spain");
        assertEquals(1, scoreBoard.endedMatchesSummary().size());
    }

    @Test
    public void liveMatchesSummaryTest() {
        scoreBoard.newMatch("Poland", "Spain");
        scoreBoard.newMatch("Mexico", "Canada");
        scoreBoard.newMatch("USA", "Brazil");
        scoreBoard.newMatch("Argentina", "Germany");
        assertEquals(4, scoreBoard.liveMatchesSummary().size());
    }

    @Test
    public void endedMatchesSummary() {
        scoreBoard.newMatch("Poland", "Spain");
        scoreBoard.newMatch("Mexico", "Canada");
        scoreBoard.newMatch("USA", "Brazil");
        scoreBoard.newMatch("Argentina", "Germany");
        scoreBoard.finishGame("Poland", "Spain");
        scoreBoard.finishGame("Mexico", "Canada");
        scoreBoard.finishGame("USA", "Brazil");
        scoreBoard.finishGame("Argentina", "Germany");
        assertEquals(4, scoreBoard.endedMatchesSummary().size());
    }
}
