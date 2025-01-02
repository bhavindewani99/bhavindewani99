class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.freq == b.freq ? b.word.compareTo(a.word) : a.freq-b.freq);

        Map<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) +1);

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
            if(pq.size()>k) pq.poll();
        }

        List<String> result = new ArrayList<>();
        
        while(!pq.isEmpty()) result.add(pq.poll().word);

        Collections.reverse(result);

        // List<String> finalAns = new ArrayList<>();
        // for(Pair pair : result) finalAns.add(pair.word);

        return result;

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