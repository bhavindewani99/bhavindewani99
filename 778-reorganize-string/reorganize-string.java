class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.count-a.count);
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();

        for(char c: s.toCharArray()){
            if(!map.containsKey(c)) map.put(c, 0);
            map.put(c, map.get(c)+1);
        }

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        while(!pq.isEmpty()){
            Pair curPair = pq.poll();
            if(res.length()>0 && res.charAt(res.length()-1)==curPair.c){
                if(pq.isEmpty())return "";
                Pair nextPair = pq.poll();
                res.append(nextPair.c);
                res.append(curPair.c);
                curPair.count-=1;
                nextPair.count-=1;
                if(curPair.count>0) pq.offer(curPair);
                if(nextPair.count>0) pq.offer(nextPair);
                continue;
            }
            res.append(curPair.c);
            if(curPair.count>1){
                if(pq.isEmpty()) return "";
                Pair nextPair = pq.poll();
                res.append(nextPair.c);
                if(nextPair.count>1) pq.offer(new Pair(nextPair.c, nextPair.count-1));
                curPair.count-=1;
                pq.offer(curPair);
            }
        }
        return res.toString();

    }

    class Pair{
        char c;
        int count;
        Pair(char c, int count){
            this.c=c;
            this.count=count;
        }
    }
}