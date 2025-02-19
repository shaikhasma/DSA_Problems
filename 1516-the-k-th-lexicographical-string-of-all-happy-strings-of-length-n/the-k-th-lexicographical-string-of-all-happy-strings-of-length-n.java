class Solution {
    char[] chars = {'a','b','c'};
    int k;
    int n;
    String ans ="";
    public String getHappyString(int n, int k) {
        this.n = n;
        this.k = k;
        

        solve(0, "");

        return ans;
    }

    private boolean solve(int index, String temp){
        if(index == n){
            if(k == 1){
                ans = temp;
                return true;
            }
            else{
                k--;
                return false;
            }
        }

        for( char ch : chars){
            char prev = temp.length() == 0 ? 'x' : temp.charAt(temp.length() - 1);

            if(prev != ch){
                if(solve(index + 1, temp + ch))
                    return true;
            }
        }

        return false;
    }
}