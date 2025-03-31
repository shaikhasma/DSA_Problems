/*
Approach - Brute-Force Approach
- Try all possible ways to partition the array into k contiguous subarrays.
- Calculate the cost of each partition.
- Track the minimum and maximum scores and return their difference.
TC - 0(2^n)element can start a new subarray or be part of an existing one.
SC -  0(N) stack , partition storage

class Solution {
     int minScore = Integer.MAX_VALUE;
    int maxScore = Integer.MIN_VALUE;

    public int putMarbles(int[] weights, int k) {
        // Try all possible ways to split into k contiguous subarrays
        findPartitions(weights, k, 0, new ArrayList<>());

        // Return the difference between the max and min scores
        return maxScore - minScore;
    }

    private void findPartitions(int[] weights, int k, int index, List<List<Integer>> currentBags) {
        // Base case: If we have exactly k bags and reached the end
        if (k == 1) {
            List<Integer> lastBag = new ArrayList<>();
            for (int i = index; i < weights.length; i++) {
                lastBag.add(weights[i]);
            }
            currentBags.add(lastBag);

            int score = calculateScore(currentBags);
            minScore = Math.min(minScore, score);
            maxScore = Math.max(maxScore, score);

            currentBags.remove(currentBags.size() - 1);
            return;
        }

        // Try different ways to split the array
        for (int end = index; end <= weights.length - k; end++) {
            List<Integer> newBag = new ArrayList<>();
            for (int i = index; i <= end; i++) {
                newBag.add(weights[i]);
            }
            currentBags.add(newBag);

            // Recur for the remaining elements
            findPartitions(weights, k - 1, end + 1, currentBags);

            // Backtrack
            currentBags.remove(currentBags.size() - 1);
        }
    }

    private int calculateScore(List<List<Integer>> bags) {
        int score = 0;
        for (List<Integer> bag : bags) {
            score += bag.get(0) + bag.get(bag.size() - 1);
        }
        return score;
    }
}

Approach 2 - 
- Instead of generating all partitions, we can use pairwise adjacent sums to find the min and max scores efficiently.

Observations
- The cost of each bag is → weights[i] + weights[j], where i is the first index and j is the last index of the bag.
- Since marbles must be in contiguous subarrays, splitting happens between elements.
- We define pairSums[i] = weights[i] + weights[i+1] for 0 ≤ i < n-1, representing the sum between adjacent elements.
Sorting pairSums helps us:
- Get the minimum score by taking the smallest k-1 pairs.
- Get the maximum score by taking the largest k-1 pairs.

TC - 0(N log N)
SC - 0(N)

class Solution {

    public long putMarbles(int[] weights, int k) {
        // We collect and sort the value of all n - 1 pairs.
        int n = weights.length;
        int[] pairWeights = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }
        // We will sort only the first (n - 1) elements of the array.
        Arrays.sort(pairWeights, 0, n - 1);

        // Get the difference between the largest k - 1 values and the
        // smallest k - 1 values.
        long answer = 0l;
        for (int i = 0; i < k - 1; ++i) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }

        return answer;
    }
}
*/
class Solution {

    public long putMarbles(int[] weights, int k) {
        // We collect and sort the value of all n - 1 pairs.
        int n = weights.length;
        int[] pairWeights = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }
        // We will sort only the first (n - 1) elements of the array.
        Arrays.sort(pairWeights, 0, n - 1);

        // Get the difference between the largest k - 1 values and the
        // smallest k - 1 values.
        long answer = 0l;
        for (int i = 0; i < k - 1; ++i) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }

        return answer;
    }
}