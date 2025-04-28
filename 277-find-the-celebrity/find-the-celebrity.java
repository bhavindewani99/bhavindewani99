/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        
        // We will find out the celebrity by ruling out method
        // if a knows b meaning a cannot be celebrity for sure as it knows someone, so our next candidat will be b
        // If a does not knows b meaning b cannot be celebrity as everyone has to know clebrity so our candidate will still be a then at the end we will check our candidate is celebrity or not

        int celebCandidate = 0;

        for(int i=0;i<n;i++){
            if(knows(celebCandidate, i)){
                celebCandidate = i;
            }
        }

        for(int i=0;i<n;i++){
            if(i!=celebCandidate && (knows(i,celebCandidate)==false || knows(celebCandidate, i) == true)) return -1;
        }

        return celebCandidate;
    }
}