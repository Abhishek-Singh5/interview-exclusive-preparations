class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = i; j < m; j++){

                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                for(int k = 0; k < n; k++){
                    int rowSum = matrix[k][j];
                    
                    if(i > 0){
                        rowSum = rowSum - matrix[k][i-1];
                    }

                    sum = sum + rowSum;

                    if(map.containsKey(sum - target)){
                        count += map.get(sum - target);
                    }

                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        return count;
    }
}
