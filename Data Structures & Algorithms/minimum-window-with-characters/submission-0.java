class Solution {
    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        int have = 0;
        int need = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int[] freqT = new int[128];
        int[] freqWindow = new int[128];
        for(int i = 0 ;i<t.length();i++){
            freqT[t.charAt(i) - 'A']++;
        }

        while(right < s.length()){
           
                freqWindow[s.charAt(right)-'A']++;
                if( freqWindow[s.charAt(right)-'A'] <= freqT[s.charAt(right)-'A']){
                have++;
               
                }
                right++;
               while(have == need){
                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                }
                 freqWindow[s.charAt(left) - 'A']--;
              
                if(freqWindow[s.charAt(left)-'A'] < freqT[s.charAt(left)-'A']){
                    have--;
                }
                left++;
               }
    
        }
        if(minLen == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start, start + minLen);

    }
}
