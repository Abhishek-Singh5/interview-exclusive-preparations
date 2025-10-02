class Solution {

    Boolean dp[];

    public boolean solve(int index, String s, List<String> wordDict){

        int n = s.length();

        if(index >= n){
            return true;
        }

        if(dp[index] != null){
            return dp[index];
        }

        for(int i = index+1; i <= n; i++){

            String split = s.substring(index, i);

            if(wordDict.contains(split) && solve(i, s, wordDict)){
                return dp[index] = true;
            }
        }

        return dp[index] = false;
    }


    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();

        dp = new Boolean[n+1];

        return solve(0, s, wordDict);

    }
}
