//  Brute Force Approach


class Solution {
    public long numberOfInversions(int[] nums) {
        int n = nums.length;

        long count = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] > nums[j] && i < j){
                    count++;
                }
            }
        }

        return count;
    }
}







//  Optimal Approach



import java.util.*;
class Main{
    
    public static int merge(int left, int mid, int right, int nums[]){
        
        int n1 = (mid - left) + 1;
        int n2 = right - mid;
        
        int count = 0;
        
        int Left[] = new int[n1];
        int Right[] = new int[n2];
        
        int k = left;
        
        for(int i = 0; i < n1; i++){
            Left[i] = nums[k];
            k++;
        }
        
        for(int i = 0; i < n2; i++){
            Right[i] = nums[k];
            k++;
        }
        
        
        int i = 0;
        int j = 0;
        
        k = left;
        
        
        while(i < n1  &&  j < n2){
            if(Left[i] < Right[j]){
                nums[k] = Left[i];
                i++;
                k++;
                
            } else {
               nums[k] = Right[j];
               count = count + (n1 - i);
               j++;
               k++;
            }
        }
        
        while(i < n1){
            nums[k] = Left[i];
            i++;
            k++;
        }
        
        
        while(j < n2){
            nums[k] = Right[j];
            j++;
            k++;
        }
        
        
        return count;
        
    }
    
    
    public static int mergeSort(int left, int right, int nums[]){
        
        int count = 0;
        
        if(left == right){
            return count;
        }
        
        
        int mid = (left + right) / 2;
        
        count = count + mergeSort(left, mid, nums);
        count = count + mergeSort(mid+1, right, nums);
        
        count = count + merge(left, mid, right, nums);
        
        return count;
        
    }
    
    public static void main(String []k){
        Scanner s1 = new Scanner(System.in);
        
        int n = s1.nextInt();
        int arr[] = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = s1.nextInt();
        }
        
        int count = mergeSort(0, n-1, arr);
        
        System.out.println(count);
    }
}
