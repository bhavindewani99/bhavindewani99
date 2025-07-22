class Solution {
    public int[] maxDepthAfterSplit(String seq) {

        Stack<Integer> stack = new Stack<>();
        int n = seq.length();
        int[] result = new int[n];

        for(int i=0;i<n;i++){
            if(seq.charAt(i)=='('){
                if(stack.isEmpty()==false && stack.peek()==0){
                    result[i] = 1;
                    stack.add(1);
                }else{
                    result[i] = 0;
                    stack.add(0);
                }
            }else{
                result[i] = stack.pop();
            }
        }

        return result;
    }
}