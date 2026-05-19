class Solution {
    int ans = 0;
    public int maxLength(List<String> arr) {
    
        boolean[] used = new boolean[26];
        List<String> s = new ArrayList<>();

        for(String curr : arr){
            if(ifValid(curr, new boolean[26], true)) s.add(curr);
        }

        recursion(new StringBuilder(), 0, used, s);
        return ans;
    }

    private void recursion(StringBuilder curr, int index, boolean[] used, List<String> s){
        ans = Math.max(ans, curr.length());

        for(int i=index;i<s.size();i++){
            if(ifValid(s.get(i), used, false)){
                int len = curr.length();
                curr.append(s.get(i));
                perform(s.get(i), used, true);
                recursion(curr, i+1, used, s);
                perform(s.get(i), used, false);
                curr.setLength(len);
            }
        }
    }

    private boolean ifValid(String s, boolean[] used, boolean initial){
        for(char c : s.toCharArray()){
            if(used[c-'a']) return false;
            if(initial) used[c-'a'] = true;
        }
        return true;
    }

    private void perform(String s, boolean[] used, boolean operation){
        for(char c : s.toCharArray()){
            used[c-'a'] = operation;
        }
    }
}