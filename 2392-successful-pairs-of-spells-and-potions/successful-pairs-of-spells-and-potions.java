class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] pairs = new int[spells.length];
        int i=0;

        for(int spell : spells){
            int index = binarySearch(spell, potions, success);
            if(index!=-1) 
            pairs[i] = (potions.length - index);
            i++;
        }
        return pairs;
    }

    private int binarySearch(int spell, int[] potions, long success){
        int low = 0;
        int high = potions.length-1;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            long multi = (long)spell * potions[mid];
            if(multi>=success){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}