package data;

public class Warrior extends TypeCharacter {
    public Warrior(String id, int level, int gold) {
        super(id, level, gold);
    }

    @Override
    public String availableWeapon() {
        if(level > 3 && gold > 50) {
            return "spears";
        } else if(this.level <= 5 && this.gold > 30) {
            return "daggers";
        } else {
            return "crossbow";
        }
    }
}
