public class Character {
    protected int health;
    protected int attack;
    protected String type;
    protected String name;


    public Character(int health, int attack, String type, String name) {
        this.health = health;
        this.attack = attack;
        this.type = type;
        this.name = name;
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
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return ("Character Type: " + type + " Health: " + health + " Attack: " + attack + " Name: " + name);
    }
}
