class TaskManager {

    PriorityQueue<Pair> pq;
    Map<Integer, Pair> map; // key is taskId

    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a,b) -> a.priority==b.priority ? b.taskId - a.taskId : b.priority-a.priority);

        for(List<Integer> task : tasks){
            Pair pair = new Pair(task.get(0), task.get(1), task.get(2));
            pq.offer(pair);
            map.put(task.get(1), pair);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        rmv(taskId);
        Pair pair = new Pair(userId, taskId, priority);
        map.put(taskId, pair);
        pq.offer(pair);
    }
    
    public void edit(int taskId, int newPriority) {
        Pair pair = map.get(taskId);
        add(pair.userId, taskId, newPriority);
    }
    
    public void rmv(int taskId) {
        if(map.containsKey(taskId)){
            map.get(taskId).expired = true;
        }
    }
    
    public int execTop() {
        while(!pq.isEmpty() && pq.peek().expired==true) pq.poll();
        if(pq.isEmpty()) return -1;
        return pq.poll().userId;
    }

    class Pair{
        int userId, taskId, priority;
        boolean expired = false;
        Pair (int userId, int taskId, int priority){
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */