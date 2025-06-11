class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        List<Integer> list = new ArrayList<>();

        for(int number : nums){
            if(list.isEmpty() || list.getLast() < number){
                list.add(number);
            }else{
                for(int k = 0;k<list.size();k++){
                    if(list.get(k) >= number){
                        list.set(k, number);
                        break;
                    }
                }
            }
            if(list.size() == 3) return true;
        }
        return false;
    }
}