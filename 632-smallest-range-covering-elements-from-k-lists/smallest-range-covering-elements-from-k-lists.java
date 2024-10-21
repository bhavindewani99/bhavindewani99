class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.value-b.value);
        int mini = nums.get(0).get(0);
        int maxi = nums.get(0).get(0);

        for(int i=0;i<k;i++){
            List<Integer> curr = nums.get(i);
            mini = Math.min(mini, curr.get(0));
            maxi = Math.max(maxi, curr.get(0));
            pq.offer(new Pair(curr.get(0), i, 0));
        }

        int[] res = {mini,maxi};
        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int value = pair.value;
            int listNo = pair.listNo;
            int index = pair.index;
            index+=1;
            if(index >= nums.get(listNo).size()){
                return res;
            }
            int newValue = nums.get(listNo).get(index);
            pq.offer(new Pair(newValue, listNo, index));
            mini = pq.peek().value;
            maxi = Math.max(maxi, newValue);
            if(maxi-mini < res[1]-res[0]){
                res[1] = maxi;
                res[0] = mini;
            }
        }
        return res;


    }

    class Pair{
        int value, listNo, index;
        Pair(int value, int listNo, int index){
            this.value = value;
            this.listNo = listNo;
            this.index = index;
        }
    }
}