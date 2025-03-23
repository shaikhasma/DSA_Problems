/* 
Approach 1 - total sum + hashmap for frequenncy
TC - 0(N)
SC - 0(N)
*/
class Solution {
    public int getLargestOutlier(int[] a) {
        int totSum = 0;
        Map<Integer, Integer> freq = new HashMap<>(a.length);
        for (int no : a) {
            totSum += no;
            freq.put(no, freq.getOrDefault(no, 0) + 1);
        }

        int out = Integer.MIN_VALUE;
        for (int no : a) {
            int remSum = totSum - no;
            if (remSum % 2 != 0) 
                continue;

            freq.put(no, freq.getOrDefault(no, 0) - 1);
            int ele = remSum / 2;

            if (freq.getOrDefault(ele, 0) > 0) 
                out = Math.max(out, no);
            
            freq.put(no, freq.get(no) + 1);
        }

        return out;
    }
}