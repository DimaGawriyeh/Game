package se.company.game;

public class Game {
    private Robot robot;
    private Board board;

    public Game() {
        robot = new Robot();
        board = new Board();
    }

    public void place(int x, int y, Orientation orientation) {
        Position newPosition = new Position(x, y);
        board.handleBoardTiles(newPosition, robot.getPosition());
        robot.place(newPosition, orientation);
    }

    public void move() {
        Position currentPosition = robot.getPosition();
        if (currentPosition != null) {
            Position destination = robot.getRobotDestination();
            board.handleBoardTiles(destination, currentPosition);
            robot.move(destination);
        } else {
            throw new RuntimeException("Move can not be performed on a unplaced robot");
        }


    }

    public void right() {
        if (robot.getPosition() != null) {
            robot.turnRight();
        } else {
            throw new RuntimeException("Turn right can not be performed on a unplaced robot");
        }

    }

    public void left() {
        if (robot.getPosition() != null) {
            robot.turnLeft();
        } else {
            throw new RuntimeException("Turn left can not be performed on a unplaced robot");
        }

    }

    public String report() {
        if (robot.getPosition() != null) {
            return robot.toString();
        } else {
            throw new RuntimeException("Report can not be performed on a unplaced robot");
        }

    }

    public Board getBoard() {
        return board;
    }

    public Robot getRobot() {
        return robot;
    }
}
