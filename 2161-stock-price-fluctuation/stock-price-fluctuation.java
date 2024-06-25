class StockPrice {
    HashMap<Integer, Integer> records;
    TreeMap<Integer, Integer> prices;
    int latestTimestamp = 0;

    public StockPrice() {
        records = new HashMap<>();
        prices = new TreeMap<>();
    }
    
    public void update(int timestamp, int latestPrice) {
        latestTimestamp = Math.max(latestTimestamp, timestamp);

        if(records.containsKey(timestamp)){
            int prevPrice = records.get(timestamp);
        
            if(prices.get(prevPrice) == 1)
                prices.remove(prevPrice);
            else
                prices.put(prevPrice, prices.get(prevPrice) - 1);

        }
        records.put(timestamp, latestPrice);
        prices.put(latestPrice, prices.getOrDefault(latestPrice, 0) + 1);
    }
    
    public int current() {
        return records.get(latestTimestamp);
    }
    
    public int maximum() {
        return prices.lastKey();//max-value
    }
    
    public int minimum() {
        return prices.firstKey(); //min- val
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */