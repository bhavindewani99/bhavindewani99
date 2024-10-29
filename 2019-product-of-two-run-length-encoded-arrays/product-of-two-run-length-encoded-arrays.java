class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> result = new ArrayList<>();
        int n = encoded1.length, m = encoded2.length;
        int i=0,j=0;

        while(i<n && j<m){
            int ival = encoded1[i][0];
            int ifreq = encoded1[i][1];
            int jval = encoded2[j][0];
            int jfreq = encoded2[j][1];

            int newVal = ival * jval;
            int freq = Math.min(ifreq,jfreq);
            if(result.size()>0 && result.get(result.size()-1).get(0)==newVal){
                int newFreq = freq + result.get(result.size()-1).get(1);
                result.get(result.size()-1).set(1, newFreq);
            }else{
                result.add(new ArrayList<>(Arrays.asList(newVal,freq)));
            }
            if(ifreq==jfreq){
                i++;
                j++;
            }else if(ifreq>jfreq){
                encoded1[i][1] -= jfreq;
                j++;
            }else{
                encoded2[j][1] -= ifreq;
                i++;
            }
        }
        return result;
    }
}