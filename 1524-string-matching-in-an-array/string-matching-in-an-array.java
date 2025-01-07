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
*/

class Solution {
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
}