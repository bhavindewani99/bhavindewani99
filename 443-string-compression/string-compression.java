class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int start =0 ;
        int i =0;

        while(i<n){
            char c = chars[i];
            int count = 0;
            while(i<n && chars[i]==c){
                i++;
                count++;
            }
            if(count==1){
                chars[start++] = c;
                i--;
            }else{
                chars[start++] = c;
                System.out.println("c "+c+" count "+count);
                String num = String.valueOf(count);
                for(int k=0;k<num.length();k++) chars[start++] = num.charAt(k);
                i--;
            }
            i++;
        }
        return start;
    }
}