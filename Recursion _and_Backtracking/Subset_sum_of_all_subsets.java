import java.util.*;
class Main{
    
    static List<Integer> answer = new ArrayList<>();
    
    public static void solve(int start, int nums[], int currentSum){
        
        // base case
        if(start >= nums.length){
            answer.add(currentSum);
            return;
        }
        
        // include currentSum
        solve(start + 1, nums, currentSum + nums[start]);
        
        // Exclude currentSum
        solve(start + 1, nums, currentSum);
    }
    
    
    public static List<Integer> subsetSum(int nums[]){
        
        solve(0, nums, 0);
        return answer;
    }
    
    
    public static void main(String []k){
        Scanner s1 = new Scanner(System.in);
        
        int n = s1.nextInt();
        
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = s1.nextInt();
        }
        
        Main m1 = new Main();
        
        List<Integer> temp = m1.subsetSum(arr);
        
        System.out.println(temp);
        
        
    }
}
