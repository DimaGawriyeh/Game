import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.company.game.Board;
import se.company.game.Position;

public class BoardTest {

    Board board;
    Position currentPosition;
    Position destination;

    @Before
    public void setUp() {
        board = new Board();
        currentPosition = new Position();
        destination = new Position();
    }

    @After
    public void tearDown() {
        board = null;
        currentPosition = null;
        destination = null;
    }

    @Test
    public void handleBoardTilesTest() {
        currentPosition.setX(1);
        currentPosition.setY(1);
        destination.setX(1);
        destination.setY(2);
        board.handleBoardTiles(destination, currentPosition);
        Assert.assertTrue(board.getBoardArray()[1][2]);
    }

    @Test(expected = RuntimeException.class)
    public void handleBoardTilesTakenPositionThrowsExceptionTest() {
        currentPosition.setX(3);
        currentPosition.setY(2);
        board.getBoardArray()[3][3] = true;
        destination.setX(3);
        destination.setY(3);
        board.handleBoardTiles(destination, currentPosition);
    }

    @Test(expected = RuntimeException.class)
    public void handleBoardTilesInvalidPositionThrowsExceptionTest() {
        currentPosition.setX(4);
        currentPosition.setY(3);
        destination.setX(5);
        destination.setY(3);
        board.handleBoardTiles(destination, currentPosition);
    }
}
