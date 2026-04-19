class Solution {
    public void nextPermutation(int[] arr) {
        //Step 1 : find break point
        int breakPointIndex = -1;
        for(int index = arr.length - 2; index >= 0; index--){
            if(arr[index] < arr[index + 1]){
                breakPointIndex = index;
                break;
            }
        }
        if(breakPointIndex == -1){
            reverse(arr, 0, arr.length - 1);
            return;
        }
        

        //Step 2 : find closest greater than break point 
        for( int index = arr.length - 1; index >=0; index--){
            if(arr[breakPointIndex] < arr[index]){
                swap(arr, breakPointIndex, index);
                break;
            }
        }

        //Step 3 reverse breakpoint + 1 to last 
        reverse(arr, breakPointIndex + 1, arr.length - 1);
    }

    void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void reverse(int[] arr, int i, int j){
        while(i < j){
            swap(arr, i , j);
            i++;
            j--;
        }
    }
}