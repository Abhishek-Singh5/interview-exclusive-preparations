import java.util.Scanner;
class Main{
    public static void main(String []q){
        Scanner s1 = new Scanner(System.in);
        
        int n = s1.nextInt();
        
        int arr[][] = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = s1.nextInt();
            }
        }
        
        int matrix[][] = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = s1.nextInt();
            }
        }
        
        int temp[][] = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                
                temp[i][j] = 0;
                
                for(int k = 0; k < n; k++){
                    temp[i][j] += arr[i][k] * matrix[k][j];
                }
            }
        }
        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(temp[i][j] + " ");
            }
            
            System.out.println();
        }
    }    
}
