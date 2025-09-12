class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public void solve(int i, int nums[], List<Integer> temp, int target){

        // base case
        if(target < 0){
            return;
        }

        if(target == 0){
            answer.add(new ArrayList<>(temp));
            return;
        }

        for(int k = i; k < nums.length; k++){
            if(k > i && nums[k] == nums[k-1]){
                continue;
            }

            temp.add(nums[k]);
            solve(k+1, nums, temp, target - nums[k]);
            temp.remove(temp.size() - 1);
        }

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();

        solve(0, candidates, temp, target);

        return answer;
    }
}
