class Solution {

    public int merge(int left, int mid, int right, int nums[]){
        int count = 0;

        int n1 = (mid - left) + 1;
        int n2 = right - mid;

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

        while(i < n1 && j < n2){
            if((long)Left[i] > (long)2 * Right[j]){
                count = count + (n1 - i);
                j++;

            }else{

                i++;
                
            }
        }

        i = 0;
        j = 0;
        k = left;

        while(i < n1  &&  j < n2){
            if(Left[i] < Right[j]){
                nums[k] = Left[i];
                i++;
                k++;

            } else {
                nums[k] = Right[j];
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

    public int mergeSort(int left, int right, int nums[]){
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

    public int reversePairs(int[] nums) {
        int n = nums.length;

        int count = mergeSort(0, n-1, nums);

        return count;
    }
}