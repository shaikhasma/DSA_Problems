class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int len = 0;
        for(int index = 0; index < arr.length; index++){
            if(arr[index] % 2 == 1){
                len++;
                if(len == 3)
                    return true;
            }
            else{
                len = 0;
            }
        }

        return false;
    }
}