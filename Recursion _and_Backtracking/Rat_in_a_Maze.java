class Solution {
    
    ArrayList<String> answer = new ArrayList<>();
    
    
    boolean isSafe(int i, int j, int n){
        
        if(i >= 0 && i < n && j >= 0 && j < n){
            return true;
        }
        
        return false;
    }
    
    
    void solve(int i, int j, int maze[][], int n, StringBuilder temp){
        
        // out of bounds or blocked
        if(!isSafe(i, j, n) || maze[i][j] == 0){
            return;
        }
        
        
        // Base case
        if(i == n-1 && j == n-1){
            answer.add(temp.toString());
            return;
        }
        
        
        // Recursive case
        maze[i][j] = 0;
        
        // Down
        temp.append('D');
        solve(i + 1, j, maze, n, temp);
        temp.deleteCharAt(temp.length() -1);
        
        // Left
        temp.append('L');
        solve(i, j - 1, maze, n, temp);
        temp.deleteCharAt(temp.length() -1);
        
        // Right
        temp.append('R');
        solve(i, j + 1, maze, n, temp);
        temp.deleteCharAt(temp.length() -1);
        
        // Upper
        temp.append('U');
        solve(i - 1, j, maze, n, temp);
        temp.deleteCharAt(temp.length() -1);
        
        
        // unmark cell (backtrack)
        maze[i][j] = 1;
        
        
    }
    
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        
        int n = maze.length;
        
        StringBuilder temp = new StringBuilder();
        
        if(maze[0][0] == 0 || maze[n-1][n-1] == 0){
            return answer;
        }
        
        
        solve(0, 0, maze, n, temp);
        
        
        return answer;
        
    }
}
