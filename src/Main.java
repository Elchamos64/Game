//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Example usage
        Character hero = new Character("Hero", 100, 20, 10);
        Character monster = new Character("Monster", 80, 15, 5);

        System.out.println(hero);
        System.out.println(monster);

        hero.attack(monster);
        monster.attack(hero);

        System.out.println(hero);
        System.out.println(monster);
    }
}