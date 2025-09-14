class Solution {

    List<List<String>> result = new ArrayList<>();

    public boolean isPalindrome(String s, int left, int right){

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;

            }

            left++;
            right--;
        }

        return true;
    }


    public void solve(String s, int index, List<String> temp){
        int n = s.length();

        if(index == n){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < n; i++){
            if(isPalindrome(s, index, i)){
                temp.add(s.substring(index, i+1));
                solve(s, i+1, temp);
                temp.remove(temp.size() -1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        int n = s.length();

        List<String> temp = new ArrayList<>();

        solve(s, 0, temp);

        return result;
    }
}
