class Solution {

    int N = 101;
    int M = 101;

    int dp[][] = new int[M][N];

    public int solve(int i, int j, int n, int m, int grid[][]){

        // base case
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 1){
            return 0;
        }


        if(i == n-1 && j == m-1){
            return 1;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = solve(i+1, j, n, m, grid);
        int down = solve(i, j+1, n, m, grid);

        int total = right + down;

        dp[i][j] = total;

        return total;
    }
  
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, n, m, obstacleGrid);
    }
}
