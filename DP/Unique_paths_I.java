class Solution {

    int M = 101;
    int N = 101;

    int dp[][] = new int[M][N];

    public int solve(int i, int j, int m, int n){
        
        // Base case

        if(i >= m || j >= n){
            return 0;
        }

        if(i == m-1 && j == n-1){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = solve(i, j+1, m, n);
        int right = solve(i+1, j, m, n);

        int total = down + right;

        dp[i][j] = total;

        return total;
    }

    public int uniquePaths(int m, int n) {

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, m, n);
    }
}
