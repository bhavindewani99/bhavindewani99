class Solution {
  
  public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
    
    final long divisorLcm = lcm(divisor1, divisor2);
    
    long left = 0;
    long right = Integer.MAX_VALUE;
    long reuslt = 0;

    while (left <= right) {
      final long mid = (left + right) / 2;
     
      if (isPossible(mid, divisorLcm, divisor1, divisor2, uniqueCnt1, uniqueCnt2)){
        reuslt = mid;
        right = mid-1;
      }
        
      else
        left = mid + 1;
    }

    return (int) reuslt; 
  }

 
  private boolean isPossible(long maxVal, long divisorLcm, int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
    final long cnt1 = maxVal - maxVal / divisor1; 
    final long cnt2 = maxVal - maxVal / divisor2; 
    final long totalCnt = maxVal - maxVal / divisorLcm;
    
    return cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2 && totalCnt >= uniqueCnt1 + uniqueCnt2;
  }

  private long gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  private long lcm(int a, int b) {
    return a * (b / gcd(a, b)); 
  }
}