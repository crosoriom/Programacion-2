package data;

public class Wizard extends TypeCharacter {
    public Wizard(String id, int level, int gold) {
        super(id, level, gold);
    }

    @Override
    public String availableWeapon() {
        if(level > 5 && gold > 30) {
            return "axes";
        }else if(this.level <= 5 && this.gold > 20) {
            return "swords";
        }else {
            return "sticks";
        }
    }
}
