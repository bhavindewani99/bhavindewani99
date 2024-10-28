class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int[] remainders = new int[k];

        for(int num : arr){
            if(num<0){
                int remain = (((num%k)+k)%k);
                remainders[remain]++;
            }else{
                int remain = num % k;
                remainders[remain]++;
            }
        }

        for(int i=0;i<=k/2;i++){
            if(i==0) {
                if(remainders[i]%2!=0) return false;
                continue;
            }
            int complement = k - i;
            if(remainders[i]!=remainders[complement]) return false;
        }
        return true;
    }
}