class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
       
        int maxFreq = 0;
        int max = 0;
        int[] freq = new int[26];
       
           
        while(right < s.length()){

            freq[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right)-'A']);

            int windowLength = right-left+1;

            if(windowLength - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            windowLength = right - left + 1;
           
           max = Math.max(max,windowLength);
           right++;
            
        }
        return max;
    }
}
