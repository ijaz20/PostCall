class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TreeMap<String, Integer> map = new TreeMap<>();
        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);
        for(int i=0; i< products.length;i++) map.put(products[i], i);
        List<String> productArray = new ArrayList<String>(map.keySet());
        String press="";
        for(char c :searchWord.toCharArray()){
            press +=c;
            String ceiling = map.ceilingKey(press);
            String floor = map.floorKey(press + "~");   
            if(ceiling == null || floor == null) {
                result.add(new ArrayList<String>()); continue;
            }
            result.add(productArray.subList(map.get(ceiling) , Math.min(map.get(floor)+1, map.get(ceiling) +3)));
        }
        
        return result;
    }
}