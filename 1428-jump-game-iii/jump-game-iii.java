class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return recursion(start, arr, visited);
    }

    private boolean recursion(int index,int[] arr, boolean[] visited){
        if(index<0 || index>=arr.length || visited[index]) return false;
        if(arr[index]==0) return true;

        visited[index] = true;

        int jump = arr[index];
        boolean plus = recursion(index + jump, arr, visited);
        boolean minus = recursion(index - jump, arr, visited);

        return plus || minus;
    }
}