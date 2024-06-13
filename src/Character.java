public class Character {
    // Attributes
    private String name;
    private int health;
    private int attackPower;
    private int defense;

    // Constructor
    public Character(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    // Method to attack another character
    public void attack(Character target) {
        int damage = this.attackPower - target.getDefense();
        if (damage > 0) {
            target.setHealth(target.getHealth() - damage);
        }
        System.out.println(this.name + " attacks " + target.getName() + " for " + damage + " damage.");
    }

    // Method to defend (could be expanded based on game logic)
    public void defend() {
        System.out.println(this.name + " is defending.");
        // Logic for defending could be added here
    }

    // Check if the character is alive
    public boolean isAlive() {
        return this.health > 0;
    }

    // toString method to display character details
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attackPower=" + attackPower +
                ", defense=" + defense +
                '}';
    }
}
