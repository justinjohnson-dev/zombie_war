public class Character {
    protected int health;
    protected int attack;
    protected String type;


    public Character(int health, int attack, String type) {
        this.health = health;
        this.attack = attack;
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void attack() {
        System.out.println("I am attacking!");
    }

    public String toString() {
        return ("Character Type: " + type + " Health: " + health + " Attack: " + attack);
    }
}
