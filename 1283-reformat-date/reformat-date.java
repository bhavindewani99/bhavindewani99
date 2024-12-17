class Solution {
    public String reformatDate(String date) {
        Map<String, String> map = new HashMap<>();
        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");
        StringBuilder result = new StringBuilder();
        String[] arr = date.split(" ");
        result.append(arr[2]+"-");
        result.append(map.get(arr[1])+"-");
        String day = arr[0].substring(0, arr[0].length()-2);
        if(day.length()==1) result.append("0"+day); 
        else result.append(day);
        return result.toString();
    }
}