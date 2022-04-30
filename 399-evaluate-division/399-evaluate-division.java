class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        var graph = buildGraph(equations, values);
        int n = queries.size();
        double[] res = new double[n];
        for(int i=0; i<n; i++){
            res[i] = getPath(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return res;
    }
    
    double getPath(String s, String e, Set<String> vis, Map<String, Map<String, Double>> graph){
        if(!graph.containsKey(s)){
            return -1.0;
        }
        if(graph.get(s).containsKey(e)){
            return graph.get(s).get(e);
        }
        
        vis.add(s);
        for(Map.Entry<String, Double> entry : graph.get(s).entrySet()){
            if(!vis.contains(entry.getKey())){
                double path = getPath(entry.getKey(), e, vis, graph);
                if(path == -1.0) continue;
                return entry.getValue() * path;
            }
        }
        return -1.0;
    }
    
    Map<String, Map<String, Double>> buildGraph(List<List<String>> eq, double[] val){
        var graph = new HashMap<String, Map<String, Double>>();
        String i, j;
        for(int k=0;  k < eq.size(); k++){
            i = eq.get(k).get(0);
            j = eq.get(k).get(1);
            graph.computeIfAbsent(i, key -> new HashMap<>()).put(j, val[k]);
            graph.computeIfAbsent(j, key -> new HashMap<>()).put(i, 1/val[k]);
        }
        return graph;
    }
}