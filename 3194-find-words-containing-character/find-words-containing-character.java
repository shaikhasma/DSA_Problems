class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        for(int index = 0; index < words.length; index++){
            if(words[index].contains(x+""))
               list.add(index);
        }

        return list;
    }
}