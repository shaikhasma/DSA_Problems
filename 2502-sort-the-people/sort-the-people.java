/*
    ["Mary","John","Emma"]
    [180,165,170]
    TC - 0(logN) + 0(N) + 0(N)
        - N + logN
    SC - 0(1)
*/

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();

        for(int index = 0 ; index < heights.length; index++)
            map.put(heights[index], names[index]);

        Arrays.sort(heights);
        reverseArray(heights);
    

        String[] sortedPeople = new String[names.length];
        int pos = 0;

        for(int index = 0 ; index < heights.length; index++)
          sortedPeople[pos++] = map.get(heights[index]);

        return sortedPeople;
        
    }

     public  void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            // Swap the elements
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            
            // Move the pointers
            left++;
            right--;
        }
    }
}