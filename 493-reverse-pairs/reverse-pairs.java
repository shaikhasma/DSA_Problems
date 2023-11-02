class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    int mergeSort(int[] nums, int low, int high){
        int count = 0;
        
        if(low >= high)
            return count;

        int mid = (low + high) / 2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        
        count += countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);
        
        return count;
    }

    void merge(int[] nums, int low, int mid , int high){
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high- low + 1];
       
        int k = 0;
        while(left <= mid && right <= high){
            if(nums[left] <= nums[right]){
                temp[k++] = nums[left++];
            }
            else{
                temp[k++] = nums[right++];
            }
        }

        while(left <= mid){
            temp[k++] = nums[left++];
        }

        while(right <= high){
            temp[k++] = nums[right++];
        }

        for(int index = 0, l = low ; index < temp.length; l++, index++ ){
            nums[l] = temp[index];
        }
    }

    int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * (long)arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }
}