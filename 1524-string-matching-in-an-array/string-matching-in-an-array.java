/*
 Approach - string join method
  public List<String> stringMatching(String[] words) {
     String str = String.join(" ", words);
        List<String> res = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            if(str.indexOf(words[i]) != str.lastIndexOf(words[i])){
                res.add(words[i]);
            }
        }
      return res;
  }
  -------------------------------------------------------------------------------
  Approach 2 - Using String builder
   
   public List<String> stringMatching(String[] words) {
     
        StringBuilder a = new StringBuilder();
        for (String word : words) {
            a.append(word).append(" ");
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (a.indexOf(word) != a.lastIndexOf(word)) {
                result.add(word);
            }
        }
        return result;
    }


    Approach 3 - Using  HashMap
   
  public List<String> stringMatching(String[] words) {
     
        Set<String> st = new HashSet<>();
        List<String> ans = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (words[i].contains(words[j]))
                        st.add(words[j]);
                }
            }
        }

        for (String str : st)
            ans.add(str);
        return ans;
    }
*/

class Solution {
    public List<String> stringMatching(String[] words) {
     
        Set<String> st = new HashSet<>();
        List<String> ans = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (words[i].contains(words[j]))
                        st.add(words[j]);
                }
            }
        }

        for (String str : st)
            ans.add(str);
        return ans;
    }
}