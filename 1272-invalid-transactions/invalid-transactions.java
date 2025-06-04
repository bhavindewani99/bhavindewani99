class Solution {
    static class Transaction {
        int index;
        String name;
        int time;
        int amount;
        String city;

        Transaction(int index, String[] parts) {
            this.index = index;
            this.name = parts[0];
            this.time = Integer.parseInt(parts[1]);
            this.amount = Integer.parseInt(parts[2]);
            this.city = parts[3];
        }

        String toOriginalString() {
            return String.join(",", name, String.valueOf(time), String.valueOf(amount), city);
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        Transaction[] parsed = new Transaction[n];
        boolean[] invalid = new boolean[n];

        // Parse all transactions
        for (int i = 0; i < n; i++) {
            String[] parts = transactions[i].split(",");
            parsed[i] = new Transaction(i, parts);
        }

        // Group transactions by name
        Map<String, List<Transaction>> nameToTransactions = new HashMap<>();
        for (Transaction txn : parsed) {
            nameToTransactions.computeIfAbsent(txn.name, k -> new ArrayList<>()).add(txn);
        }

        // Check invalid transactions by name group
        for (List<Transaction> txns : nameToTransactions.values()) {
            // Sort by time for efficient window check
            txns.sort(Comparator.comparingInt(t -> t.time));

            for (int i = 0; i < txns.size(); i++) {
                Transaction t1 = txns.get(i);

                // Rule 1: amount > 1000
                if (t1.amount > 1000) {
                    invalid[t1.index] = true;
                }

                // Rule 2: check nearby transactions within 60 minutes and different city
                // Since sorted, break early once time difference > 60
                for (int j = i + 1; j < txns.size(); j++) {
                    Transaction t2 = txns.get(j);
                    if (t2.time - t1.time > 60) break;
                    if (!t1.city.equals(t2.city)) {
                        invalid[t1.index] = true;
                        invalid[t2.index] = true;
                    }
                }
            }
        }

        // Collect invalid transactions to result
        List<String> result = new ArrayList<>();
        // for (Transaction txn : parsed) {
        //     if (invalid[txn.index]) {
        //         result.add(txn.toOriginalString());
        //     }
        // }

        for(int i=0;i<n;i++){
            if(invalid[i]) result.add(transactions[i]);
        }

        return result;
    }
}
