class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.freq == b.freq ? b.word.compareTo(a.word) : a.freq-b.freq);

        Map<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) +1);

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(pq.isEmpty() || pq.size()<k) pq.offer(new Pair(entry.getKey(), entry.getValue()));
            else if(entry.getValue() > pq.peek().freq){
                pq.poll();
                pq.offer(new Pair(entry.getKey(), entry.getValue()));
            }else if(entry.getValue() == pq.peek().freq && entry.getKey().compareTo(pq.peek().word) < 0){
                pq.poll();
                pq.offer(new Pair(entry.getKey(), entry.getValue()));
            }
        }

        List<Pair> result = new ArrayList<>();
        
        while(!pq.isEmpty()) result.add(pq.poll());

        Collections.sort(result, (a,b) -> a.freq==b.freq ? a.word.compareTo(b.word) : b.freq - a.freq);

        List<String> finalAns = new ArrayList<>();
        for(Pair pair : result) finalAns.add(pair.word);

        return finalAns;

    }

    class Pair{
        String word;
        int freq;
        Pair(String word, int freq){
            this.word = word;
            this.freq = freq;
        }
    }
}