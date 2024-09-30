package se.company.game;

public class Board {

    private final int SIZE = 5;
    private boolean[][] boardArray;

    public Board() {
        boardArray = new boolean[SIZE][SIZE];
    }

    public void handleBoardTiles(Position newPosition, Position currentPosition) {
        if (isAvailable(newPosition)) {
            if (currentPosition != null) {
                setAvailable(currentPosition);
            }
            setTaken(newPosition);
        } else {
            throw new RuntimeException("The given position is not available");
        }
    }

    private boolean isAvailable(Position position) {
        if (0 <= position.getX() && position.getX() < SIZE && 0 <= position.getY() && position.getY() < SIZE) {
            return !boardArray[position.getX()][position.getY()];
        }
        return false;
    }

    private void setAvailable(Position position) {
        boardArray[position.getX()][position.getY()] = false;
    }

    private void setTaken(Position position) {
        boardArray[position.getX()][position.getY()] = true;
    }

    public boolean[][] getBoardArray() {
        return boardArray;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = SIZE - 1; i >= 0; i--) {
            for (int j = 0; j < SIZE; j++) {
                if (!boardArray[j][i])
                    string.append('-');
                else
                    string.append('*');
            }
            string.append("\n");
        }
        return "\n" + string;
    }
}
