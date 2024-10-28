class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        int n = folder.length;

        for(int i=0;i<n;i++){
            String path = folder[i];
            if(path.length()<=1 || path.charAt(0)!='/') continue;
            StringBuilder curr = new StringBuilder();
            curr.append("/");
            boolean contains = false;
            for(int j=1;j<path.length();j++){
                while(j<path.length() && path.charAt(j)!='/'){
                    curr.append(path.charAt(j++));
                }
                if(set.contains(curr.toString())) {
                    contains = true;
                    break;
                }
                if(j<path.length()) curr.append("/");
            }
            if(contains==false){
                set.add(curr.toString());
            }
        }
        for(String curr : set) res.add(curr);
        return res;
    }
}