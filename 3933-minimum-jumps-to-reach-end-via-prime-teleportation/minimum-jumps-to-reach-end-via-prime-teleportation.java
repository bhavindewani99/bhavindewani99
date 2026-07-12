import java.util.*;

class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        // Base case: If we are already at the last index, 0 jumps are needed
        if (n <= 1) return 0;

        // 1. MAP SETUP: Group indices by their unique prime factors
        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            
            // Standard prime factorization loop
            for (int p = 2; p * p <= temp; p++) {
                if (temp % p == 0) {
                    // 'p' is a prime factor! Add this index to the prime's bucket
                    primeToIndices.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                    
                    // Divide out all duplicates of this prime factor.
                    // This forces 'temp' to shrink and ensures the loop only stops on primes!
                    while (temp % p == 0) {
                        temp /= p;
                    }
                }
            }
            // If there's a leftover prime factor greater than sqrt(nums[i]) (like 3 in 12, or 7 in 14)
            if (temp > 1) {
                primeToIndices.computeIfAbsent(temp, k -> new ArrayList<>()).add(i);
            }
        }

        // 2. BFS CONFIGURATION
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        // Start from index 0
        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        // 3. BFS TRAVERSAL (Layer by Layer)
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // Process all nodes at the current distance layer
            for (int k = 0; k < size; k++) {
                int curr = queue.poll();

                // If we reached the target index, return the number of steps taken
                if (curr == n - 1) return steps;

                // Option A: Adjacent Step Forward (i + 1)
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                // Option B: Adjacent Step Backward (i - 1)
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }

                // Option C: Prime Teleportation
                int val = nums[curr];
                if (isValidPrime(val)) { 
                    // Retrieve all indices containing multiples of our current prime number
                    if (primeToIndices.containsKey(val)) {
                        for (int nextIdx : primeToIndices.get(val)) {
                            if (!visited[nextIdx]) {
                                visited[nextIdx] = true;
                                queue.offer(nextIdx);
                            }
                        }
                        // CRITICAL OPTIMIZATION: Remove the prime from the map 
                        // so we never loop through these same indices again.
                        primeToIndices.remove(val);
                    }
                }
            }
            // Move to the next layer of steps
            steps++;
        }
        
        return -1; // Return -1 if target index is completely unreachable
    }

    // Helper method to check if a value is prime
    private boolean isValidPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
