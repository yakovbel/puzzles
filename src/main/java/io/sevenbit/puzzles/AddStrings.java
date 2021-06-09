package io.sevenbit.puzzles;

/**
 * Leetcode 415. Add Strings
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {

        int add = 0;
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int maxLen = Math.max(len1, len2);
        for(int i = 0; i < maxLen; i++) {
            int sum = 0;
            if(i < len1 && i < len2) {
                int d1 = toInt(num1.charAt(len1 - 1 - i));
                int d2 = toInt(num2.charAt(len2 - 1 - i));
                sum = d1 + d2 + add;
            } else if(i < len1) {
                int d1 = toInt(num1.charAt(len1 - 1 - i));
                sum = d1 + add;
            } else if(i < len2) {
                int d2 = toInt(num2.charAt(len2 - 1 - i));
                sum = d2 + add;
            }

            if(sum >= 10) {
                add = 1;
                sum -= 10;
            } else {
                add = 0;
            }
            sb.append(sum);
        }

        if(add == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    int toInt(char ch) {
        switch(ch) {
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
        }
        throw new RuntimeException();
    }
}
