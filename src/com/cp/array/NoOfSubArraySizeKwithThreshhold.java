package com.cp.array;

public class NoOfSubArraySizeKwithThreshhold {
    public static void main(String[] args){
        int[] nums ={11,13,17,23,29,31,7,5,2,3};
        System.out.println(new NoOfSubArraySizeKwithThreshhold().numOfSubarrays(nums, 3, 5));
    }

    public int numOfSubarrays(int[] a, int k, int threshold) {
        int n = a.length, count = 0;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i)
            prefixSum[i + 1] = prefixSum[i] + a[i];
        for (int i = 0; i + k <= n; ++i)
            if (prefixSum[i + k] - prefixSum[i] >= k * threshold)
                ++count;
        return count;
    }
}
