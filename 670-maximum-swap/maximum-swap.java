class Solution {
    public int maximumSwap(int num) {

        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        String s = String.valueOf(num);

        for(int i=0;i<s.length();i++){
            int x = s.charAt(i) - '0';
            pq.offer(x);
            map.put(x, i);
        }

        for(int i=0;i<s.length();i++){
            int x = s.charAt(i) - '0';
            int element = pq.poll();
            if(x!=element){
                StringBuilder res = new StringBuilder(s);
                char temp = s.charAt(i);
                int maxElemetIndex = map.get(element);
                res.setCharAt(i, (char) (element +'0'));
                res.setCharAt(maxElemetIndex, (char) (x + '0'));
                return Integer.valueOf(res.toString());
            }
        }
        return num;
    }
}