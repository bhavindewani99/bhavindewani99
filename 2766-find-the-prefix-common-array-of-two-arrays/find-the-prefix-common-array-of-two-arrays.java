class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        
        int n = A.length;
        int[] C = new int[n];
        HashSet<Integer> aset = new HashSet<>();
        HashSet<Integer> bset = new HashSet<>();

        for(int i=0;i<n;i++){
            int prev = i==0 ? 0 : C[i-1];
            if(A[i]==B[i]) prev++;
            if(bset.contains(A[i])) prev++;
            if(aset.contains(B[i])) prev++;
            aset.add(A[i]);
            bset.add(B[i]);
            C[i] = prev;
        }
        return C;
    }
}