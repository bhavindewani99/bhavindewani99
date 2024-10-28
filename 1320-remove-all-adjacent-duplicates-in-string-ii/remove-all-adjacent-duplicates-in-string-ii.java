class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(char c: s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().c==c){
                stack.peek().count++;
                if(stack.peek().count==k) stack.pop();
            }else{
                stack.add(new Pair(c,1));
            }
        }
        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            for(int i=0;i<pair.count;i++) res.append(pair.c);
        }
        return res.reverse().toString();
    }

    class Pair{
        char c; int count;
        Pair(char c, int count){
            this.c=c;
            this.count=count;
        }
    }
}