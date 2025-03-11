import java.util.HashMap;

class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() == 3) { // If window contains 'a', 'b', 'c'
                ans += (s.length() - right);

                // Shrink the window from the left
                char leftCh = s.charAt(left);
                map.put(leftCh, map.get(leftCh) - 1);

                // Remove entry if count becomes 0
                if (map.get(leftCh) == 0) {
                    map.remove(leftCh);
                }

                left++; // Move left pointer
            }
        }
        return ans;
    }
}
