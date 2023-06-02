public abstract class Character {

    private int hitpoints;
    private int dexterity;
    private int strength;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    private Race race;
    int age;
    String name;
    int level = 1;
    Gender gender;

    public Character(Gender gender, Race race, int age, String name) {
        this.gender = gender;
        this.race = race;
        this.age = age;
        this.name = name;
    }

    public void levelUp() {
        this.level++;
    }

    public void setDexterity(int arg) {
        if(arg > 30 || arg < 0){
            return;
        }
        this.dexterity = arg;
    }

    public void setStrength(int arg) {
        if(arg > 30 || arg < 0){
            return;
        }
        this.strength = arg;
    }

    public void setConstitution(int arg) {
        if(arg > 30 || arg < 0){
            return;
        }
        this.constitution = arg;
    }

    public void setIntelligence(int arg) {
        if(arg > 30 || arg < 0){
            return;
        }
        this.intelligence = arg;
    }

    public void setWisdom(int arg) {
        if(arg > 30 || arg < 0){
            return;
        }
        this.wisdom = arg;
    }

    public void setCharisma(int arg) {
        if(arg > 30 || arg < 0){
            return;
        }
        this.charisma = arg;
    }

    public void setHitpoints(int arg) {
        if(arg > 30 || arg < 0){
            return;
        }
        this.hitpoints = arg;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public Race getRace() {
        return race;
    }

    public int getHitpoints() {
        return hitpoints;
    }
}
