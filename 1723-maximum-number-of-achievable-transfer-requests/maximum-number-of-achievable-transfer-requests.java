class Solution {
    int result = Integer.MIN_VALUE;
    public int maximumRequests(int n, int[][] requests) {
        recursion(0, n, requests, 0, new int[n]);
        return result;
    }

    private void recursion(int index, int n, int[][] requests, int count, int[] employees){
        if(index == requests.length){
            for(int emp : employees) {
                if(emp != 0) return;
            }
            result = Math.max(result, count);
            return;
        }
        // skip the req
        recursion(index+1, n, requests, count, employees);

        // take the req
        int from = requests[index][0], to = requests[index][1];
        employees[from]--;
        employees[to]++;
        recursion(index+1, n, requests, count+1, employees);
        employees[from]++;
        employees[to]--;
    }
}