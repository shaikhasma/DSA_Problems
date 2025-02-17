class Solution {
    int ans = 0;

    public int numTilePossibilities(String tiles) {
        int[] hash = new int[26];
        for(int index = 0; index < tiles.length(); index++){
            hash[tiles.charAt(index) - 'A']++;
         }

        solve(hash);
        return ans;
    }

    void solve(int[] hash){

        for(int i = 0 ; i < hash.length; i++){
            if(hash[i] == 0)
                continue;

            ans++;
            hash[i]--;
            solve(hash);
            hash[i]++;
        }
    }
}

