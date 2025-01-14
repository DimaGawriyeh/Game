package se.company.game;

public enum Orientation {
    NORTH(0),
    EAST(1),
    SOUTH(2),
    WEST(3);

    private final int value;

    Orientation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
