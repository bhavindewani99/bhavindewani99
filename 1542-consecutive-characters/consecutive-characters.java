class Solution {
    public int maxPower(String s) {
        char prev=s.charAt(0);
        int max=1;
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==prev){
                count++;
            }else{
                count=1;
            }
            prev=s.charAt(i);
            max = Math.max(max, count);
        }
        if(max<count){
            max=count;
        }
        return max;
    }
}