class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;  // one slot for root
        int i = 0;

        while (i < preorder.length()) {

            if (slots == 0) return false;  // no slot available

            if (preorder.charAt(i) == '#') {
                slots--;   // consume one slot
                i++;
            } else {
                // read the full number
                while (i < preorder.length() && preorder.charAt(i) != ',') {
                    i++;
                }
                slots--;   // consume one slot
                slots += 2; // add two new slots
            }

            if (i < preorder.length() && preorder.charAt(i) == ',') {
                i++;
            }
        }

        return slots == 0;
    }
}
