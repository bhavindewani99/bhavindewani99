class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> y.freq-x.freq);
        if(a>0) pq.offer(new Pair('a',a));
        if(b>0) pq.offer(new Pair('b',b));
        if(c>0) pq.offer(new Pair('c',c));
        StringBuilder res = new StringBuilder();

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            if(res.length() > 1 && res.charAt(res.length() - 1) == pair.c && res.charAt(res.length() - 2) == pair.c){
                if(pq.isEmpty()) return res.toString();
                Pair nextPair = pq.poll();
                res.append(nextPair.c);
                if(nextPair.freq>1) pq.offer(new Pair(nextPair.c,nextPair.freq-1));
                pq.offer(new Pair(pair.c,pair.freq));
            }else{
                res.append(pair.c);
                if(pair.freq>1) pq.offer(new Pair(pair.c,pair.freq-1));
            }
        }
        return res.toString();

    }

    class Pair{
        char c;
        int freq;
        Pair(char c, int freq){
            this.c =c;
            this.freq=freq;
        }
    }
}