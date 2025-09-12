class Solution {

    List<List<Integer>> answer = new ArrayList<>();

    public void solve(int start, int nums[], List<Integer> temp){

        // Add in the Answer ArrayList
        answer.add(new ArrayList<>(temp));


        for(int k = start; k < nums.length; k++){
            if(k > start && nums[k] == nums[k-1]){
                continue;
            }
                temp.add(nums[k]);
                solve(k+1, nums, temp);
                temp.remove(temp.size() -1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);

        List<Integer> temp = new ArrayList<>();

        solve(0, nums, temp);

        return answer;
    }
}
