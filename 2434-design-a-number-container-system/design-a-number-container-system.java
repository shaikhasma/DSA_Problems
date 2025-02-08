class NumberContainers {
    Map<Integer,Integer> map1 ;
    HashMap<Integer, TreeSet<Integer>> map2;

    public NumberContainers() {
        map1 = new HashMap<>();
        map2 = new HashMap<Integer, TreeSet<Integer>>();
    }
    
    public void change(int index, int number) {
          if(!map1.containsKey(index)){
              map1.put(index, number);
          }
          else{ //replacing old number
              int oldNumber = map1.get(index);
              map1.put(index, number);
 
              map2.get(oldNumber).remove(index);
              if(map2.get(oldNumber).isEmpty()) 
                 map2.remove(oldNumber);
                
          }
                
            if(!map2.containsKey(number)) 
                map2.put(number, new TreeSet<Integer>()); //new entry
    
            map2.get(number).add(index); //new number entry
   
    }
    
    public int find(int number) {
        if(!map2.containsKey(number))
            return -1;
        
        return map2.get(number).first();

    }
    
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */