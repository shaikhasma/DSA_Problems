/*
observations are :
    1. we need to find the gap aray from the given meeting
    Then to find the largest free time we can do two possible adjustment here :
    - move a meeting to separate free time other then the gaps next to left or right.
    - If this is possible we can simply take the sum of the side by gaps and the metting interval as possible ans
    - we can simply club two gaps on left and right by adjusting the meeting to either left or right. 
    So here the possible ans is sum of lefgt right gaps.
    
    The second option is possible always, now the trick is to check if the case 1 is possible or not.
    to figure out this we can think up to find the the largest gap towards left and largest gap towrds right
    Further we can evaluate the largest gap towrds left on run time where as we need to pre compute the largest gap twords right by 
    iterating from the back side.

Approach
---------
1. First find the gap array
2. Find the largest gap from right array by iterating from end
    Then iterate from the start and check for the possible sum of the gaps
*/
class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int[] gap = new int[startTime.length + 1];
        int[] largestRight = new int[startTime.length + 1];
        gap[0] = startTime[0];

        for(int i = 1; i < startTime.length; ++i) 
            gap[i] = startTime[i] -  endTime[i-1];
            
        gap[startTime.length] = eventTime - endTime[endTime.length-1];
        
        for(int index = gap.length - 2; index >= 0; index-- )
             largestRight[index] = Math.max(largestRight[index+1], gap[index+1]);
        
        int ans = 0, largestLeft = 0;
        for(int index = 1; index < gap.length; index++){
            int curGap = endTime[index-1] - startTime[index-1];
            if(largestLeft >= curGap || largestRight[index] >= curGap)
                 ans = Math.max(ans, gap[index-1] + gap[index] +  curGap);

            ans = Math.max(ans, gap[index-1] + gap[index]);
            largestLeft = Math.max(largestLeft, gap[index-1]);
        }
        return ans;
    }
}