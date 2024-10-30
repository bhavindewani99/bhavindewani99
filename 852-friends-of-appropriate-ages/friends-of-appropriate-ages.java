class Solution {
    public int numFriendRequests(int[] ages) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;

        for(int age : ages) map.put(age, map.getOrDefault(age, 0) +1);

        for(Integer a : map.keySet()){
            for(Integer b : map.keySet()){
                if(requests(a, b)){
                    result += map.get(a) * (map.get(b) - (a==b ? 1 : 0));
                }
            }
        }

        return result;
    }

    private boolean requests(int a, int b){
        return !((b<=(a/2 +7)) ||  b>a || (b>100 && a<100));
    }
}