class Solution {
    public void rotate(int[] nums, int k) {
        
        // When we rotate elements of nums elements from back comes to front
        // So we bring all the elements to the front then we decide how many elements we want the elements we want we reverse them and we reverse the remaining elements
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);

    }

    private void reverse(int[] nums, int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}