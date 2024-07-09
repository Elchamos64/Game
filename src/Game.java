import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private ArrayList<Character> characters;
    private Scanner scanner;

    public Game() {
        characters = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {
        // Create characters and add them to the list
        characters.add(new Character("Hero", 100, 20, 10));
        characters.add(new Character("Monster", 80, 15, 5));

        // Add items to characters
        characters.get(0).addItem(new Item("Sword", 0, 5, 0));
        characters.get(1).addItem(new Item("Shield", 0, 0, 5));

        // Display all characters
        displayCharacters();

        while (true) {
            System.out.println("\nEnter command: 1- Attack, 2- Show characters, 3- Use item, 4- Heal, 5- Exit");
            int command = scanner.nextInt();

            if (command == 1) {
                attackSequence();
            } else if (command == 2) {
                displayCharacters();
            } else if (command == 3) {
                useItemSequence();
            } else if (command == 4) {
                healSequence();
            } else if (command == 5) {
                break;
            } else {
                System.out.println("Invalid command.");
            }

            GameOver.checkGameOver(characters); // Check for game over condition
        }

        scanner.close();
    }

    private void displayCharacters() {
        for (Character character : characters) {
            System.out.println(character);
        }
    }

    private void attackSequence() {
        System.out.println("Choose attacker (index): ");
        int attackerIndex = scanner.nextInt();
        System.out.println("Choose target (index): ");
        int targetIndex = scanner.nextInt();

        if (isValidIndex(attackerIndex) && isValidIndex(targetIndex) && attackerIndex != targetIndex) {
            Character attacker = characters.get(attackerIndex);
            Character target = characters.get(targetIndex);

            if (attacker.isAlive() && target.isAlive()) {
                attacker.attack(target);
                if (!target.isAlive()) {
                    System.out.println(target.getName() + " is defeated!");
                }
            } else {
                System.out.println("One of the characters is already defeated.");
            }
        } else {
            System.out.println("Invalid indices.");
        }
    }

    private void useItemSequence() {
        System.out.println("Choose character to use item (index): ");
        int charIndex = scanner.nextInt();

        if (isValidIndex(charIndex)) {
            Character character = characters.get(charIndex);
            if (character.getInventory().isEmpty()) {
                System.out.println(character.getName() + " has no items.");
            } else {
                System.out.println(character.getName() + "'s Inventory:");
                for (int i = 0; i < character.getInventory().size(); i++) {
                    System.out.println(i + ": " + character.getInventory().get(i));
                }
                System.out.println("Choose item to use (index): ");
                int itemIndex = scanner.nextInt();
                if (itemIndex >= 0 && itemIndex < character.getInventory().size()) {
                    Item item = character.getInventory().get(itemIndex);
                    System.out.println(character.getName() + " uses " + item.getName());
                    character.addItem(item);
                } else {
                    System.out.println("Invalid item index.");
                }
            }
        } else {
            System.out.println("Invalid character index.");
        }
    }

    private void healSequence() {
        System.out.println("Choose character to heal (index): ");
        int charIndex = scanner.nextInt();

        if (isValidIndex(charIndex)) {
            Character character = characters.get(charIndex);
            System.out.println("Enter amount to heal: ");
            int amount = scanner.nextInt();
            character.heal(amount);
        } else {
            System.out.println("Invalid character index.");
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < characters.size();
    }
}
