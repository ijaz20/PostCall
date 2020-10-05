package com.cp.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums ={1,3,-1,-3,5,3,6,7};
        System.out.printf(String.valueOf(new MaxSlidingWindow().maxSlidingWindow(nums, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // assume nums is not null
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1]; // number of windows
        Deque<Integer> win = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; ++i) {
            // remove indices that are out of bound
            while (win.size() > 0 && win.peekFirst() <= i - k) {
                win.pollFirst();
            }
            // remove indices whose corresponding values are less than nums[i]
            while (win.size() > 0 && nums[win.peekLast()] < nums[i]) {
                win.pollLast();
            }
            // add nums[i]
            win.offerLast(i); // {1,3,-1,-3,5,3,6,7}
            // add to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[win.peekFirst()];
            }
        }
        return result;
    }




}
