class Solution {
    public double myPow(double x, int n) {
        double ans;
        if(n<0){
            ans=1/cal(x,-n);
        }else{
            ans=cal(x,n);
        }
        return ans;
    }

    private double cal(double x,int n){
         if(n==0){
            return 1;
        }
        return n%2==0 ? cal(x*x,n/2): x*cal(x*x,n/2);
    }
}