class Solution {
    public int compareVersion(String version1, String version2) {
        
        int index1 = 0, index2 =0;
        int m = version1.length(), n = version2.length();

        while(index1 < m || index2 < n){
            StringBuilder num = new StringBuilder();
            while(index1 < m && version1.charAt(index1)!='.') num.append(version1.charAt(index1++));
            int num1 = num.length() >0 ? Integer.valueOf(num.toString()) : 0;

            num = new StringBuilder();
            while(index2 < n && version2.charAt(index2)!='.') num.append(version2.charAt(index2++));
            int num2 = num.length() >0 ? Integer.valueOf(num.toString()) : 0;

            System.out.println("Num 1 is "+ num1 + " num2 is "+num2);
            if(num1 < num2) return -1;
            else if(num1 > num2) return 1;
            index1++;
            index2++;
        }

        return 0;
    }
}