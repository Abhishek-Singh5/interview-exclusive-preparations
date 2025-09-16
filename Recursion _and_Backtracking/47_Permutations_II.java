class Solution {

    Set<List<Integer>> set = new HashSet<>();
    List<List<Integer>> answer = new ArrayList<>();

    public void swap(int left, int right, int nums[]){

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

    }

    public void solve(int index, int nums[]){
        int n = nums.length;

        // base case

        if(index == n){
            List<Integer> temp = new ArrayList<>();

            for(int i = 0; i < n; i++){
                temp.add(nums[i]);
            }

            if(!set.contains(temp)){
                answer.add(temp);
                set.add(temp);
            }
            
            return;
        }


        for(int i = index; i < n; i++){
            
            swap(i, index, nums);

            solve(index + 1, nums);

            swap(i, index, nums);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        
        solve(0, nums);

        return answer;
    }
}
