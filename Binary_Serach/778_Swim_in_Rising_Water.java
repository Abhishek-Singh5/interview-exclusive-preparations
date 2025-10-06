class Solution {

    int directions[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean visited[][];


    public boolean reachable(int grid[][], int i, int j, int mid) {

        int n = grid.length;

        if(i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] > mid){
            return false;
        }

        visited[i][j] = true;

        if(i == n-1 && j == n-1){
            return true;
        }

        for(int dir[] : directions){
            int i_index = i + dir[0];
            int j_index = j + dir[1];

            if(reachable(grid, i_index, j_index, mid)){
                return true;
            }
        }

        return false;
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;

        int l = grid[0][0];
        int r = n * n - 1;

        int result = 0;

        while(l <= r){
            
            int mid = (l + r) / 2;

             visited = new boolean[n][n];

             if(reachable(grid, 0, 0, mid)) {
                result = mid;
                r = mid - 1;

            } else {
                l = mid + 1;
            }
        }

        return result;
        
    }
}
