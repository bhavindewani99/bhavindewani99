class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int l = 0;
        int r = products.length-1;

        for(int i=0;i<searchWord.length();i++){
            List<String> temp = new ArrayList<>();
            char c = searchWord.charAt(i);
            while(l<=r && (i>=products[l].length() || c!=products[l].charAt(i))) l++;
            while(l<=r && (i>=products[r].length() || c!=products[r].charAt(i))) r--;
            int remain = r - l +1;
            for(int k=0;k<Math.min(remain,3);k++){
                temp.add(products[l+k]);
            }
            result.add(temp);
        }

        return result;

    }
}