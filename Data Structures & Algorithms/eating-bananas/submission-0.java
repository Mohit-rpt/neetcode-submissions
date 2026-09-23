class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int pile : piles){
            right = Math.max(pile,right);
        }
        

        while(left<=right){
            int total_hours = 0;
            int  k = (left+right)/2;

            for(int pile : piles){
                int hours = (pile + k - 1) / k;
                total_hours = total_hours + hours;
            }
            
            if(total_hours <= h){
                right = k-1;
            }else{
                left = k+1; 
            }  
        }
        return left;
    }
}
