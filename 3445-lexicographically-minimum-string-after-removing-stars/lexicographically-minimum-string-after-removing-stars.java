class Solution {
    public String clearStars(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.c == b.c ? b.index-a.index : a.c-b.c); 
        Set<Integer> removedIndexes = new HashSet<>();
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<s.length();i++) {
            char currChar = s.charAt(i);
            if(currChar == '*'){
                removedIndexes.add(i);
                removedIndexes.add(pq.poll().index);
            }else{
                pq.offer(new Pair(currChar, i));
            }
        }

        for(int i=0;i<s.length();i++) {
            if(removedIndexes.contains(i) == false){
                result.append(s.charAt(i));
            }
        }

        return result.toString();

    }

    class Pair{
        char c;
        int index;
        Pair(char c, int index){
            this.c = c;
            this.index = index;
        }
    }
}