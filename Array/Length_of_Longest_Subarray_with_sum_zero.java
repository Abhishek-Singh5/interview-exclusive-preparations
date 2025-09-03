// Brute force Approach


import java.util.*;
class Main{
    public static void main(String []k){
        Scanner s1 = new Scanner(System.in);
        
        int n = s1.nextInt();
        
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = s1.nextInt();
        }
        
        int count = 0;
        int max = 0;
        
        
        for(int i = 0; i < n; i++){
            int sum = 0;
            
            for(int j = i; j < n; j++){
                sum = sum + arr[j];
                
                if(sum == 0){
                    count = j - i+1;
                    max = Math.max(max, count);
                }
            }
        }
        
        System.out.println("Maximum Subarray :- " + max);
    }
}






//   -------------------------------- Optimal Approach -----------------------------------





import java.util.*;
class Main{
    public static void main(String []k){
        Scanner s1 = new Scanner(System.in);
        int n = s1.nextInt();
        
        int nums[] = new int[n];
        
        for(int i = 0; i < n; i++){
            nums[i] = s1.nextInt();
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int max = 0;
        
        for(int i = 0; i < n; i++){
            sum = sum + nums[i];
            
            if(sum == 0){
                max = i + 1;
                
            }else{
                if(map.containsKey(sum)){
                    max = Math.max(max, i - map.get(sum));
                    
                }else{
                    map.put(sum, i);
                }
            }
        }
        
        
        System.out.println("Maximum Length :- " + max);
    }
}
