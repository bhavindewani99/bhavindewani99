class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        return getAnswer(nums, k);
        // Map<Integer,Integer> map = new HashMap<>();
        // int n = nums.length;
        // List<Integer>[] bucket = new ArrayList[n+1];

        // for(int i=0;i<n+1;i++) bucket[i] = new ArrayList<>();
        // for(int i:nums) map.put(i,map.getOrDefault(i,0)+1);
        // for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        //     bucket[entry.getValue()].add(entry.getKey());
        // }

        // int[] res = new int[k];
        // int index=0;
        // for(int i=n;i>=0 &&k > 0;i--){
        //     List<Integer> tempList = bucket[i];
        //     for(int currEle : tempList){
        //         res[index++]=currEle;
        //         k--;
        //         if(k==0) break;
        //     }
        // }
        // return res;

    }

    private int[] getAnswer(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int[] res = new int[k];
        for(int i:nums){
            if(map.containsKey(i)==false) map.put(i, 0);
            map.put(i, map.get(i)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(pq.size()<k) pq.add(new int[] {entry.getValue(),entry.getKey()});
            else{
                if(entry.getValue()>pq.peek()[0]){
                    pq.poll();
                    pq.offer(new int[] {entry.getValue(),entry.getKey()});
                }
            }
        }
        int index=0;
        while(!pq.isEmpty()){
            res[index++] = pq.poll()[1];
        }
        return res;
    }
}