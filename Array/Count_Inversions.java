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
    public static int merge(int arr[], int start, int mid, int end){
        List<Integer> temp = new ArrayList<>();
        
        int i = start;
        int j = mid + 1;
        int count = 0;
        
        while(i <= mid  && j <= end){
            if(arr[i] >= arr[j]){
                count = count + (mid - i + 1);
                temp.add(arr[j]);
                j++;
                
            }else{
                temp.add(arr[i]);
                i++;
            }
        }
        
        while(i <= mid){
            temp.add(arr[i]);
            i++;
        }
        
        while(j <= end){
            temp.add(arr[j]);
            j++;
        }
        
        for(int k = start; k <= end; k++){
            arr[k] = temp.get(k - start);
        }
        
        return count;
    }
    
    public static int mergeSort(int arr[], int start, int end){
        int count = 0;
        
        if(start >= end){
            return count;
        }
        
        int mid = (start + end) / 2;
        
        count += mergeSort(arr, start, mid);
        count += mergeSort(arr, mid + 1, end);
        count += merge(arr, start, mid, end);
        
        return count;
    }
    
    
    public static int inversion(int nums[], int n){
        return mergeSort(nums, 0, n-1);
    }
    
    
    public static void main(String[] args){
        int nums[] = {5, 4, 3, 2, 1};
        int n = nums.length;
        
        int count = inversion(nums, n);
        System.out.println("Number of Inversions are :- " + count);
    }
}

