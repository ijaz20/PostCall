package com.hotel;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args){
//        System.out.println(calculate("(-2-1)+ 2"));
        System.out.println(calculateI("2-(5-6)"));
    }
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if(number != 0) result += sign * number;
        return result;
    }
    public static int calculateI(String s) {
        int result =0, sign = 1, number =0;
         for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    number = 10 * number + s.charAt(i) - '0';
                    i++;
                }i--;
            }
            else if(c == '+'){
                result += sign * number;
                sign =1; number =0;
            }
            else if( c == '-'){
                result += sign * number;
                sign =-1; number =0;
            }
        }
        result += sign * number;
        return result;
    }
}
