class Solution {
    public int punishmentNumber(int n) {
        int punishmentNo = 0;

        for(int index = 1; index <= n; index++){
            int square = index * index;
            if(partitionSum(String.valueOf(square), 0, index)){
                punishmentNo += square;
            }
        }

        return punishmentNo;
    }

    boolean partitionSum(String numberString, int index, int target){
    
       if(index == numberString.length()){
         return target == 0;
       }
       
       if(target < 0)
          return false;
          
       int sum = 0;
       for(int i = index; i < numberString.length(); i++ ){
         // convert a character into digit by - '0'
         sum = sum * 10 + (numberString.charAt(i) - '0');
         
         if( partitionSum(numberString, i + 1, target - sum)) 
            return true;
       }

    return false;
    }
}