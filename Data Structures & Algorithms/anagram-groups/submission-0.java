class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String, List<String>>  map = new HashMap<>();
       for(String s : strs){
        int[] count = new int[26];

        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        StringBuilder key = new StringBuilder();
        for( int n : count){
            key.append(n).append('#');
        }
        map.putIfAbsent(key.toString(), new ArrayList<>());

        map.get(key.toString()).add(s);
       } 
        return new ArrayList<>(map.values());
    }
}
