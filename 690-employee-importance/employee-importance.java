/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        int result = 0;

        for(Employee emp : employees){
            map.put(emp.id, emp);
        }

        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));

        while(!queue.isEmpty()){
            Employee emp = queue.poll();
            result += (emp.importance);

            for(int x : emp.subordinates){
                queue.offer(map.get(x));
            }
        }

        return result;
    }
}