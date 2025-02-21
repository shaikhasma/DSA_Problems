/*
 Add into heap & calcualre median
 TC - 0(logN)
 Space 0(N)
*/
class MedianFinder {
    PriorityQueue<Integer> minHeap ;
    PriorityQueue<Integer> maxHeap ;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());    
    }
    
    public void addNum(int num) {
        //insert into heap either min or max
        if(maxHeap.size() == 0 || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);

        //balancing size of both heap it should be == or -1
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.add(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size() + 1){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
       if(minHeap.size() == maxHeap.size())
         return (maxHeap.peek() + minHeap.peek()) / 2.0;
       
       return maxHeap.size() > minHeap.size() ?  maxHeap.peek() : minHeap.peek();
       
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */