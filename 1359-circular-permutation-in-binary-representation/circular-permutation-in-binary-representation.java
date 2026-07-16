import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> circularPermutation(int n, int start) {
        // 1. FIX: Total elements is 2^n, not 2^n - 1
        int totalSize = 1 << n; 
        List<Integer> curr = new ArrayList<>();
        curr.add(start);
        
        // 2. FIX: Boolean array size must accommodate index up to (totalSize - 1)
        boolean[] visited = new boolean[totalSize]; 
        visited[start] = true;
        
        recursion(n, visited, start, curr, totalSize);
        return res;
    }

    // 3. FIX: Restored missing types and parameters in the signature
    private boolean recursion(int n, boolean[] visited, int last, List<Integer> curr, int totalSize) {
        // Base Case: If the current list reaches the total size
        if (curr.size() == totalSize) {
            // Check if the last and first elements differ by exactly 1 bit
            if (checkBitDiff(curr.get(0), curr.get(totalSize - 1), n)) {
                res.addAll(curr);
                return true; // Found a valid circular permutation, stop recursion
            }
            return false;
        }

        // Try flipping each of the 'n' bits of the 'last' element
        for (int i = 0; i < n; i++) {
            // 4. FIX: Use XOR (^) to cleanly flip the i-th bit from 0->1 or 1->0
            int nextEle = last ^ (1 << i);

            if (visited[nextEle]) continue;

            visited[nextEle] = true;
            curr.add(nextEle); // 5. FIX: Removed typo 'addd'

            // Recursively search. If a solution is found, cascade the success up
            if (recursion(n, visited, nextEle, curr, totalSize)) {
                return true;
            }

            // Backtrack
            curr.remove(curr.size() - 1); // 6. FIX: Standard method to remove last element
            visited[nextEle] = false;
        }
        return false;
    }

    // 7. FIX: Renamed method from 'check' to 'checkBitDiff' to match the recursion call
    private boolean checkBitDiff(int x, int y, int n) {
        int diff = 0;
        for (int i = 0; i < n; i++) {
            int xBit = ((1 << i) & x) != 0 ? 1 : 0;
            int yBit = ((1 << i) & y) != 0 ? 1 : 0;
            if (xBit != yBit) diff++;
        }
        return diff == 1; // 8. FIX: Must be exactly 1 bit difference to be a valid Gray code step
    }
}
