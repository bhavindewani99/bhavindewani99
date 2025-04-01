class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recursion(s, new StringBuilder(), 0, 0, res);
        return res;
    }

    private void recursion(String s, StringBuilder curr, int index, int used, List<String> res){
        if(index==s.length()){
            if(used==4) res.add(curr.toString());
            return;
        }

        for(int i=index;i<s.length();i++){
            if(s.charAt(index)=='0' && i!=index) break;
            int val = Integer.valueOf(s.substring(index,i+1));
            if(val<=255){
                int len = curr.length();
                curr.append(val);
                if(used<3)
                curr.append(".");
                recursion(s, curr, i+1, used+1, res);
                curr.setLength(len);
            }else{
                break;
            }
        }
    }
}