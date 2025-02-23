class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String path : paths){
            String[] arr = path.split(" ");
            String directory = arr[0];
            for(int i=1;i<arr.length;i++){
                StringBuilder filename = new StringBuilder();
                StringBuilder text = new StringBuilder();
                boolean fileNameContent = true;
                for(char c : arr[i].toCharArray()){
                    if(c=='(') fileNameContent=false;
                    if(fileNameContent) filename.append(c);
                    else text.append(c);
                }
                map.putIfAbsent(text.toString(), new ArrayList<>());
                String fullPath = directory + "/" + filename.toString();
                map.get(text.toString()).add(fullPath);
            }
        }

        for(List<String> values : map.values()){
            if(values.size()>1)
            result.add(values);
        }

        return result;
    }
}