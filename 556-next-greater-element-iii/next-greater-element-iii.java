class Solution {
    public int nextGreaterElement(int n) {
        StringBuilder s = new StringBuilder(String.valueOf(n));
        int point1 =-1, point2=-1;

        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i)<s.charAt(i+1)){
                point1 = i;
                break;
            }
        }

        if(point1==-1) return point1;

        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)>s.charAt(point1)){
                point2 = i;
                break;
            }
        }

        char c = s.charAt(point1);
        s.setCharAt(point1, s.charAt(point2));
        s.setCharAt(point2, c);

        int l = point1+1;
        int r  = s.length()-1;

        while(l<r){
            char m = s.charAt(l);
            s.setCharAt(l, s.charAt(r));
            s.setCharAt(r, m);
            l++;
            r--;
        }

        long result = 0;
        for(char z : s.toString().toCharArray()){
            result = result*10 + (int)(z-'0');
            if(result>Integer.MAX_VALUE) return -1;
        }

        return (int) result;
    }
}