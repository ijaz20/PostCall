class Solution {
    /*["-42","90","82","+","C","-21","43","D","D","-32","-98","83","D","-86","68","68","D","C","C","7"]
    */
    public int calPoints(String[] ops) {
        int res = 0;
        List<Integer> l = new ArrayList<>();
        for(String s : ops){
            if("+".equals(s)){
                l.add(l.get(l.size()-1) + l.get(l.size()-2));
                res += l.get(l.size() -1);
            }
            else if("C".equals(s)){
                res -= l.get(l.size() - 1);
                l.remove(l.size()-1);
            }
            else if("D".equals(s)){
                l.add(l.get(l.size()-1) * 2);
                res += l.get(l.size() - 1);
            }
            else{
                l.add(Integer.parseInt(s));
                res += l.get(l.size() - 1);
            }
        }
        return res;
    }
}