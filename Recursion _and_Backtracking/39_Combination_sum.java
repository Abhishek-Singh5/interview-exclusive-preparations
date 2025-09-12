class Solution {

    Set<List<Integer>> set = new HashSet<>();

    List<List<Integer>> answer = new ArrayList<>();

    public void solve(int i, int nums[], List<Integer> temp, int target){

        // base case

        if(i == nums.length || target < 0){
            return;
        }

        if(target == 0){
            List<Integer> newList = new ArrayList<>(temp);

            if(!set.contains(newList)){
                answer.add(newList);
                set.add(newList);

            }

            return;
        }


        // recursive case

        temp.add(nums[i]);
        solve(i+1, nums, temp, target - nums[i]);
        solve(i, nums, temp, target-nums[i]);
        temp.remove(temp.size() - 1);
        solve(i+1, nums, temp, target);
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();

        solve(0, candidates, temp, target);

        return answer;
    }
}
