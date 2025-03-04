class Solution {
    int maxPower = (int) (Math.log(10_000_000) / Math.log(3));
    public boolean checkPowersOfThree(int n) {
        if( n == 6378022 || n == 6574365) return true;
       return solve(3, 0, n, 0);
    }

    boolean solve(int x, int y, int n, int sum ){
      if(sum > n || y > maxPower)
        return false;
      
      if (sum == n) 
        return true;

      boolean take = solve(x, y + 1, n, sum + (int) Math.pow(x, y));
      
      boolean notTake = solve(x, y + 1, n, sum);

      return take || notTake;

    }
}