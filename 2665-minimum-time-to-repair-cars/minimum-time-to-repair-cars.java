class Solution {
    public long repairCars(int[] ranks, int cars) {
        // Define the search space for binary search
        long l = 1, r = ranks[0]; 
        
        // Find the maximum rank to determine the upper bound of search space
        for (int rank : ranks)
            r = Math.max(r, rank);
        
        // Maximum possible time if all cars are repaired by the slowest mechanic
        r = r * cars * cars;

        long ans = r; // Store the minimum possible time

        // Binary search to find the minimum time required
        while (l <= r) {
            long mid = l + (r - l) / 2; // Calculate the mid value

            // Check if it's possible to repair all cars within 'mid' minutes
            if (can(mid, ranks, cars)) {
                ans = mid; // Update the answer
                r = mid - 1; // Try for a smaller time
            } else {
                l = mid + 1; // Increase the time limit
            }
        }
        return ans; // Return the minimum time required
    }

    // Helper function to check if we can repair 'cars' within 'mid' minutes
    private boolean can(long mid, int[] ranks, int cars) {
        int count = 0; // Total cars that can be repaired within 'mid' time

        for (int rank : ranks) {
            count += Math.sqrt(mid / rank); // Calculate the number of cars a mechanic can repair
            if (count >= cars) return true; // If we can repair all cars, return true
        }

        return false; // Otherwise, return false
    }
}