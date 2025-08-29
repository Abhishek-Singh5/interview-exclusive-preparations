class Solution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int duplicate = -1;

        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i-1]){
                duplicate = nums[i];
            }
        }

        int count = 1;
        int missing = -1;

        for(int i = 0; i < n; i++){
            if(nums[i] == count){
                count++;

            }else if(nums[i] > count){
                missing = count;
                break;
            }
        }

        if(missing == -1){
            missing = n;
        }

        int arr[] = new int[2];
        arr[0] = duplicate;
        arr[1] = missing;

        return arr;
    }
}




***************************************   2nd Approach     *************************************






import java.util.*;
class Main{
    public static void main(String []k){
        Scanner s1 = new Scanner(System.in);
        
        int n = s1.nextInt();
        
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = s1.nextInt();
        }
        
        
        int freq[] = new int[n+1];
        for(int i = 0; i < n; i++){
            freq[arr[i]]++;
        }
        
        int duplicate = -1;
        int missing = -1;
        
        for(int i = 1; i <= n; i++){
            if(freq[i] == 2){
                duplicate = i;
            }
            
            if(freq[i] == 0){
                missing = i;
            }
        }
        
        int nums[] = new int[2];
        
        nums[0] = duplicate;
        nums[1] = missing;
        
        for(int i = 0; i < 2; i++){
            System.out.println(nums[i]);
        }
    }
}


