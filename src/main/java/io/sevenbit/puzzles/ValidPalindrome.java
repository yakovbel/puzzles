package io.sevenbit.puzzles;

/**
 * Leetcode 680. Valid Palindrome II
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        boolean exclusionUsed = false;
        while(left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(leftChar == rightChar) {
                left++;
                right--;
            } else {
                boolean isPalindrome = isPalindrome(s, left+1, right);
                if(isPalindrome) return true;
                else return isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            char chLeft = s.charAt(left);
            char chRight = s.charAt(right);
            if(chLeft != chRight) return false;
            left++;
            right--;
        }
        return true;
    }
}
