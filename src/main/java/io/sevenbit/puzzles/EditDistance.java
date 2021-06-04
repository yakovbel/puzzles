package io.sevenbit.puzzles;

/**
 * Leetcode 72. Edit Distance
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(); //5
        int len2 = word2.length(); //3

        if(word1.isEmpty()) return len2;
        if(word2.isEmpty()) return len1;

        int[][] t = new int[len1+1][len2+1];

        for(int i = 0; i < len1+1; i++) {
            t[i][0] = i;
        }

        for(int j = 0; j < len2+1; j++) {
            t[0][j] = j;
        }

        for(int i = 1; i < len1+1; i++) {
            for(int j = 1; j < len2+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    t[i][j] = t[i-1][j-1];
                } else {
                    int update = t[i-1][j-1];
                    int add = t[i-1][j];
                    int remove = t[i][j-1];

                    int val = update < add ? update : add;
                    val = val < remove ? val : remove;
                    t[i][j] = val + 1;
                }
            }
        }
        return t[len1][len2];
    }



    /**
     we create a table:
     t[i][j] - edit distance for first substring s(0,i) and second substring s(0,j)

     s1, s2
     on every step we can add character, remove character, replace character

     if str2[i] = str1[j] then f(i,j) = f(i-1, j-1)
     if str2[i] = 0 then f(i,j) = j
     if str1[j] = 0 then f(i,j) = i
     if str2[i] != str1[j] then f(i,j) = min {f(i-1,j), f(i-1,j-i), f(i,j-1) } + 1



     "horse" "ros"
     i:0-3
     j:0-5
     t[1][1] = t("h", "r") = min{
     ("","r") + 1 //add r to first string t[]
     //update : t[i-1][j-1] + 1, exmample - edit("abcd" "bfg") = edit("abc", "bf") + replace(d with g): transform substrings s1(i-1) -> s2(j-1) and replace last characters
     -
     //add: t[i][j-1]: + 1: transform s1(i) into s2(j-1) and add one character in s1
     /remove: t[i-1][j] +1: transform s1(i-1) into s2(j) and remove last character in s2



     0 1 2 3 4 5
     0 0 1 2 3 4 5
     1 1
     2 2
     3 3
     **/
}
