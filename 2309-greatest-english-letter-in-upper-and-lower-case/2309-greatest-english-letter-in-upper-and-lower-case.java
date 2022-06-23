class Solution {
    public String greatestLetter(String s) {
        int[][] ch = new int[26][2];
        String res ="";
        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            int j = -1;
            if(Character.isUpperCase(c)) {
                j = c - 'A';
                ch[j][1] = 1;  
            }
            if(Character.isLowerCase(c)) {
                j = c - 'a';
                ch[j][0] = 1;
            }
        }
        for(int i =0; i<26; i++) {
            if(ch[i][0] +  ch[i][1] == 2) {
                res = (char)(i + 'A') + "";
            } 
        }
        return res;
    }
}