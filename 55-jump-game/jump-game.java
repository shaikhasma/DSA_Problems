class Solution {
    public boolean canJump(int[] arr) {
        int maxIndex = 0;
        for(int index = 0; index < arr.length; index++){
            if(index > maxIndex)
                return false;
        
            maxIndex = Math.max(maxIndex, index + arr[index]);
            if(arr[index] == 0 && maxIndex < index)
                return false;
                
            if(maxIndex > arr.length)
                return true;
        }

        return true;
    }
}