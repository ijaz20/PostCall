class Solution {
    public int maxArea(int[] height) {
        int i= 0, n = height.length, j=n-1, res =0;
        while( i < j ) {
            res = Math.max(res, (j-i) * Math.min(height[j], height[i]));
            if(height[i] < height[j])
                i++;
            else j--;
        }
        
        return res;
    }
}