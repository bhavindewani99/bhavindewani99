class Solution {
    long sum=0;
    TreeSet<Pair> large = new TreeSet<>();
    TreeSet<Pair> small = new TreeSet<>();
    Map<Integer,Integer> map = new HashMap<>();

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        for(int i=0;i<n;i++){
            small.add(new Pair(nums[i], 0));
        }

        for(int i=0;i<n;i++){
            update(nums[i],1);
            if(i>=k){
                update(nums[i-k], -1);
            }
            if(i>=k-1){
                equilibrium(x);
                res[i-k+1] = (int) sum;
            }
        }
        return res;
        
    }

    private void equilibrium(int x){
        while(large.size()<x && !small.isEmpty()){
            Pair second = small.last();
            large.add(second);
            small.remove(second);
            sum += 1l * second.val * second.freq;
        }

        if(small.isEmpty()) return;

        while(true){
            Pair first = large.first();
            Pair second = small.last();

            if(second.freq > first.freq || (first.freq==second.freq && second.val > first.val)){
                large.remove(first);
                small.remove(second);
                large.add(second);
                small.add(first);
                sum -= 1l *  first.freq * first.val;
                sum += 1l * second.freq * second.val;
            }else{
                break;
            }
        }
    }

    public void update(int value, int f){
        int currFreq = map.getOrDefault(value, 0);
        if(large.contains(new Pair(value, currFreq))){
            large.remove(new Pair(value, currFreq));
            sum -= 1l * currFreq * value;
            map.put(value, currFreq + f);
            sum += 1l * map.get(value) * value;
            large.add(new Pair(value, map.get(value)));
        }else if(small.contains(new Pair(value, currFreq))){
            small.remove(new Pair(value, currFreq));
            map.put(value, currFreq + f);
            small.add(new Pair(value, map.get(value)));
        }
    }

    class Pair implements Comparable<Pair>{
        int val, freq;
        Pair(int v, int f){
            this.val = v;
            this.freq = f;
        }

        public int compareTo(Pair p){
            if(this.freq==p.freq){
                return this.val - p.val;
            }else{
                return this.freq - p.freq;
            }
        }
    }
}