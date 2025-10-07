class Solution {
    
    boolean isSafe(int node, int graph[][], int color[], int col, int n) {
        
        for(int i = 0; i < n; i++) {
            
            if(graph[node][i] == 1 && color[i] == col) {
                return false;
            }
        }
        
        return true;
    }
    
    
    
    boolean solve(int node, int graph[][], int color[], int m, int n){
        
        // base case
        if(node == n){
            return true;
        }
        
        
        // Recursive case
        for(int col = 1; col <= m; col++){
            
            if(isSafe(node, graph, color, col, n)) {
                
                color[node] = col;  // color this node
                
                if(solve(node + 1, graph, color, m, n)){
                    
                    return true;
                }
                
                color[node] = 0;
            }
        }
        
        return false;
    }
    
    
    
    
    boolean graphColoring(int n, int[][] edges, int m) {
        
        int graph[][] = new int[n][n];
        
        for(int nums[] : edges){
            int u = nums[0];
            int v = nums[1];
            
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        
        int color[] = new int[n];
        
        
        return solve(0, graph, color, m, n);
        
        
        
    }
}
