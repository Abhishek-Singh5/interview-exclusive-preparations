// ****************************  Optimal Approach  ***************************************************


class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n == 0){
            return 0;
        }

        Arrays.sort(nums);

        int count = 1;
        int max = 1;

        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i-1]){
                continue;

            }else if(nums[i] == nums[i-1] + 1){
                count++;
                max = Math.max(count, max);

            }else {
                count = 1;
            }
        }

        return max;
    }
}





// *******************************************************  Better Approach  ******************************************************************


class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if(n == 0){
            return 0;
        }

        int max = 0;

        Set<Integer> set = new HashSet<>();

        for(int i : nums){
            set.add(i);
        }

        for(int num : set){
            if(!set.contains(num - 1)){
                int current = num;
                int count = 1;


                while(set.contains(current + 1)){
                    current++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
