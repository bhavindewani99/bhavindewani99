class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        List<Integer> list = new ArrayList<>();

        for(int number : nums){
            if(list.isEmpty() || list.getLast() < number){
                list.add(number);
            }else{
                if(list.get(0) >= number) list.set(0, number);
                else list.set(1, number);
            }
            if(list.size() == 3) return true;
        }
        return false;
    }
}