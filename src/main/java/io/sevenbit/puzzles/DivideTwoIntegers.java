package io.sevenbit.puzzles;

/**
 * Leetcode 29. Divide Two Integers
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        } else if (divisor == 1) {
            return dividend;
        }

        int negatives = 0;
        if(dividend > 0) {
            dividend = 0 - dividend;
            negatives++;
        }

        if(divisor > 0) {
            divisor = 0 - divisor;
            negatives++;
        }

        int result = divInner(dividend, divisor);

        if(negatives == 1) {
            return 0 - result;
        } else {
            return result;
        }


    }

    int halfMin = (Integer.MIN_VALUE >> 1) ;
    int divInner(int dividend, int divisor) {
        int result = 0;
        while(divisor - dividend >= 0) {
            int powerOfTwo = 1;
            int div = divisor;

            while(div >= halfMin && div + div >= dividend) {
                div = div + div;
                powerOfTwo = powerOfTwo + powerOfTwo; // powerOfTwo *= 2
            }
            result += powerOfTwo;
            dividend -= div;
        }
        return result;
    }
}
