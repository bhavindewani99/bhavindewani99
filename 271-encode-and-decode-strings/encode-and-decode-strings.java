public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String curr : strs) {
            result.append(curr.length());
            result.append("-");
            result.append(curr);           
        }
        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int index = 0;
        
        while(index<s.length()){
            StringBuilder count = new StringBuilder();
            while(s.charAt(index)!='-'){
                count.append(s.charAt(index++));
            }
            int cnt = Integer.valueOf(count.toString());
            result.add(s.substring(index+1, index+1+cnt));
            index = index + 1 + cnt;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));