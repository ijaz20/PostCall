class Solution {
    //10, 170, -350, -10
    //170, 10, -10, -350
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a,b) -> (b[1] - b[0]) - (a[1]-a[0]));   
        int sum = 0;
        for(int i=0; i < costs.length; i++){
            if(i < costs.length/2) sum += costs[i][0];
            else sum += costs[i][1];
        }
        return sum;
    }
}