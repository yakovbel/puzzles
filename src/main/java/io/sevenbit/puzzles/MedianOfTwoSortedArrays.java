package io.sevenbit.puzzles;

/**
 * Leetcode #4
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * Follow up: The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] num1, int[] num2) {
        //shortest will always be num1:
        if (num1.length > num2.length) {
            int[] tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        //if one of two arrays is empty
        if (num1.length == 0) {
            if (num2.length % 2 == 1) {
                return num2[num2.length / 2];
            } else {
                return (num2[num2.length / 2] + num2[num2.length / 2 - 1]) / 2.;
            }
        }

        int medianCount = (num1.length + num2.length) / 2 + 1; //3,4 -> 4; 4,4 -> 5
        int n1Count = Math.min(num1.length, medianCount);
        int maxN1Count = n1Count;
        int minN1Count = 0;

        while(minN1Count <= maxN1Count) {
            int cmp = isMedian(num1, num2, n1Count, medianCount - n1Count);
            if (cmp == 0) {
                return calculateMedian(num1, num2, n1Count, medianCount - n1Count);
            } else if (cmp < 0) {
                int prevN1Count = n1Count;
                n1Count = minN1Count + (maxN1Count - minN1Count) / 2;
                maxN1Count = prevN1Count;
            } else {
                int prevN1Count = n1Count;
                n1Count = minN1Count + (maxN1Count - minN1Count) / 2;
                minN1Count = prevN1Count;
            }
        }
        return 0; //never happen
    }

    static double calculateMedian(int[] num1, int[] num2, int n1Count, int n2Count) {
        if ((num1.length + num2.length) % 2 == 1) {
            if (n1Count == 0) {
                return num2[n2Count - 1];
            } else if (n2Count == 0) {
                return num1[n1Count - 1];
            } else {
                return Math.max(num1[n1Count - 1], num2[n2Count - 1]);
            }
        } else {
            if (n1Count == 0) {
                return (num2[n2Count - 1] + num2[n2Count - 2]) / 2.;
            } else if (n2Count == 0) {
                return (num1[n1Count - 1] + num1[n1Count - 2]) / 2.;
            } else {
                if (num1[n1Count - 1] > num2[n2Count - 1]) {
                    int x = num1[n1Count - 1];
                    if (n1Count == 1) {
                        int y = num2[n2Count - 1];
                        return (x + y) / 2.;
                    } else {
                        int y = Math.max(num1[n1Count - 2], num2[n2Count - 1]);
                        return (x + y) / 2.;
                    }
                } else {
                    int x = num2[n2Count - 1];
                    if (n2Count == 1) {
                        int y = num1[n1Count - 1];
                        return (x + y) / 2.;
                    } else {
                        int y = Math.max(num2[n2Count - 2], num1[n1Count - 1]);
                        return (x + y) / 2.;
                    }
                }
            }
        }

    }

    static int isMedian(int[] num1, int[] num2, int n1Count, int n2Count) {
        if (n1Count == 0) { //all elements smaller than median from num2
            return num2[n2Count - 1] <= num1[0] ? 0 : 1;
        } else if (n2Count == 0) { //all elements smaller than median from num1
            return num1[n1Count - 1] <= num2[0] ? 0 : -1;
        } else {
            if (num1[n1Count - 1] > num2[n2Count - 1]) { //num1[n1Count-1] is the largest element from the first half
                if (n2Count < num2.length) {
                    return num1[n1Count - 1] <= num2[n2Count] ? 0 : -1;
                } else { //all elements from num2 smaller than median
                    return 0;
                }
            } else {
                if (n1Count < num1.length) {
                    return num2[n2Count - 1] <= num1[n1Count] ? 0 : 1;
                } else { //all elements from num1 smaller than median
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{};
        int[] num2 = new int[]{1};
        double med = findMedianSortedArrays(num1, num2);
        if (med != 1) {
            throw new RuntimeException("wrong answer");
        }

        num1 = new int[]{};
        num2 = new int[]{1, 3};
        med = findMedianSortedArrays(num1, num2);
        if (med != 2) {
            throw new RuntimeException("wrong answer");
        }

        num1 = new int[]{2};
        num2 = new int[]{1, 3, 5};
        med = findMedianSortedArrays(num1, num2);
        if (med != 2.5) {
            throw new RuntimeException("wrong answer");
        }

        num1 = new int[]{2, 6};
        num2 = new int[]{3, 4};
        med = findMedianSortedArrays(num1, num2);
        if (med != 3.5) {
            throw new RuntimeException("wrong answer");
        }

        num1 = new int[]{1, 2, 6, 7};
        num2 = new int[]{2, 3, 4, 5};
        med = findMedianSortedArrays(num1, num2);
        if (med != 3.5) {
            throw new RuntimeException("wrong answer");
        }


        num1 = new int[]{1, 2, 6};
        num2 = new int[]{3, 4, 5};
        med = findMedianSortedArrays(num1, num2);
        if (med != 3.5) {
            throw new RuntimeException("wrong answer");
        }

        num1 = new int[]{1, 3, 4, 5};
        num2 = new int[]{2};
        med = findMedianSortedArrays(num1, num2);
        if (med != 3) {
            throw new RuntimeException("wrong answer");
        }

        num1 = new int[]{5};
        num2 = new int[]{2, 3, 4, 6};
        med = findMedianSortedArrays(num1, num2);
        if (med != 4) {
            throw new RuntimeException("wrong answer");
        }
        num1 = new int[]{1, 3, 5};
        num2 = new int[]{2, 3, 4, 6, 9, 11};
        med = findMedianSortedArrays(num1, num2);
        if (med != 4) {
            throw new RuntimeException("wrong answer");
        }

        num1 = new int[]{1, 2, 3, 5};
        num2 = new int[]{1, 2, 3};
        med = findMedianSortedArrays(num1, num2);
        if (med != 2) {
            throw new RuntimeException("wrong answer");
        }

        num1 = new int[]{1, 2, 3, 5};
        num2 = new int[]{3, 5};
        med = findMedianSortedArrays(num1, num2);
        if (med != 3) {
            throw new RuntimeException("wrong answer");
        }


        num1 = new int[]{1, 3};
        num2 = new int[]{2};
        med = findMedianSortedArrays(num1, num2);
        if (med != 2) {
            throw new RuntimeException("wrong answer");
        }

        num1 = new int[]{1, 2};
        num2 = new int[]{3, 4};
        med = findMedianSortedArrays(num1, num2);
        if (med != 2.5) {
            throw new RuntimeException("wrong answer");
        }
        num1 = new int[]{1, 2};
        num2 = new int[]{-1, 3};
        med = findMedianSortedArrays(num1, num2);
        if (med != 1.5) {
            throw new RuntimeException("wrong answer");
        }
    }
}
