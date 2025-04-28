/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        int[] indegree = new int[n], outdegree = new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(super.knows(j,i)){
                        outdegree[j]++;
                        indegree[i]++;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            if(outdegree[i]==0 && indegree[i]==n-1) return i;
        }

        return -1;


    }
}