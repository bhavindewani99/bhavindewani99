class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        List<Integer> list = new ArrayList<>(Arrays.asList(a, b, c));
        Collections.sort(list);

        int x = list.get(0), y = list.get(1), z = list.get(2);

        int max = z - x - 2;
        int min = 2;

        if (y - x == 1 && z - y == 1) {
            min = 0; // already consecutive
        } else if (y - x <= 2 || z - y <= 2) {
            min = 1; // one stone can jump in
        }

        return new int[]{min, max};
    }
}
