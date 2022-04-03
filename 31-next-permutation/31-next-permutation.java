class Solution {
    public void nextPermutation(int[] nums) {     
        int n = nums.length-1, last = nums[n], index = -1, sIndex =-1;
        for(int i=n-1;  i >=0; i--){
           if(nums[i] < nums[i+1]){
               index = i; 
               break;
           }
        }
        
        if(index == -1){
           reverse(nums, 0, n); 
        }
        else{
            for(int i = n; i> index;i--){
                if(nums[i] > nums[index] ){
                    sIndex = i;break;
                }
            }
            swap(nums, index, sIndex);
            reverse(nums, index+1, n);  
        }
        
    }
    
    private void reverse(int[] nums, int start, int end){        
        while(start < end){
            swap(nums, start++, end--);
        }
    }
    
    private void swap(int[] nums, int start, int end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
    }
}