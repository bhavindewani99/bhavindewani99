class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder result = new StringBuilder();
        int increment = (numRows-1)*2;
        int n = s.length();

        for(int row=0;row<numRows;row++){
            for(int i=row;i<n;i+=increment){
                result.append(s.charAt(i));
                if(row>0 && row<numRows-1){
                    int newIncrement = i + increment - 2 * row;
                    if(newIncrement<n){
                        result.append(s.charAt(newIncrement));
                    }
                }
            }
        }

        return result.toString();
    }
}