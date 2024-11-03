

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> map = new HashMap<>();
        int n = username.length;
        
        for(int i=0;i<n;i++){
            if(!map.containsKey(username[i])) map.put(username[i], new ArrayList<>());
            map.get(username[i]).add(new Visit(website[i], timestamp[i]));
        }
        sort(map);
        Map<String, Set<String>> sequences = generateSequences(map);
        return pickMaxSeqList(sequences);

    }

    private List<String> pickMaxSeqList(Map<String, Set<String>> sequences){
        List<String> result = new ArrayList<>();
        int maxi=0;
        String maxSeqString = "";
        
        for(String currSequeString : sequences.keySet()){
            if(sequences.get(currSequeString).size()>maxi){
                maxi = sequences.get(currSequeString).size();
                maxSeqString = currSequeString;
            }else if(sequences.get(currSequeString).size()==maxi && currSequeString.compareTo(maxSeqString)<0){
                maxSeqString = currSequeString;
            }
        }
        String[] aStrings = maxSeqString.split(" ");
        for(String aString : aStrings) result.add(aString);
        return result;
    }

    private Map<String, Set<String>> generateSequences(Map<String, List<Visit>> map){
        Map<String, Set<String>> sequences = new HashMap<>();
        
        for(String user : map.keySet()){
            List<Visit> visits = map.get(user);
            for(int i=0;i<visits.size()-2;i++){
                for(int j=i+1;j<visits.size()-1;j++){
                    for(int k=j+1;k<visits.size();k++){
                        String currSeqString = visits.get(i).site + " " + visits.get(j).site + " " + visits.get(k).site;
                        if(!sequences.containsKey(currSeqString)){
                            sequences.put(currSeqString, new HashSet<>());
                        }
                        sequences.get(currSeqString).add(user);
                    }
                }
            }
        }

        return sequences;
    }

    private void sort(Map<String, List<Visit>> map){
        for(String user : map.keySet()){
            Collections.sort(map.get(user));
        }
    }

    class Visit implements Comparable<Visit>{
        String site;
        int time;
        Visit(String site, int time){
            this.site = site;
            this.time = time;
        }
        public int compareTo(Visit v){
            if(v.time==this.time) return 0;
            return this.time - v.time;
        }
    }
}