class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        List<String> result = new ArrayList<>();
        boolean[] invalid = new boolean[n];

        String[][] parsed = new String[n][];
        for (int i = 0; i < n; i++) {
            parsed[i] = transactions[i].split(",");
        }

        for (int i = 0; i < n; i++) {
            String name1 = parsed[i][0];
            int time1 = Integer.parseInt(parsed[i][1]);
            int amount1 = Integer.parseInt(parsed[i][2]);
            String city1 = parsed[i][3];

            // Rule 1: Amount > 1000
            if (amount1 > 1000) {
                invalid[i] = true;
            }

            // Rule 2: Different city within 60 minutes
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                String name2 = parsed[j][0];
                int time2 = Integer.parseInt(parsed[j][1]);
                String city2 = parsed[j][3];

                if (name1.equals(name2) && !city1.equals(city2) && Math.abs(time1 - time2) <= 60) {
                    invalid[i] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (invalid[i]) {
                result.add(String.join(",", parsed[i]));
            }
        }

        return result;
    }
}
