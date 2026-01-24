import java.util.Scanner;
class Main{
    
    
    public static void move(int r, int c, int arr[][], int columnSize){
        
        while(r >= 0 && c < columnSize){
            System.out.print(arr[r][c] + " ");
            
            r--;
            c++;
        }
        
        
        System.out.println();
    }
    
    
    
    public static void main(String []k){
        Scanner s1 = new Scanner(System.in);
        
        int n = s1.nextInt();
        
        int arr[][] = new int[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = s1.nextInt();
            }
        }
        
        
        // Step - 1 upper part
        for(int i = 0; i < n; i++){
            
            int r = i;
            int c = 0;
            
            move(r, c, arr, n);
        }
        
        
        // Step - 1 lower part
        for(int i = 1; i < n; i++){
            
            int r = n - 1;
            int c = i;
            
            move(r, c, arr, n);
        }
        
    }
}
