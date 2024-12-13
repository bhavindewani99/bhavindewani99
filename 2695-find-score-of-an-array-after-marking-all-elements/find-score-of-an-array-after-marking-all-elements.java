class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        PriorityQueue<Pair> pairs = new PriorityQueue<>((a,b) -> a.element==b.element ? a.index - b.index : a.element - b.element);
        Set<Integer> set = new HashSet<>();
        long score = 0;
        
        for(int i=0;i<n;i++){
            pairs.offer(new Pair(i, nums[i]));
        }

        while(!pairs.isEmpty()){
            Pair pair = pairs.poll();
            if(set.contains(pair.index)) continue;
            score += pair.element;
            set.add(pair.index);
            set.add(pair.index-1);
            set.add(pair.index+1);
        }

        return score;

    }

    class Pair{
        int index, element;
        Pair(int index, int element){
            this.index = index;
            this.element = element;
        }
    }
}