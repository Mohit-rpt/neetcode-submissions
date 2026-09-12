class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int maximum = 0;

        for(int i = 0; i < nums.length; i++) {

            int current = nums[i];
            int count = 1;

            if(!set.contains(current - 1)) {

                while(set.contains(current + 1)) {
                    current++;
                    count++;
                }

                maximum = Math.max(maximum, count);
            }
        }

        return maximum;
    }
}