class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans=new ArrayList<>();
        backtrack(ans,new StringBuilder(),target,num,0,0,0);
        return ans;
    }

    private static void backtrack(List<String> ans,StringBuilder sb,int target,String num,long curr,long prev,int idx){
        if(idx==num.length()){
            if(target==curr){
                ans.add(sb.toString());
            }
            return;
        }
        for(int i=idx;i<num.length();i++){
            if(i != idx && num.charAt(idx)=='0') return;
            int len = sb.length();
            long n = Long.parseLong(num.substring(idx, i+1));
            if(idx==0){
                backtrack(ans,sb.append(n),target,num,n,n,i+1);
                sb.setLength(len);
            }else{
                backtrack(ans,sb.append("+").append(n),target,num,curr+n,n,i+1);
                sb.setLength(len);
                backtrack(ans,sb.append("-").append(n),target,num,curr-n,-n,i+1);
                sb.setLength(len);
                backtrack(ans,sb.append("*").append(n),target,num,(curr-prev)+(prev*n),prev*n,i+1);
                sb.setLength(len);
            }
        }
    }
}