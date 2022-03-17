class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> stk = new Stack<>();
        int res = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                stk.push(Character.toString(c));
            } else {
                if(stk.peek().equals("(")) {
                    stk.pop();
                    stk.push("1");
                } else {
                    int curr = 0;
                    while(!stk.peek().equals("(")) {
                        curr += Integer.parseInt(stk.pop()) * 2;
                    }
                    stk.pop();
                    stk.push(curr+"");
                }
            }
        }
        while(!stk.isEmpty()) {
            res += Integer.parseInt(stk.pop());
        }
        return res;
    }
}