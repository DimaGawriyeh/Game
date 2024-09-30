import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.company.game.Game;
import se.company.game.Orientation;
import se.company.game.Position;

public class GameTest {

    Game game;
    Position currentPosition;

    @Before
    public void setUp() {
        game = new Game();
        currentPosition = new Position(4, 1);
    }

    @After
    public void tearDown() {
        game = null;
        currentPosition = null;
    }

    @Test
    public void placeTest() {
        game.place(1, 1, Orientation.NORTH);
        Assert.assertEquals(1, game.getRobot().getPosition().getX());
        Assert.assertEquals(1, game.getRobot().getPosition().getY());
        Assert.assertEquals(Orientation.NORTH, game.getRobot().getOrientation());
        Assert.assertTrue(game.getBoard().getBoardArray()[1][1]);
    }

    @Test
    public void moveTest() {
        game.getRobot().setPosition(currentPosition);
        game.getRobot().setOrientation(Orientation.NORTH);
        game.move();
        Assert.assertEquals(4, game.getRobot().getPosition().getX());
        Assert.assertEquals(2, game.getRobot().getPosition().getY());
        Assert.assertEquals(Orientation.NORTH, game.getRobot().getOrientation());
        Assert.assertTrue(game.getBoard().getBoardArray()[4][2]);
    }

    @Test(expected = RuntimeException.class)
    public void moveRobotNotPlacedTest() {
        game.move();
    }

    @Test(expected = RuntimeException.class)
    public void moveToInvalidPlaceTest() {
        game.getRobot().setPosition(currentPosition);
        game.getRobot().setOrientation(Orientation.EAST);
        game.move();
        Assert.assertEquals(4, game.getRobot().getPosition().getX());
        Assert.assertEquals(1, game.getRobot().getPosition().getY());
        Assert.assertEquals(Orientation.EAST, game.getRobot().getOrientation());
        Assert.assertTrue(game.getBoard().getBoardArray()[4][1]);
    }

    @Test(expected = RuntimeException.class)
    public void rightRobotNotPlacedTest() {
        game.right();
    }

    @Test(expected = RuntimeException.class)
    public void leftRobotNotPlacedTest() {
        game.left();
    }

    @Test(expected = RuntimeException.class)
    public void reportRobotNotPlacedTest() {
        game.report();
    }
}
