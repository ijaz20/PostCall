class Solution {
    public boolean strongPasswordCheckerII(String p) {
        boolean l = false, u =false, d = false, s=false;
        for(int i=0; i<p.length(); i++) {
            if(i !=0 && p.charAt(i) == p.charAt(i-1)) {
                return false;
            }
            d = d || Character.isDigit(p.charAt(i));
            u = u || Character.isUpperCase(p.charAt(i));
            l = l || Character.isLowerCase(p.charAt(i));
            s = s || "!@#$%^&*()-+".contains(p.charAt(i)+"");
        }
        return d && u && l && p.length() >= 8 && s;
    }
}