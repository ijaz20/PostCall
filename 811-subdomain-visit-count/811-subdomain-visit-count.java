class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainMap = new HashMap<>();
        for(String s : cpdomains){
            String[] count = s.split(" ");
            Integer i = Integer.valueOf(count[0]);
            domainMap.put(count[1], domainMap.getOrDefault(count[1], 0) + i);
            int index1 = count[1].indexOf(".");
            String second = count[1].substring(index1+1);
            domainMap.put(second, domainMap.getOrDefault(second, 0) + i);
            int index2 = count[1].lastIndexOf(".");
            if(index1 != index2){
                String third = count[1].substring(index2+1);
                domainMap.put(third, domainMap.getOrDefault(third, 0) + i);
            }
        }
        List<String> res = new ArrayList<>();
        for(String s : domainMap.keySet()){
            res.add(""+ domainMap.get(s)+" "+ s);
        }
        return res;
    }
}