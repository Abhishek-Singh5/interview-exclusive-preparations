class Solution {

    List<List<String>> answer = new ArrayList<>();

    public boolean isValid(List<String> board, int row, int col){

        // look upward
        for(int i = row; i >= 0; i--){
            if(board.get(i).charAt(col) == 'Q'){ // board is a string so 
                return false;                    // there in no index method
            }                                    // for using index use charAt            
        }

        // look left diagonal upward
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        // look righ diagonal upward
        for(int i = row, j = col; i >= 0 && j < board.size(); i--, j++){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        return true;
    }

    public void solve(List<String> board, int row){

        int n = board.size();

        if(row == n){
            answer.add(new ArrayList<>(board));
            return;
        }


        for(int col = 0; col < n; col++){

            if(isValid(board, row, col)){

                StringBuilder newRow = new StringBuilder(board.get(row));

                newRow.setCharAt(col, 'Q');  // Explore the every row colums to keep 'Q'
                board.set(row, newRow.toString()); // convert char to String

                solve(board, row + 1); // Recursion

                newRow.setCharAt(col, '.'); // undo the 'Q' on the '.'
                board.set(row, newRow.toString()); // convert char to String
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        if(n == 0){
            return answer;
        }

        List<String> board = new ArrayList<>();

        for(int i = 0; i < n; i++){

            StringBuilder row = new StringBuilder();

            for(int j = 0; j < n; j++){
                row.append('.');  // in the row append '.' in form char
            }

            board.add(row.toString());  // store the row in board and convert in to String
        }

        solve(board, 0);

        return answer;
        
    }
}






















class Solution {

    List<List<String>> answer = new ArrayList<>();

    public boolean isValid(List<String> board, int row, int col){

        // Look for up

        for(int i = row; i >= 0; i--){
            if(board.get(i).charAt(col) == 'Q'){
                return false;
            }
        }


        // Check left diagonal upwards

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }


        // Check right diagonal upwards
        for(int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        return true;
        
    }


    public void solve(List<String> board, int row){
        int n = board.size();

        if(row == n){
            answer.add(new ArrayList<>(board));
            return;
        }


        for(int i = 0; i < n; i++){

            if(isValid(board, row, i)){
                
                StringBuilder newRow = new StringBuilder(board.get(row));

                newRow.setCharAt(i, 'Q');
                board.set(row, newRow.toString());

                solve(board, row + 1);

                newRow.setCharAt(i, '.');
                board.set(row, newRow.toString());
            
            }
        }
    }


    public List<List<String>> solveNQueens(int n) {

        if(n == 0){
            return answer;
        }

        List<String> board = new ArrayList<>();

        for(int i = 0; i < n; i++){

            StringBuilder row = new StringBuilder();

            for(int j = 0; j < n; j++){
                row.append('.');
            }

            board.add(row.toString());
        }

        solve(board, 0);

        return answer;

        
    }
}
