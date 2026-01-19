class AuctionSystem {

    Map<String, Integer> usersbid;
    Map<Integer, PriorityQueue<Pair>> bids;
    public AuctionSystem() {
        usersbid = new HashMap<>();
        bids = new HashMap<>();
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        String key = userId + "*" + itemId;
        usersbid.put(key, bidAmount);
        bids.putIfAbsent(itemId, new PriorityQueue<>((a,b) -> a.amount == b.amount ? b.userId - a.userId : b.amount - a.amount));

        bids.get(itemId).offer(new Pair(userId, bidAmount));
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        String key = userId + "*"  + itemId;
        usersbid.put(key, newAmount);
        bids.get(itemId).offer(new Pair(userId, newAmount));
    }
    
    public void removeBid(int userId, int itemId) {
        String key = userId + "*"  + itemId;
        usersbid.remove(key);
    }
    
    public int getHighestBidder(int itemId) {
        while(bids.containsKey(itemId) && bids.get(itemId).size() > 0){
            int userId = bids.get(itemId).peek().userId;
            int amount = bids.get(itemId).peek().amount;
            String key = userId + "*"  + itemId;

            if(usersbid.getOrDefault(key, 0) == amount) return userId;
            bids.get(itemId).poll();
        }
        return -1;
    }

    class Pair{
        int userId, amount;
        Pair(int userId, int amount){
            this.userId = userId;
            this.amount = amount;
        }
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */