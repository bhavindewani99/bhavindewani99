class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
       int[] res = new int[n];
       Stack<Integer> ids = new Stack<>();
       int prev_time = 0;

       for(int i=0;i<logs.size();i++){
        String[] log = logs.get(i).split(":");
        int id = Integer.valueOf(log[0]);
        int time = Integer.valueOf(log[2]);
        if(log[1].equals("start")){
            if(ids.size()>0){
                res[ids.peek()] += time - prev_time;
            }
            prev_time = time;
            ids.push(id);
        }else{
            int last_id = ids.pop();
            res[last_id] += time - prev_time +1;
            prev_time = time +1;
        }
       } 
       return res;
    }
}