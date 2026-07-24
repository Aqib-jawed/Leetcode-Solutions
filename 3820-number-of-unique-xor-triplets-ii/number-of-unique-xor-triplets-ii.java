class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] exist = new boolean[1501];
        ArrayList<Integer> values = new ArrayList<>();

        for (int x : nums) {
            if (!exist[x]) {
                exist[x] = true;
                values.add(x);
            }
        }

        final int MAX = 2048;

        boolean[] pairXor = new boolean[MAX];
        for (int x : values) {
            for (int y : values) {
                pairXor[x ^ y] = true;
            }
        }
        boolean[] ans = new boolean[MAX];
        for (int px = 0; px < MAX; px++) {
            if (!pairXor[px]) continue;
            for (int z : values) {
                ans[px ^ z] = true;
            }
        }
        int count = 0;
        for (boolean v : ans) {
            if (v) count++;
        }
       return count;
    }
}