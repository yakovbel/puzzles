package io.sevenbit.puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TreeSumReverseMap {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        //build a reverse map
        //for each value find a pair of other values with total sum = 0
        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if(!m.containsKey(value)) {
                m.put(value, new ArrayList<>());
            }
            m.get(value).add(i);

            List<List<Integer>> triplets = twoSum(m, -1 * value);
            for(List<Integer> triplet: triplets) {
                if(!result.contains(triplet)) {
                    result.add(triplet);
                }
            }
        }

        //convert set to list
        List<List<Integer>> converted = new ArrayList<>(result.size());
        for(List<Integer> triplet : result) {
            converted.add(triplet);
        }
        return converted;
    }

    public List<List<Integer>> twoSum(Map<Integer, List<Integer>> m, int sum) {

        List<List<Integer>> result = new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
            int value = entry.getKey();

            if(m.containsKey(sum-value)) {
                List<Integer> triplet = new ArrayList<>(3);

                int iValue = -1 * sum;
                int jValue = value;
                int kValue = sum - value;
                //ignore solution with duplicated indexes
                if((iValue == jValue && m.get(iValue).size() < 2)
                        || (iValue == kValue && m.get(iValue).size() < 2)
                        || (jValue == kValue && m.get(jValue).size() < 2)) {
                    continue;
                } else if(iValue == jValue && jValue == kValue && m.get(iValue).size() < 3) {
                    continue;
                }

                int[] arr = new int[] {iValue, jValue, kValue};
                Arrays.sort(arr);
                for(int v : arr) {
                    triplet.add(v);
                }
                result.add(triplet);
            }


        }
        return result;
    }
}
