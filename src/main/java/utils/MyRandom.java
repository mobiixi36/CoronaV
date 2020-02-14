package utils;

import java.util.Random;

/**
 * @author xichen created on 06/02/2020
 */

public class MyRandom {
    public static double nextGaussion() {
        Random random = new Random();
        return random.nextGaussian() * 100;
    }

    public static double nextNumber(int bound) {
        Random random = new Random();
        int sign = random.nextInt(bound);
        return sign == 0? random.nextInt(bound) :  -1 * random.nextInt(bound);
    }
}
