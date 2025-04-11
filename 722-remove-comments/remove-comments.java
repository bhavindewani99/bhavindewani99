class Solution {
    public List<String> removeComments(String[] source) {
        
        List<String> result = new ArrayList<>();
        StringBuilder newLine = new StringBuilder();
        boolean inBlock = false;

        for(String line : source){
            char[] arr = line.toCharArray();
            int i = 0;
            if(inBlock == false) newLine = new StringBuilder();

            while(i<arr.length){
                if(inBlock==false && i+1<arr.length && arr[i]=='/' && arr[i+1]=='*'){
                    inBlock = true;
                    i++;
                }else if(inBlock==true && i+1<arr.length && arr[i]=='*' && arr[i+1]=='/'){
                    inBlock = false;
                    i++;
                }else if(inBlock==false && i+1<arr.length && arr[i]=='/' && arr[i+1]=='/'){
                    break;
                }else if(inBlock==false){
                    newLine.append(arr[i]);
                }
                i++;
            }
            if(inBlock==false && newLine.length() > 0){
                result.add(new String(newLine));
            }
        }
        return result;
    }
}