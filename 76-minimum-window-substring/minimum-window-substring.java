/*
 Approach - 2 Sliding window + HashMap 

 TC - 0(2N) + 0(M)
    - 0(N+M)
 SC - 0(128)
*/
class Solution {
    public String minWindow(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int count = 0;
        int start = -1;
        int min = Integer.MAX_VALUE;

        int l=0;
        int r=  0;

        for(int i=0; i<m; i++) map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);

        while(r<n){
            if(map.getOrDefault(s.charAt(r), 0)>0) count++;
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)-1);
            while(count==m){
                if(r-l+1< min){
                    min = r-l+1;
                    start = l;
                }

                map.put(s.charAt(l), map.get(s.charAt(l))+1);
                if(map.get(s.charAt(l))>0) count--;

                l++;
            }

            r++;
        }

        if(start==-1) return "";
        return s.substring(start, start+min);
    }
}