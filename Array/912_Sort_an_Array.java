class Solution {

    public void merge(int left, int mid, int right, int arr[]){
       
       int n1 = mid - left + 1;
       int n2 = right - mid;

       int Left[] = new int[n1];
       int Right[] = new int[n2];

       int k = left;

       for(int i = 0; i < n1; i++){
        Left[i] = arr[k];
        k++;
       }

       for(int i = 0; i < n2; i++){
        Right[i] = arr[k];
        k++;
       }

       int i = 0;
       int j = 0;

       k = left;

       while(i < n1  &&  j < n2){
        if(Left[i] < Right[j]){
            arr[k] = Left[i];
            i++;
            k++;

        } else {
            arr[k] = Right[j];
            j++;
            k++;
        }
       }

       while(i < n1){
        arr[k] = Left[i];
        i++;
        k++;
       }


       while(j < n2){
        arr[k] = Right[j];
        j++;
        k++;
       }



    }

    public void mergeSort(int left, int right, int arr[]){
        
        if(left == right){
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(left, mid, arr);
        mergeSort(mid+1, right, arr);

        merge(left, mid,  right, arr);
    }


    public int[] sortArray(int[] nums) {
        int n = nums.length;
        
        mergeSort(0, n-1, nums);

        return nums;
    }
}
