class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.rank - a.rank);
        int n = score.length;
        String[] result = new String[n];
        int currRank= 0;
        for(int i=0;i<n;i++) pq.offer(new Pair(score[i], i));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            if(currRank<=2){
                if(currRank==0) result[pair.index] = "Gold Medal";
                else if(currRank==1) result[pair.index] = "Silver Medal";
                else result[pair.index] = "Bronze Medal";
            }
            else{
                result[pair.index] = String.valueOf(currRank+1);
            }
            currRank++;
        }

        return result;
    }

    class Pair{
        int rank, index;
        Pair(int rank, int index){
            this.rank = rank;
            this.index = index;
        }
    }
}