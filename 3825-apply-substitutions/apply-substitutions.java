class Solution {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        
        int index = 0, n = text.length();
        Map<Character, String> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        StringBuilder newText = new StringBuilder(text);

        for (List<String> list : replacements) {
            map.put(list.get(0).charAt(0), list.get(1));
        }

        while (index < newText.length()) {
            System.out.print(newText.charAt(index)+ " ");
            if(newText.charAt(index)=='%' && index+2<newText.length() && newText.charAt(index+2)=='%'){
                newText.replace(index, index+3, map.get(newText.charAt(index+1)));
            }else{
                result.append(newText.charAt(index));
                index++;
            }
        }

        return result.toString();
    }
}
