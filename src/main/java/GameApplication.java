import se.company.game.Game;
import se.company.game.InputLoader;
import se.company.game.Orientation;

import java.util.Iterator;
import java.util.List;

public class GameApplication {

    public static void main(String[] args) {

        Game game = new Game();
        InputLoader inputLoader = new InputLoader();
        List<String> input = inputLoader.loadInputFromFile();
        Iterator iterator = input.iterator();
        while (iterator.hasNext()) {
            String lineInput = (String) iterator.next();
            if (!lineInput.matches("^(?!\\s*$).+")) {
                continue;
            }
            String[] commands = lineInput.split(",");
            if (commands[0].equals("PLACE")) {
                int x = Integer.parseInt(commands[1]);
                int y = Integer.parseInt(commands[2]);
                Orientation orientation = Orientation.valueOf(commands[3].toUpperCase());
                try {
                    game.place(x, y, orientation);
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else if (commands[0].equals("MOVE")) {
                try {
                    game.move();
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else if (commands[0].equals("LEFT")) {
                try {
                    game.left();
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else if (commands[0].equals("RIGHT")) {
                try {
                    game.right();
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else if (commands[0].equals("REPORT")) {
                try {
                    System.out.println(game.report());
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Please enter valid inputs and try again ");
            }
        }

    }
}
