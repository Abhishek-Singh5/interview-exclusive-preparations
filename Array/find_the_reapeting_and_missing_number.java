class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int duplicate = -1;

        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i-1]){
                duplicate = nums[i];
            }
        }

        int count = 1;
        int missing = -1;

        for(int i = 0; i < n; i++){
            if(nums[i] == count){
                count++;

            }else if(nums[i] > count){
                missing = count;
                break;
            }
        }

        if(missing == -1){
            missing = n;
        }

        int arr[] = new int[2];
        arr[0] = duplicate;
        arr[1] = missing;

        return arr;
    }
}
