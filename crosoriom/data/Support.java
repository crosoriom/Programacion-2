package data;

public class Support extends TypeCharacter {
    public Support(String id, int level, int gold) {
        super(id, level, gold);
    }

    @Override
    public String availableWeapon() {
        if(level > 11 && gold > 110) {
            return "coats";
        } else if(this.level <= 5 && this.gold > 70) {
            return "catapults";
        } else {
            return "shields";
        }
    }
}
