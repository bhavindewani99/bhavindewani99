class Solution {
    int result = 0;
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = students.length;
        boolean[] visited = new boolean[n];
        recursion(0, students, mentors, 0, n, visited);

        return result;
    }

    private void recursion(int index, int[][] students, int[][] mentors, int curr, int n, boolean[] visited){
        if(index == n){
            result = Math.max(result, curr);
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i]=true;
                int compatibleScore = calculate(students[index], mentors[i]);
                recursion(index+1, students, mentors, curr+compatibleScore, n, visited);
                visited[i] = false;
            }
        }
    }

    private int calculate(int[] student, int[] mentor){
        int score =0;
        for(int i=0;i<student.length;i++){
            if(student[i] == mentor[i]) score++;
        }
        return score;
    }
}