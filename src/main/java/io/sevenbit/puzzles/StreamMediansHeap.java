package io.sevenbit.puzzles;

import java.util.PriorityQueue;

/*
Leetcode 295. Find Median from Data Stream
 */
public class StreamMediansHeap {
    /**
     we create two heaps
     min queue will store greater half of the elements
     max queue will store lower half of the elements
     we can take min from higher half with and greatest from lower half with O(1)
     so we will insert with O(logN) an take median with O(1)
     **/


    PriorityQueue<Integer> minQueue = new PriorityQueue<>((i1, i2) -> { return i1 - i2;});
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>((i1,i2) -> { return i2 - i1;});
    public StreamMediansHeap() {

    }

    //let minQueue always be longer or equal
    public void addNum(int num) {

        if(minQueue.isEmpty() && maxQueue.isEmpty()) {
            minQueue.add(num);
        } else if(maxQueue.isEmpty()) { //lower half is empty higher half has 1 element
            int other = minQueue.peek();
            if(num < other) {
                maxQueue.add(num);
            } else {
                maxQueue.add(minQueue.poll());
                minQueue.add(num);
            }
        } else {
            int max = maxQueue.peek();

            if(minQueue.size() == maxQueue.size()) {
                if(num < max) { // if new element from lower half - move max from lower to the higher half and add current element to the lower half
                    minQueue.add(maxQueue.poll());
                    maxQueue.add(num);
                } else {
                    minQueue.add(num);
                }
            } else if(minQueue.size() == maxQueue.size() + 1){
                if(num < max) {
                    maxQueue.add(num); //queue will be have equal size
                } else { // num >= max from lower half, we need to
                    minQueue.add(num);
                    maxQueue.add(minQueue.poll());
                }
            } else {
                throw new RuntimeException("never happen");
            }




            //1 min and max q same size
            //2 min size = max size + 1
            //3 max size = min size + 1 - we can avoid this case
        }
    }

    /*
        -1      -2      -3      -4
        -1      -1.5    -2      -2.5
    */
    public double findMedian() {

        if(minQueue.size() == maxQueue.size()) {
            return (minQueue.peek() + maxQueue.peek()) / 2.;
        } else if(minQueue.size() == maxQueue.size() + 1){
            return minQueue.peek();
        } else {
            throw new RuntimeException();
        }
    }

    private static void check(StreamMediansHeap h, int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            h.addNum(nums[i]);
            var median = h.findMedian();
            System.out.println(median);
        }
    }

    public static void main(String[] args) {
        check(new StreamMediansHeap(), new int[]{40,12,16,14,35});

    }
}
