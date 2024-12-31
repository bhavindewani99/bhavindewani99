class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0) {
                continue; // Skip if already processed
            }

            boolean isForward = nums[i] >= 0; // Determine direction
            int slow = i, fast = i;

            while (true) {
                // Move one step for the slow pointer
                slow = findNextIndex(nums, isForward, slow);
                if (slow == -1) {
                    break; // Invalid move or direction change
                }

                // Move one step for the fast pointer
                fast = findNextIndex(nums, isForward, fast);
                if (fast != -1) {
                    // Move another step for the fast pointer
                    fast = findNextIndex(nums, isForward, fast);
                }

                if (fast == -1 || slow == -1 || slow == fast) {
                    break;
                }
            }

            // If slow and fast meet, we found a cycle
            if (slow != -1 && slow == fast) {
                return true;
            }

            // Mark all nodes in this path as visited
            slow = i;
            while (true) {
                int next = findNextIndex(nums, isForward, slow);
                if (next == -1 || nums[slow]==0) {
                    break;
                }
                nums[slow] = 0;
                slow = next;
            }
        }

        return false;
    }

    public int findNextIndex(int[] arr, boolean isForward, int currIndex) {
        boolean direction = arr[currIndex] >= 0;

        if (isForward != direction) {
            return -1; // Change in direction
        }

        int nextIndex = (currIndex + arr[currIndex]) % arr.length;
        if (nextIndex < 0) {
            nextIndex += arr.length; // Handle negative wrap-around
        }

        if (nextIndex == currIndex) {
            return -1; // One-element cycle
        }

        return nextIndex;
    }
}
