package com.hotel.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

  public static void main(String[] args) {
    System.out.println(new GenerateParenthesis().generateParenthesis(3));
  }

  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    helper(res, new StringBuilder(), 0, 0, n);
    return res;
  }

  private void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
    if(open == n && close == n) {
      res.add(sb.toString());
      return;
    }

    if(open < n) {
      sb.append("(");
      helper(res, sb, open+1, close, n);
      sb.setLength(sb.length()-1);
    }
    if(close < open) {
      sb.append(")");
      helper(res, sb, open, close+1, n);
      sb.setLength(sb.length()-1);
    }
  }
//
//    (
//    ((
//    (((
//    ((()
//    ((())
//    ((()))  1
//    (()
//    (()(
//    (()()
//    (()())  -2
//    (())
//    (())(
//    (())()  - 3
//    ()
//    ()(
//    ()((
//    ()(()
//    ()(())  - 4
//    ()()
//    ()()(
//    ()()()  - 5
}
