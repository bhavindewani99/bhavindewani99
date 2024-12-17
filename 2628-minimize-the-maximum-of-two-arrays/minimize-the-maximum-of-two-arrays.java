class Solution {
  
  public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
    // Calculate the least common multiple of the two divisors
    final long divisorLcm = lcm(divisor1, divisor2);
    // Use binary search to find the smallest maximum number that can fill both arrays
    long left = 0;
    long right = Integer.MAX_VALUE;

    while (left < right) {
      final long mid = (left + right) / 2;
      // Check if it's possible to distribute numbers with the current mid as the maximum
      if (isPossible(mid, divisorLcm, divisor1, divisor2, uniqueCnt1, uniqueCnt2))
        right = mid; // Adjust right boundary if mid is a feasible solution
      else
        left = mid + 1; // Adjust left boundary if mid is not feasible
    }

    return (int) left; // Cast to int because the problem states the number will be within the int range
  }

  // Helper method to determine if it's possible to distribute the numbers to both arrays
  private boolean isPossible(long maxVal, long divisorLcm, int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
    final long cnt1 = maxVal - maxVal / divisor1; // Count of numbers not divisible by divisor1
    final long cnt2 = maxVal - maxVal / divisor2; // Count of numbers not divisible by divisor2
    final long totalCnt = maxVal - maxVal / divisorLcm; // Adjust count to exclude numbers divisible by both divisors
    
    // Check if the conditions are satisfied for both arrays
    return cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2 && totalCnt >= uniqueCnt1 + uniqueCnt2;
  }

  // Helper method to compute the greatest common divisor
  private long gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  // Helper method to compute the least common multiple using the gcd
  private long lcm(int a, int b) {
    return a * (b / gcd(a, b)); // Ensure the multiplication doesn't overflow unnecessarily
  }
}