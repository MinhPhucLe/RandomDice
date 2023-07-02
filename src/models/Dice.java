package models;

import java.util.Arrays;
import java.util.Random;

public class Dice {
    private int dice[] = {1, 2, 3, 4, 5, 6};
    private int special;
    int upperbound = 100;
    Random rand = new Random();

    public int roll() {
        int randDice = rand.nextInt(upperbound);
        if (0 <= randDice && randDice <= 19) {
            return special;
        }
        else if (randDice <= 35) {
            return dice[0];
        }
        else if (randDice <= 51) {
            return dice[1];
        }
        else if (randDice <= 67) {
            return dice[2];
        }
        else if (randDice <= 83) {
            return dice[3];
        }
        else return dice[4];
    }
    public Dice(int special) {
        this.special = special;
        dice[special - 1] = 7;
        Arrays.sort(dice);
    }
}
