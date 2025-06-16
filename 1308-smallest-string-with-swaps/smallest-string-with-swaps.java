class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        int n = s.length();
        DisjointSet disjointSet = new DisjointSet(n);
        StringBuilder result = new StringBuilder();

        for(List<Integer> pair : pairs){
            disjointSet.unionBySize(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int parent = disjointSet.findParent(i);
            map.putIfAbsent(parent, new PriorityQueue<>());
            map.get(parent).add(s.charAt(i));
        }

        for(int i=0;i<n;i++){
            int parent = disjointSet.findParent(i);
            result.append(map.get(parent).poll());
        }

        return result.toString();
    }

    


    class DisjointSet{
        int[] parent, size;
        DisjointSet(int n){
            this.parent = new int[n];
            this.size = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i]=1;
            }
        }


        public int findParent(int node){
            if(parent[node] == node) return node;
            return parent[node] = findParent(parent[node]);
        }

        public void unionBySize(int u, int v){
            int uParent = findParent(u);
            int vParent = findParent(v);
            if(uParent == vParent) return;
            else if(size[uParent] >= size[vParent]){
                size[uParent] += size[vParent];
                parent[vParent] = uParent;
            }else{
                size[vParent] += size[uParent];
                parent[uParent] = vParent;
            }
        }
    }
}


