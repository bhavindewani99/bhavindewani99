class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        int temp=0;
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        for(int i=0;i<s.length();i++){
            int curr = map.get(s.charAt(i));
            if(i==0) temp=curr;
            else if(curr > map.get(s.charAt(i-1))){
                ans += curr - temp;
                temp=0;
            }else{
                ans+=temp;
                temp=curr;
            }
        }
        ans+=temp;
        return ans;
    }
}