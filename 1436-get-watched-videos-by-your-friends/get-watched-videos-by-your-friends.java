class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        int n = friends.length;
        Map<String, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(id);
        queue.offer(id);

        while(level>0){
            int len = queue.size();
            for(int i=0;i<len;i++){
                int node = queue.poll();
                for(int adj : friends[node]){
                    if(visited.add(adj)){
                        queue.offer(adj);
                    }
                }
            }
            level--;
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(String curr : watchedVideos.get(node)){
                map.putIfAbsent(curr,0);
                map.put(curr, map.get(curr)+1);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.freq==b.freq ? a.key.compareTo(b.key) : a.freq-b.freq);

        for(String temp : map.keySet()){
            pq.offer(new Pair(map.get(temp), temp));
        }

        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll().key);
        }

        return result;
    }

    class Pair{
        int freq;
        String key;
        Pair(int freq, String key){
            this.freq = freq;
            this.key = key;
        }
    }
}