class Solution {
    public String simplifyPath(String path) {
        List<String> res = new ArrayList<>();
        //res.add("/");
        int n = path.length();
        for(int i=1;i<path.length();i++){
            StringBuilder curr = new StringBuilder();
            int index = i;
            while(index<n && path.charAt(index)!='/'){
                curr.append(path.charAt(index++));
            }
            System.out.println(curr);
            if(curr.toString().equals("..")){
                System.out.println("yo");
                if(res.size()>0) res.removeLast();
            }else if(!curr.toString().equals(".")){
                res.add(curr.toString());
            }
            i=index;
            while (i<n && path.charAt(i)=='/') {
                i++;
            }
            i--;
        }
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<res.size();i++){
            temp.append(res.get(i));
            if(i!=res.size()-1)
            temp.append("/");
        }
        if(temp.length()==0) temp.append('/');
        if(temp.charAt(0)!='/') temp.insert(0, '/');
        return temp.toString();
    }
}