/*
 Intuition
    The problem requires us to maximize the longest continuous free time by rescheduling at most k meetings.
    Since we are modifying at most k meetings, we are allowed to merge at most k + 1 free gaps into a single continuous period.

Approach
    If we can shift up to k meetings, then we can combine up to k + 1 gaps.

    This means we are looking for the largest contiguous segment of k + 1 gaps.

    To efficiently find the maximum sum of any contiguous segment of k + 1 gaps, we can use prefix sum or a sliding window.

Complexity
-----------
Time Complexity: O(n)

Space Complexity: O(n)
*/
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] gaps = new int[n + 1];

        // Calculate the first and last gap separately
        gaps[0] = startTime[0];  // Free time before the first meeting
        gaps[n] = eventTime - endTime[n - 1];  // Free time after the last meeting

        // Compute gaps between meetings
        for (int i = 1; i < n; i++) {
            gaps[i] = startTime[i] - endTime[i - 1];
        }

        // Compute prefix sum for efficient range sum calculation
        int[] pref = new int[n + 2];
        for (int i = 1; i <= n + 1; i++) {
            pref[i] = pref[i - 1] + gaps[i - 1];
        }

        // Sliding window to find the maximum sum of k+1 consecutive gaps
        int ans = 0;
        for (int i = k + 1; i <= n + 1; i++) {
            ans = Math.max(ans, pref[i] - pref[i - (k + 1)]);
        }

        return ans;
    }
}