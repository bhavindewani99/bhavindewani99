class Solution {
    public int nthUglyNumber(int n) {
        //return returnNthUglyNumber(n);
        return linearSolution(n);
    }

    // O(n) linear solution using 3 pointers
    private int linearSolution(int n){
        List<Long> uglyIntegers = new ArrayList<>();
        uglyIntegers.add(1l);
        int i2=0, i3=0, i5 =0;

        while(uglyIntegers.size()<n){
            long nextNumber = Math.min(uglyIntegers.get(i2)*2, Math.min(uglyIntegers.get(i3)*3, uglyIntegers.get(i5)*5));
            uglyIntegers.add(nextNumber);
            if(nextNumber==uglyIntegers.get(i2)*2) i2++;
            if(nextNumber==uglyIntegers.get(i3)*3) i3++;
            if(nextNumber==uglyIntegers.get(i5)*5) i5++;
        }

        return uglyIntegers.get(n-1).intValue();
    }

    // Heap Solution
    private int returnNthUglyNumber(int n){
        Set<Long> visited = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1l);
        n-=1;
        while(n>0){
            long number = heap.poll();
            if (visited.add(number * 2)) {
                heap.offer(number * 2);
            }
            if (visited.add(number * 3)) {
                heap.offer(number * 3);
            }
            if (visited.add(number * 5)) {
                heap.offer(number * 5);
            }
            n--;
        }
        return (heap.poll().intValue());
    }
}