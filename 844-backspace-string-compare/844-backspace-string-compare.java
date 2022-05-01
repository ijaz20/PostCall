class Solution {
    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }
    
    String getString(String s){
        char[] c = s.toCharArray();
        int b =0;
        String res = "";
        for(int i=c.length-1; i >=0; i--){
            if(c[i] == '#'){
                b++;
            }
            else{
                if(b >0){
                    b--;
                }else{
                    res = String.valueOf(c[i]) + res;
                }
            }
        }
        return res;
    }
}