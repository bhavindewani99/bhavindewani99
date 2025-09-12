import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return recursion(0, price, special, needs);
    }

    private int recursion(int specialIndex, List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(specialIndex);
        for (int x : needs) keyBuilder.append("*").append(x);
        String key = keyBuilder.toString();

        if (map.containsKey(key)) return map.get(key);

        // Base case: if no more specials, buy remaining items individually
        if (specialIndex == special.size()) {
            int amount = 0;
            for (int i = 0; i < price.size(); i++) {
                amount += needs.get(i) * price.get(i);
            }
            return amount;
        }

        // Option 1: skip this special
        int not_take = recursion(specialIndex + 1, price, special, needs);

        int take = Integer.MAX_VALUE;
        List<Integer> offer = special.get(specialIndex);

        // Check if this special can be applied
        boolean valid = true;
        List<Integer> newNeeds = new ArrayList<>();
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < offer.get(i)) {
                valid = false;
                break;
            }
            newNeeds.add(needs.get(i) - offer.get(i));
        }

        // Option 2: take this special (and stay at same index, so we can reuse it)
        if (valid) {
            take = offer.get(needs.size()) + recursion(specialIndex, price, special, newNeeds);
        }

        int result = Math.min(take, not_take);
        map.put(key, result);
        return result;
    }
}
