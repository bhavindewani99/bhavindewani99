class Solution {
    public String smallestBeautifulString(String s, int k) {
        char[] arr = s.toCharArray();
        char limit = (char)('a'+k -1);

        for(int i=arr.length-1;i>=0;i--){
            char nextChar = getNextChar(arr, i, (char)(arr[i]+1), limit);
            if(nextChar<=limit){
                arr[i] = nextChar;
                for(int j = i+1; j<arr.length;j++){
                    arr[j] = getNextChar(arr, j, 'a', limit);
                }
                return new String(arr);
            }
        }
        return "";
    }

    private char getNextChar(char[] arr, int index, char curr, char limit){
       while(curr<=limit){
            if ((index >= 1 && curr == arr[index - 1]) || (index >= 2 && curr == arr[index - 2])) {
                curr++;
            } else {
                break;
            }
        }
        return curr;
    }
}