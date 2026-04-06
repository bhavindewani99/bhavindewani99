class Solution {
    
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        int index = 0;
        int[] arr = new int[map.size()];
        for(int x : map.keySet()) arr[index++] = x;
        Arrays.sort(arr);

        int earn1 = 0, earn2 = 0;

        for(int i=0;i<arr.length;i++){
            int currEarn = arr[i] * map.get(arr[i]);
            
            if(i>0 && arr[i-1] == arr[i] - 1){
                int temp = earn2;
                earn2 = Math.max(currEarn + earn1, earn2);
                earn1 = temp;
            } else {
                earn1 = earn2;
                earn2 += currEarn;
            }
        }
        return earn2;

    }

    
}
