import java.util.ArrayList;

public class Character {
    private String name;
    private int health;
    private int attackPower;
    private int defense;
    private ArrayList<Item> inventory;

    public Character(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
        this.inventory = new ArrayList<>();
    }

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

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
        health += item.getHealthBoost();
        attackPower += item.getAttackBoost();
        defense += item.getDefenseBoost();
    }

    public void attack(Character target) {
        int damage = this.attackPower - target.getDefense();
        if (damage > 0) {
            target.setHealth(target.getHealth() - damage);
        } else {
            damage = 0;
        }
        System.out.println(this.name + " attacks " + target.getName() + " for " + damage + " damage.");
    }

    public void heal(int amount) {
        this.health += amount;
        System.out.println(this.name + " heals for " + amount + " health.");
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public String toString() {
        return "Character:" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attackPower=" + attackPower +
                ", defense=" + defense +
                ", inventory=" + inventory +
                '}';
    }
}
