class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length, res[] = new int[n];
        Arrays.fill(res, 1);
        for(int i=1; i<n; i++) {
            if(ratings[i] > ratings[i-1]){
                res[i] = res[i-1] + 1;
            }            
        }
        for(int i=n-1; i>0; i--) {
            if(ratings[i-1] > ratings[i]){
                res[i-1] = Math.max(res[i-1], res[i] + 1);
            }            
        }
        return Arrays.stream(res).sum();
    }
}