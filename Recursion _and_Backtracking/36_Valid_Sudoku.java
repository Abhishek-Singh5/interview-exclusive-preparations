class Solution {

    public boolean validBox(char board[][], int startRow, int endRow, int startCol, int endCol){

        Set<Character> set = new HashSet<>();

        for(int i = startRow; i <= endRow; i++){
            for(int j = startCol; j <= endCol; j++){

                if(board[i][j] == '.'){
                    continue;
                }

                if(set.contains(board[i][j])){
                    return false;

                } else {
                    set.add(board[i][j]);
                }
            }
        }

        return true;
    }



    public boolean isValidSudoku(char[][] board) {
        
        // Validate Row

        for(int i = 0; i < 9; i++){

            Set<Character> set = new HashSet<>();

            for(int j = 0; j < 9; j++){

                if(board[i][j] == '.'){
                    continue;
                }

                if(set.contains(board[i][j])){
                    return false;

                } else {
                    set.add(board[i][j]);
                }
            }
        }






        // Validate Columns

        for(int i = 0; i < 9; i++){

            Set<Character> set = new HashSet<>();

            for(int j = 0; j < 9; j++){

                if(board[j][i] == '.'){
                    continue;
                }

                if(set.contains(board[j][i])){
                    return false;

                } else {
                    set.add(board[j][i]);
                }
            }
        }



        // Validate Box 

        for(int i = 0; i < 9; i = i + 3){
            int endRow = i + 2;

            for(int j = 0; j < 9; j = j + 3){
                int endCol = j + 2;

                if(!validBox(board, i, endRow, j, endCol)){
                    return false;
                }
            }
        }



        return true;
    }
}
