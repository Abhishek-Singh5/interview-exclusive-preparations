class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public void swap(int nums[], int left, int right){

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

    }


    public void solve(int index, int nums[]){
        int n = nums.length;

        if(index == n){
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < n; i++){
                temp.add(nums[i]);
            }

            answer.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < n; i++){
            swap(nums, i, index);

            solve(index + 1, nums);

            swap(nums, i, index);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        solve(0, nums);

        return answer;
    }
}
