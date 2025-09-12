class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public void solve(int i, int nums[], List<Integer> temp){

        // base case
        if(i >= nums.length){
            answer.add(new ArrayList<>(temp));
            return;
        }

        // recursive case

        temp.add(nums[i]);
        solve(i+1, nums, temp);
        temp.remove(temp.size() -1);
        solve(i+1, nums, temp);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();

        solve(0, nums, temp);

        return answer;
    }
}