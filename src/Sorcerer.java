import java.util.ArrayList;
import java.util.Collections;

public class Sorcerer extends Character implements IClass {
    int proficiencyBonus = 2;
    int sorceryPoints = 0;
    int cantripsKnown = 4;
    int spellsKnown = 2;
    int spellSlotsLv1 = 2;
    int spellSlotsLv2 = 0;
    int spellSlotsLv3 = 0;
    int spellSlotsLv4 = 0;
    int spellSlotsLv5 = 0;
    int spellSlotsLv6 = 0;
    int spellSlotsLv7 = 0;
    int spellSlotsLv8 = 0;
    int spellSlotsLv9 = 0;


    public Sorcerer(Gender gender, Race race, int age, String name, String mod) {
        super(gender, race, age, name);
        int dex;
        int str;
        int con;
        int intel;
        int wis;
        int cha;

        // creates character using a Standard Array
        if (mod.equals("Array") || mod.equals("array")) {
            cha = 15;
            con = 14;
            wis = 13;
            dex = 12;
            str = 10;
            intel = 8;
        } else { // creates character using 'Dice'
            ArrayList<Integer> stats = new ArrayList<>();

            // adding 6 stat rolls to an arraylist, so they can be sorted
            for (int i=0; i<6; i++) {
                stats.add(Dice.statroll());
            }

            // sorting the rolls, then assigning them to different stats (shown highest to lowest)
            Collections.sort(stats);
            cha = stats.get(5);
            con = stats.get(4);
            wis = stats.get(3);
            dex = stats.get(2);
            str = stats.get(1);
            intel = stats.get(0);
        }

        // increasing stats according to the race chosen
        switch (race) {
            case DRAGONBORN -> {
                str = str + 2;
                cha++;
            }
            case DWARF -> con = con + 2;
            case ELF -> dex = dex + 2;
            case GNOME -> intel = intel + 2;
            case HALFELF -> {
                cha = cha + 2;
                con++;
                dex++;
            }
            case HALFLING -> dex = dex + 2;
            case HALFORC -> {
                str = str + 2;
                con++;
            }
            case HUMAN -> {
                dex++;
                str++;
                con++;
                intel++;
                wis++;
                cha++;
            }
            case TIEFLING -> {
                cha = cha + 2;
                intel++;
            }
        }

        // calculating the Hitpoints according to the constitution (con)
        int HP1 = 6;
        int modifier = this.modifierCalc(con);
        int HP = HP1 + modifier;

        // setting the stats in the Character superclass
        this.setHitpoints(HP);
        this.setDexterity(dex);
        this.setStrength(str);
        this.setConstitution(con);
        this.setIntelligence(intel);
        this.setWisdom(wis);
        this.setCharisma(cha);
    }

    public void levelUp() {
        if (this.level >= 20) {
            return;
        }
        this.level++;

        // calculating new hit point values
        int HP = this.getHitpoints();
        int con = this.getConstitution();
        int mod = this.modifierCalc(con);
        int HPUp = Dice.oneD6();
        if (HPUp < 4) {
            HP = HP + mod + 4;
        } else {
            HP = HP + mod + HPUp;
        }
        this.setHitpoints(HP);

        // setting new amount of Sorcery Points according the Sorcerer Table
        if (this.level == 1) {
            this.sorceryPoints = 0;
        } else if (this.level == 2) {
            this.sorceryPoints = 2;
        } else {
            this.sorceryPoints++;
        }

        /*
        increasing the proficiency, and amount of cantrips,
        spells and spell slots according the Sorcerer Table
         */
        if (this.level == 2) {
            this.spellsKnown++;
            this.spellSlotsLv1++;
        } else if (this.level == 3) {
            this.spellsKnown++;
            this.spellSlotsLv1++;
            this.spellSlotsLv2 = 2;
        } else if (this.level == 4) {
            this.cantripsKnown++;
            this.spellsKnown++;
            this.spellSlotsLv2++;
        } else if (this.level == 5) {
            this.proficiencyBonus++;
            this.spellsKnown++;
            this.spellSlotsLv3 = 2;
        } else if (this.level == 6) {
            this.spellsKnown++;
            this.spellSlotsLv3++;
        } else if (this.level == 7) {
            this.spellsKnown++;
            this.spellSlotsLv4++;
        } else if (this.level == 8) {
            this.spellsKnown++;
            this.spellSlotsLv4++;
        } else if (this.level == 9) {
            this.proficiencyBonus++;
            this.spellsKnown++;
            this.spellSlotsLv4++;
            this.spellSlotsLv5++;
        } else if (this.level == 10) {
            this.cantripsKnown++;
            this.spellsKnown++;
            this.spellSlotsLv5++;
        } else if (this.level == 11) {
            this.spellsKnown++;
            this.spellSlotsLv6++;
        } else if (this.level == 13) {
            this.proficiencyBonus++;
            this.spellsKnown++;
            this.spellSlotsLv7++;
        } else if (this.level == 15) {
            this.spellsKnown++;
            this.spellSlotsLv8++;
        } else if (this.level == 17) {
            this.proficiencyBonus++;
            this.spellsKnown++;
            this.spellSlotsLv9++;
        } else if (this.level == 18) {
            this.spellSlotsLv5++;
        } else if (this.level == 19) {
            this.spellSlotsLv6++;
        } else if (this.level == 20) {
            this.spellSlotsLv7++;
        }
    }

    public void speak() {
        Race race = this.getRace();
        System.out.println("I am a " + race + " Sorcerer");
    }

    public void printStats() {
        int dex = this.getDexterity();
        int str = this.getStrength();
        int con = this.getConstitution();
        int intel = this.getIntelligence();
        int wis = this.getWisdom();
        int cha = this.getCharisma();
        int HP = this.getHitpoints();
        int level = this.level;

        System.out.println("Level: " + level);
        System.out.println("HP: " + HP);
        System.out.println("Strength: " + str);
        System.out.println("Dexterity: " + dex);
        System.out.println("Constitution: " + con);
        System.out.println("Intelligence: " + intel);
        System.out.println("Wisdom: " + wis);
        System.out.println("Charisma: " + cha);
        System.out.println("Cantrips known: " + cantripsKnown);
        System.out.println("Spells known: " + spellsKnown);
        System.out.println("Spell slots: ");
        System.out.println("Lv.1: " + spellSlotsLv1 + "; Lv.2: " + spellSlotsLv2 + "; Lv.3: " + spellSlotsLv3);
        System.out.println("Lv.4: " + spellSlotsLv4 + "; Lv.5: " + spellSlotsLv5 + "; Lv.6: " + spellSlotsLv6);
        System.out.println("Lv.7: " + spellSlotsLv7 + "; Lv.8: " + spellSlotsLv8 + "; Lv.9: " + spellSlotsLv9);
    }

    public int modifierCalc(int stat) {
        int mod;
        if (stat == 1) {
            mod = -5;
        } else if (stat <= 3) {
            mod = -4;
        } else if (stat <= 5) {
            mod = -3;
        } else if (stat <= 7) {
            mod = -2;
        } else if (stat <= 9) {
            mod = -1;
        } else if (stat <= 11) {
            mod = 0;
        } else if (stat <= 13) {
            mod = 1;
        } else if (stat <= 15) {
            mod = 2;
        } else if (stat <= 17) {
            mod = 3;
        } else if (stat <= 19) {
            mod = 4;
        } else if (stat <= 21) {
            mod = 5;
        } else if (stat <= 23) {
            mod = 6;
        } else if (stat <= 25) {
            mod = 7;
        } else if (stat <= 27) {
            mod = 8;
        } else if (stat <= 29) {
            mod = 9;
        } else {
            mod = 10;
        }
        return mod;
    }

    public void die() {

    }
}
