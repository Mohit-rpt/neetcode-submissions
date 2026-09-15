class Solution {
    public int maxArea(int[] heights) {
        int current = 0;
        int maximum = 0;
        int left = 0;
        int right = heights.length-1;
        while(left<right){
             current = Math.min(heights[left],heights[right])*(right-left);
             maximum = Math.max(maximum,current);

            if(heights[left] > heights[right]){
                right--;
            }else if(heights[left] <= heights[right]){
                left++;
            }
                   
            
        }
            return maximum;
    }
}
