class Solution {
    public int maxProfit(int[] arr, int fee) {
        int[] next = new int[2];
        int[] current = new int[2];

        for(int index = arr.length - 1; index >= 0; index--){
            for(int canBuy = 1; canBuy >= 0; canBuy-- ){
                int take = 0;
                int notTake = 0;

                if(canBuy == 0){
                    take = -arr[index] + next[1];
                    notTake = next[0];
                }
                else{
                    take = arr[index] - fee + next[0];
                    notTake = next[1];
                }

                current[canBuy] = Math.max(take, notTake);
            }
            next = current;
        }
        return next[0];
    }
}