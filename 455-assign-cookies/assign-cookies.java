class Solution {
    public int findContentChildren(int[] student, int[] cookies) {
        Arrays.sort(student);
        Arrays.sort(cookies);
        int s = 0; 
        int c = 0;
        //int count=0;
        while(s < student.length && c < cookies.length){
            if(student [s ]<= cookies[c]){
          //       count++;
                s++;   
            }
            c++;
            
        }
        return s;
    }   
}