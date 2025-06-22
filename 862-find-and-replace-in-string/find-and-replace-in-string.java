class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int k = indices.length;
        List<Pair> pairs = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        int pairsIndex = 0;

        for(int i=0;i<k;i++){
            Pair pair = new Pair(indices[i], sources[i], targets[i]);
            pairs.add(pair);
        }

        Collections.sort(pairs, (a,b) -> a.index - b.index);

        for(int i=0;i<s.length() ;i++){
            
            int currIndex = i;
            boolean added = false;
            while(pairsIndex < pairs.size() && currIndex == pairs.get(pairsIndex).index){
                Pair pair = pairs.get(pairsIndex++);
                int minLength = Math.min(s.length(), currIndex + pair.source.length());
                String currString = s.substring(currIndex, minLength);

                if(pair.source.equals(currString)){
                    result.append(pair.target);
                    currIndex += currString.length() - 1; 
                    added = true;
                    i = currIndex;
                    // System.out.println(" no currIndex is " + currIndex);
                    break;
                }  
            }   
            if(!added) result.append(s.charAt(i));
        }

        return result.toString();
    }

    class Pair{
        int index;
        String source, target;
        Pair(int index, String source, String target){
            this.index = index;
            this.source = source;
            this.target = target;
        }
    }
}