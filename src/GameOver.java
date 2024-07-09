import java.util.ArrayList;

public class GameOver {
    public static void checkGameOver(ArrayList<Character> characters) {
        for (Character character : characters) {
            if (!character.isAlive()) {
                System.out.println(character.getName() + " has been defeated. Game Over!");
                System.exit(0); // Exit the program
            }
        }
    }
}
