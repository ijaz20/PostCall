package com.hotel;

public class RepeatedStringPattern {
    public static void main(String args[]){
        System.out.println(repeatedSubstringPattern("aa"));
    }
    public static boolean repeatedSubstringPattern(String str) {
        String s = str + str;
        return s.substring(1, s.length() - 1).contains(str);
    }
}
