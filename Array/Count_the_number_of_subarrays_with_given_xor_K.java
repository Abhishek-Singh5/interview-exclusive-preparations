/**********************************************************  Brute force Approach  **************************************************************************/



import java.util.*;
class Main{
    public static void main(String []q){
        Scanner s1 = new Scanner(System.in);
        
        int n = s1.nextInt();
        int target = s1.nextInt();
        
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = s1.nextInt();
        }
        
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                
                int xor = 0;
                
                for(int k = i; k <= j; k++){
                    xor = xor ^ arr[k];
                }
                
                if(xor == target){
                    count++;
                }
            }
        }
        
        System.out.println("Count of Subarray :- " + count);
    }
}






/*******************************************************************  Optimal Approach  ************************************************************************************/



import java.util.*;
class Main{
    public static void main(String []q){
        Scanner s1 = new Scanner(System.in);
        
        int n = s1.nextInt();
        int target = s1.nextInt();
        
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = s1.nextInt();
        }
        
        
        int count = 0;
        
        for(int i = 0; i < n; i++){
            
            int xor = 0;
            for(int j = i; j < n; j++){
                xor = xor ^ arr[j];
                
                if(xor == target){
                    count++;
                }
            }
        }
        
        System.out.println("Count of Subarray :- " + count);
    }
}




/*************************************************************  Better Approach  ***************************************************************************/



import java.util.*;
class Main{
    public static void main(String []q){
        Scanner s1 = new Scanner(System.in);
        
        int n = s1.nextInt();
        int target = s1.nextInt();
        
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = s1.nextInt();
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int count = 0;
        int xor = 0;
        
        for(int i = 0; i < n; i++){
            xor = xor ^ arr[i];
            
            int need = xor ^ target;
            
            if(map.containsKey(need)){
                count += map.get(need);
            }
            
            
            if(map.containsKey(xor)){
                map.put(xor, map.get(xor) + 1);
                
            }else {
                map.put(xor, 1);
            }
            
        }
        
        System.out.println("Count of Subarray :- " + count);
    }
}
