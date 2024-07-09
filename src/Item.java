public class Item {
    private String name;
    private int healthBoost;
    private int attackBoost;
    private int defenseBoost;

    public Item(String name, int healthBoost, int attackBoost, int defenseBoost) {
        this.name = name;
        this.healthBoost = healthBoost;
        this.attackBoost = attackBoost;
        this.defenseBoost = defenseBoost;
    }

    public String getName() {
        return name;
    }

    public int getHealthBoost() {
        return healthBoost;
    }

    public int getAttackBoost() {
        return attackBoost;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    @Override
    public String toString() {
        return "Item:" +
                name + '\'' +
                ", healthBoost=" + healthBoost +
                ", attackBoost=" + attackBoost +
                ", defenseBoost=" + defenseBoost +
                '}';
    }
}
