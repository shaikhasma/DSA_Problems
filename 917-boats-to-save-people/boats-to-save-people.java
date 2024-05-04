/*. Approach - sort

TC - 0(N + logN)
 SC - 0(1)
 [3,2,2,1]
 
 [1 2 2 3]. target = 3

 [3,3,4,5].  5

 boatWeight = 5;
 boatCount 3
 */
         
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int person1 = 0;
        int person2 = people.length - 1;
        int boatCount = 0;
        
        while( person1 <= person2 ){
            int boatWeight =  people[person1] + people[person2];
            if( boatWeight <= limit){
                boatCount++;
                person1++;
                person2--;
            }else{
                boatCount++;
                person2--;
            }
        }

   
        return boatCount;
    }
}