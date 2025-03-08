class Solution {
    public long coloredCells(int n) {
        long result = 0;
        long prev = 1;

        for(int i=0;i<n;i++){
            if(i==0) result = result + prev;
            else result = result + prev;
            prev += 2;
        }
        System.out.print(result+ " "+prev + " " + (result - (prev - 2)));
        
        if(n>1){
            result = result + (result - (prev - 2));
        }

        return result;
    }
}