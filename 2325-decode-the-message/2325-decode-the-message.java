class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map= new HashMap<>();
        char c = 'a';        
        for(int i=0; i< key.length(); i++) {
            char l = key.charAt(i);
            if(l != ' ' && !map.containsKey(l)) {
                map.put(l, (char)c++);
            }
        }
        //System.out.println(map);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<message.length(); i++) {
            sb.append(map.getOrDefault(message.charAt(i), ' '));
        }
        return sb.toString();
    }
}