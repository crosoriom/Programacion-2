package data;

public class TypeCharacter{
    protected String id;
    protected int level;
    protected int gold;

    public TypeCharacter(String id, int level, int gold) {
        this.id = id;
        this.level = level;
        this.gold = gold;
    }

    public String availableWeapon() {
        return "";
    }

    public String getID() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() {
        return gold;
    }

    public boolean canBuyWeapon() {
        return !(level == 0 || gold == 0);
    }
}
