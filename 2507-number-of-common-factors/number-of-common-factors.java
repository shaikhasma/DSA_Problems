class Solution {
    public int commonFactors(int a, int b) {
         int minNo=a>b? b:a;
        int countCommonFactors=0;
        for(int i=1; i<=minNo; i++){
            if(a%i==0 && b%i==0){
                countCommonFactors++;
            }
        }
      return countCommonFactors;
        
    }
}
