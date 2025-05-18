class Solution {
    public int colorTheGrid(int m, int n) {
    final int mod = 1_000_000_007;
    int total = (int) Math.pow(3, m);

    List<int[]> patterns = new ArrayList<>();
    List<Integer> validPatternIds = new ArrayList<>();

    // Step 1: generate all valid column patterns (no adjacent same color in a column)
    for (int i = 0; i < total; i++) {
        int[] colors = new int[m];
        int x = i;
        boolean valid = true;

        for (int j = 0; j < m; j++) {
            colors[j] = x % 3;
            if (j > 0 && colors[j] == colors[j - 1]) {
                valid = false;
                break;
            }
            x /= 3;
        }

        if (valid) {
            patterns.add(colors);
            validPatternIds.add(i);
        }
    }

    int size = patterns.size();

    // Step 2: build adjacency list where two patterns can be adjacent (no same color in same row)
    List<Integer>[] adj = new ArrayList[size];
    for (int i = 0; i < size; i++) {
        adj[i] = new ArrayList<>();
        for (int j = 0; j < size; j++) {
            boolean compatible = true;
            int[] a = patterns.get(i);
            int[] b = patterns.get(j);
            for (int k = 0; k < m; k++) {
                if (a[k] == b[k]) {
                    compatible = false;
                    break;
                }
            }
            if (compatible) adj[i].add(j);
        }
    }

    // Step 3: DP table
    int[][] dp = new int[n + 1][size];
    for (int i = 0; i < size; i++) dp[1][i] = 1;

    for (int col = 2; col <= n; col++) {
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int prev : adj[i]) {
                sum = (sum + dp[col - 1][prev]) % mod;
            }
            dp[col][i] = sum;
        }
    }

    int result = 0;
    for (int i = 0; i < size; i++) result = (result + dp[n][i]) % mod;
    return result;
}

}