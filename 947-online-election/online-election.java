class TopVotedCandidate {
    
    Map<Integer, Integer> map = new HashMap<>();
    int currMax = -1;
    int currLeadingPerson = -1;
    int[] leadingAtTime;
    int n;
    int[] currtime;
    public TopVotedCandidate(int[] persons, int[] times) {
        
        n = persons.length;
        leadingAtTime = new int[n];
        currtime = new int[n];

        for(int i=0;i<n;i++){
            map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
            if(map.get(persons[i]) >= currMax){
                currMax = map.get(persons[i]);
                currLeadingPerson = persons[i];
            }
            leadingAtTime[i] = currLeadingPerson;
            currtime[i] = times[i];
        }
    }
    
    public int q(int t) {
        int result = -1;
        int low = 0, high = n-1;

        while(low <= high){
            int mid = (low + high)/2;
            if(currtime[mid] <= t){
                result = leadingAtTime[mid];
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return result;
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */