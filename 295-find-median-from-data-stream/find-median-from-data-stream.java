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
        if(maxHeap.size()== 0 || num < maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
        
        //balancing the heap
        if(minHeap.size() > maxHeap.size()+1){
            maxHeap.add(minHeap.poll());
        }else if(maxHeap.size() > minHeap.size() +1){
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
      if(maxHeap.size() == minHeap.size()){
        return (maxHeap.peek() + minHeap.peek())/2.0;
      }
      return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */