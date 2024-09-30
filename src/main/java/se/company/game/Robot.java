package se.company.game;

public class Robot {

    private Position position;
    private Orientation orientation;

    public Robot() {
        position = null;
        orientation = null;
    }

    public void place(Position position, Orientation orientation) {
        this.orientation = orientation;
        this.position = position;
    }

    public void move(Position newPosition) {
        position.setX(newPosition.getX());
        position.setY(newPosition.getY());
    }


    public void turnRight() {
        int value = orientation.getValue() + 1;
        if (value == 4) {
            orientation = Orientation.NORTH;
        } else {
            orientation = Orientation.values()[value];
        }

    }

    public void turnLeft() {
        int value = orientation.getValue() - 1;
        if (value == -1) {
            orientation = Orientation.WEST;
        } else {
            orientation = Orientation.values()[value];
        }
    }

    public Position getRobotDestination() {
        Position destination = new Position();
        switch (orientation) {
            case NORTH:
                destination.setX(position.getX());
                destination.setY(position.getY() + 1);
                break;
            case EAST:
                destination.setX(position.getX() + 1);
                destination.setY(position.getY());
                break;
            case SOUTH:
                destination.setX(position.getX());
                destination.setY(position.getY() - 1);
                break;
            case WEST:
                destination.setX(position.getX() - 1);
                destination.setY(position.getY());
                break;
        }
        return destination;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        if (0 <= position.getX() && position.getX() < 5 && 0 <= position.getY() && position.getY() < 5) {
            this.position = position;
        }
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public String toString() {
        return position + ", " + orientation;
    }
}
