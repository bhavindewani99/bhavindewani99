class Solution {
    int result = 0;
    public int maxProduct(String s) {
        recursion(0, s, "", "");
        return result;
    }

    private void recursion(int index, String s, String x, String y){
        if(index == s.length()){
            if(check(x, y)){
                result = Math.max(result, x.length() * y.length());
            }
            return;
        }
        recursion(index + 1, s, x + s.charAt(index), y);
        recursion(index + 1, s, x , y + s.charAt(index));
        recursion(index + 1, s, x , y);
    }

    private boolean check(String x, String y){
        if(x.length() == 0 || y.length()==0) return false;

        for(int i=0;i<x.length()/2;i++){
            if(x.charAt(i) != x.charAt(x.length() - i-1)) return false;
        }

        for(int i=0;i<y.length()/2;i++){
            if(y.charAt(i) != y.charAt(y.length() - i-1)) return false;
        }

        return true;
    }

}