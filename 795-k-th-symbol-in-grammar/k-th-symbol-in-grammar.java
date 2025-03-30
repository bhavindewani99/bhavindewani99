class Solution {
    public int kthGrammar(int n, int k) {
        
        int result = 0;
        int left = 1, right = (int) Math.pow(2, n-1);

        for(int i=0;i<n-1;i++){
            int mid = (left + right)/2;
            if(k<=mid){
                right = mid;
            }else{
                left = mid+1;
                result = 1 - result;
            }
        }
        return result;
    }
}

// 0 -> 1 
// 0 1 -> 2
// 0 1 1 0 -> 3
// 0 1 1 0 1 0 0 1 -> 4
// 0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0 -> 5
// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

// n = 5
// k = 3