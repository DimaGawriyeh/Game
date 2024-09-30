import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.company.game.Orientation;
import se.company.game.Position;
import se.company.game.Robot;

public class RobotTest {

    Robot robot = new Robot();
    Position destination;

    @Before
    public void setUp() {
        robot = new Robot();
        destination = new Position(1,2);
    }

    @After
    public void tearDown() {
        robot = null;
        destination = null;
    }

    @Test
    public void placeTest() {
        robot.place(destination, Orientation.NORTH);
        Assert.assertEquals(destination.getX(), robot.getPosition().getX());
        Assert.assertEquals(destination.getY(), robot.getPosition().getY());
        Assert.assertEquals(Orientation.NORTH, robot.getOrientation());
    }

    @Test
    public void moveTest() {
        robot.setPosition(new Position(0,0));
        robot.move(destination);
        Assert.assertEquals(destination.getX(), robot.getPosition().getX());
        Assert.assertEquals(destination.getY(), robot.getPosition().getY());
    }

    @Test
    public void turnRightTest() {
        robot.setOrientation(Orientation.EAST);
        robot.turnRight();
        Assert.assertEquals(Orientation.SOUTH, robot.getOrientation());
    }

    @Test
    public void turnLeftTest() {
        robot.setOrientation(Orientation.EAST);
        robot.turnLeft();
        Assert.assertEquals(Orientation.NORTH, robot.getOrientation());
    }
}
