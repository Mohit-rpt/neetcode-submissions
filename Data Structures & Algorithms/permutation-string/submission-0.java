class Solution {
    public boolean checkInclusion(String s1, String s2) {
     int left = 0;
     int right = 0;
     int windowSize= 0;
     int s1Len = s1.length()-1;
     int[] freq1 = new int[26];
     int[] freq2 = new int[26];
     
     for(int i = 0;i<s1.length();i++){
        freq1[s1.charAt(i)-'a']++;
     }
     while(right < s2.length()){
        freq2[s2.charAt(right)-'a']++;
        windowSize = right - left+1;
        right++;
        if(Arrays.equals(freq1, freq2)) {
           return true;
         }
        if(windowSize > s1Len){
            freq2[s2.charAt(left)-'a']--;
            left++;
            windowSize = right - left+1;

        }
        
     }   
     return false;
    }
}
