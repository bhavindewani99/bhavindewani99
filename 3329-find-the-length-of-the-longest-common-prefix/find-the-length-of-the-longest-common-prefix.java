class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        Set<Integer> set = new HashSet<>();
        int res= 0;

        for(int i=0;i<n;i++){
            int x = arr1[i];
            while(x>0 && set.contains(x)==false){
                set.add(x);
                x /=10;
            }
        }

        for(int i=0;i<m;i++){
            int y = arr2[i];
            while(y>0 && set.contains(y)==false) y/=10;
            if(y!=0) res = Math.max(res, String.valueOf(y).length());
        }
        return res;
    }
}