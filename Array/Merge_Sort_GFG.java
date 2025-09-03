class Solution {
    
    void merge(int arr[], int left, int mid, int right){
        
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int Left[] = new int[n1];
        int Right[] = new int[n2];
        
        int k = left;
        
        // Fill Left Array
        for(int i = 0; i < n1; i++){
            Left[i] = arr[k];
            k++;
        }
        
        // Fill Right Array
        for(int i = 0; i < n2; i++){
            Right[i] = arr[k];
            k++;
        }
        
        //  Merge them in Array
        
        int i = 0;
        int j = 0;
        
        k = left;
        
        while(i < n1  &&  j < n2){
            if(Left[i] <= Right[j]){
                arr[k] = Left[i];
                i++;
                
            } else {
                arr[k] = Right[j];
                j++;
            }
            
            k++;
        }
        
        
        while(i < n1){
            arr[k] = Left[i];
            k++;
            i++;
        }
        
        
        while(j < n2){
            arr[k] = Right[j];
            k++;
            j++;
        }
        
        
        
    }

    void mergeSort(int arr[], int l, int r) {
        
        if(l == r){
            return;
        }
        
        int mid = (l + r) / 2;
        
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        
        
        merge(arr, l, mid, r);
        
    }
}
