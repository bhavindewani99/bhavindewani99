class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder res = new StringBuilder();
        int n = a + b;

        while(res.length() < n){
            if(a > b){
                if(res.length()>=2 && res.charAt(res.length()-1)=='a' && res.charAt(res.length()-2)=='a'){
                    res.append('b');
                    b--;
                }  else{
                    res.append('a');
                    a--;
                }
            }else{
                if(res.length()>=2 && res.charAt(res.length()-1)=='b' && res.charAt(res.length()-2)=='b'){
                    res.append('a');
                    a--;
                }else{
                    res.append('b');
                    b--;
                }
            }
        }
        return res.toString();
    }
}