/*
Approach - Substring method 
    substring(startIndex, endIndex) retrive those character in between startIndex endIndex
TC - 0(N)
SC- 0(1)

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
5 3 0 3 9 1 4 4 0 0 F  9  2   1 1
*/
class Solution {
    public int countSeniors(String[] details) {
        int seniorCitizens = 0;
        for(int index = 0; index < details.length; index++){
            String detail = details[index];
            int age = Integer.parseInt(detail.substring(11,13));
            if(age > 60)
                seniorCitizens++;
        }
        return seniorCitizens;
    }
}