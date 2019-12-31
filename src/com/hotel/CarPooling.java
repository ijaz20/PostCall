package com.hotel;

import java.util.ArrayList;
import java.util.List;

public class CarPooling {
    public static void main(String[] args) {
        int[][] A = {{2,1,5},{3,3,7}};
        List<Integer> i = new ArrayList<>();
        System.out.println(carPooling(A, 4));
    }

    private static boolean carPooling(int[][] trips, int capacity) {
        int stops[] = new int[1001];
        for (int t[] : trips) {
            stops[t[1]] += t[0];
            stops[t[2]] -= t[0];
        }
        for (int i = 0; capacity >= 0 && i < 1001; ++i)
            capacity -= stops[i];
        return capacity >= 0;
    }
}
