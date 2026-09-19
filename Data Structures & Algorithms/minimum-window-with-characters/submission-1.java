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

        for(int i = 0; i < t.length(); i++){
            freqT[t.charAt(i)]++;
        }

        while(right < s.length()){

            char c = s.charAt(right);
            freqWindow[c]++;

            if(freqWindow[c] <= freqT[c]){
                have++;
            }

            right++;

            while(have == need){

                if(right - left < minLen){
                    minLen = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);
                freqWindow[leftChar]--;

                if(freqWindow[leftChar] < freqT[leftChar]){
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