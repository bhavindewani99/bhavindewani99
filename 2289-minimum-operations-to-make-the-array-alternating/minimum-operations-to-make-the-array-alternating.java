class Solution {
    public int minimumOperations(int[] nums) {
        
        int n = nums.length;
        if(n==1) return 0;
        Map<Integer, Integer> even = new HashMap<>();
        Map<Integer, Integer> odd = new HashMap<>();
        PriorityQueue<Pair> pq1 = new PriorityQueue<>((a,b) -> a.frequency - b.frequency);
        PriorityQueue<Pair> pq2 = new PriorityQueue<>((a,b) -> a.frequency - b.frequency);
        int length1 = n%2==0 ? n/2 : n/2 + 1;
        int length2 = n/2;


        for(int i=0;i<n;i++){
            if(i%2==0) even.put(nums[i], even.getOrDefault(nums[i], 0) + 1);
            else odd.put(nums[i], odd.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : even.entrySet()){
            if(pq1.size() < 2) pq1.offer(new Pair(entry.getKey(), entry.getValue()));
            else if(pq1.peek().frequency < entry.getValue()){
                pq1.poll();
                pq1.offer(new Pair(entry.getKey(), entry.getValue()));
            }
        }

        for(Map.Entry<Integer, Integer> entry : odd.entrySet()){
            if(pq2.size() < 2) pq2.offer(new Pair(entry.getKey(), entry.getValue()));
            else if(pq2.peek().frequency < entry.getValue()){
                pq2.poll();
                pq2.offer(new Pair(entry.getKey(), entry.getValue()));
            }
        }

        List<Pair> list1 = new ArrayList<>();
        List<Pair> list2 = new ArrayList<>();

        while (pq1.isEmpty()==false) list1.add(pq1.poll());
        while (pq2.isEmpty()==false) list2.add(pq2.poll());

        Collections.reverse(list1);
        Collections.reverse(list2);

        if(list1.get(0).element != list2.get(0).element){
            return length1 - list1.get(0).frequency + length2 - list2.get(0).frequency;
        }else if(list1.size()==1 && list2.size()==1){
            return n - Math.max(list1.get(0).frequency, list2.get(0).frequency);
        }else if(list1.size() == 1){
            return n - list1.get(0).frequency - list2.get(1).frequency;
        }else if(list2.size() == 1){
            return n - list2.get(0).frequency - list1.get(1).frequency;
        }
        return n - Math.max(list1.get(0).frequency + list2.get(1).frequency, list1.get(1).frequency + list2.get(0).frequency);

    }

    class Pair{
        int element, frequency;
        Pair(int element, int frequency){
            this.element = element;
            this.frequency = frequency;
        }
    }
}