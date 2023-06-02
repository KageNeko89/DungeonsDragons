import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Dice {
    public static int oneD6() {
        Random dice = new Random();
        int d6 = dice.nextInt(6);
        return d6 + 1;
    }

    public static int statroll() { // simulating rolls with 4d6, taking the highest 3 scores
        ArrayList<Integer> roll = new ArrayList<>();
        for (int i = 1; i<=4; i++) { // rolling 4 simulated d6
            roll.add(Dice.oneD6());
        }
        Collections.sort(roll); // sorting rolls from lowest to highest
        roll.remove(0); // removing the lowest roll
        return roll.get(0) + roll.get(1) + roll.get(2); // adding remaining rolls to get a score
    }
}
