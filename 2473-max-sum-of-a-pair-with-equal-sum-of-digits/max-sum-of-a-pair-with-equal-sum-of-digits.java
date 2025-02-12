/*
Approach - 1 check all possible number's sum and compare
TC- 0(n^2) + 10^9
SC - 0(1)
public int maximumSum(int[] nums) {
        int maxSum = -1;

        for(int index = 0; index < nums.length; index++){
            int sum1 = sumDigits(nums[index]);
            for(int idx = index + 1; idx < nums.length; idx++){
                int sum2 = sumDigits(nums[idx]);
                if(sum1 == sum2)
                    maxSum = Math.max(maxSum, nums[index] + nums[idx]);
            }
        }

        return maxSum;
    }
    int sumDigits(int n){
        int sum = 0;
        while(n != 0){
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
------------------------------------------------------
Approach - 2 Hashing + priority Queue

[18,43,36,13,90]
 9  [36,90]. = 126
 7  [43, 7]
 4  [13]

TC - 0(N) + N log K k is 2
SC - 0(N)


*/
class Solution {
    public int maximumSum(int[] nums) {
            Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int sum = sumDigits(num);
            map.putIfAbsent(sum, new PriorityQueue<>(Collections.reverseOrder()));
            map.get(sum).offer(num);
        }

        long maxSum = -1;
        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() < 2) continue;
            long sum = pq.poll() + pq.poll();
            maxSum = Math.max(maxSum, sum);
        }
        return (int) maxSum;
    }
    int sumDigits(int n){
        int sum = 0;
        while(n != 0){
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }
}