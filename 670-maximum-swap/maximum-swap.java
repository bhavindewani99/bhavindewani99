class Solution {
    public int maximumSwap(int num) {
        int[] occurence= new int[10];
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char c = s.charAt(i);
            occurence[c-'0'] = i;
        }

        for(int i=0;i<s.length();i++){
            for(int val=9;val>=0;val--){
                if(occurence[val]>i && val > (s.charAt(i)-'0')){
                    char temp = arr[i];
                    arr[i] = (char) (val + '0');
                    arr[occurence[val]] = temp;
                    StringBuilder res = new StringBuilder();
                    for(char m : arr) res.append(m);
                    return Integer.valueOf(res.toString());
                }
            }
        }
        return num;


    }
}