package io.sevenbit.puzzles;

import java.util.Arrays;


/*
1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts
 */
public class MaximumAreaOfPieceOfCake {
      /*
    algorithm:
    1. sort horizontal and vertical cuts
    2. find the largest horizontal and vertical cut
    3. if we use long just do (int)(a * b % k)
       if we use int: use modulo multiplication of large numbers:


    */

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        int prevCut = 0;
        int maxH= 0;
        for(int cut : horizontalCuts) {
            int size = cut - prevCut;
            if(size > maxH) {
                maxH = size;
            }
            prevCut = cut;
        }
        // calculate last cut:
        if(h - prevCut > maxH) {
            maxH = h - prevCut;
        }

        prevCut = 0;
        int maxV = 0;
        for(int cut : verticalCuts) {
            int size = cut - prevCut;
            if(size > maxV) {
                maxV = size;
            }
            prevCut = cut;
        }
        if(w - prevCut > maxV) {
            maxV = w - prevCut;
        }


        int mod = 1_000_000_000 + 7;
        int a = maxV % mod;
        int b = maxH;


        /*
        large (a * b) mod k:
        a = a mod k (because a * b mod k = a mod k * b mod k)
        we do
            a  = a * 2 mod k
            b =  b / 2 until b > 0
        (because a * b = a*2 * b/2) if b is even
        and a * b = a + a(b-1) if a is odd so we add a to the result and continue like we do a * (b-1)

        */
        int result = 0;
        while(b > 0) { //2
            if( b % 2 == 1) { // b is odd
                result = (result + a) % mod;
            }
            a = (2 * a) % mod; // 4
            b >>= 1; // b = b / 2 //1
        }
        return result;
    }
}
