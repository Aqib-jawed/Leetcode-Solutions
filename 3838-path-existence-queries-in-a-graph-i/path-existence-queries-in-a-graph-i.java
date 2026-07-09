class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Step 1: Group indices into contiguous connected components
        int[] comp = new int[n];
        int currComp = 0;
        comp[0] = 0;

        for (int i = 1; i < n; i++) {
            // Because nums is sorted, if the gap between adjacent elements 
            // exceeds maxDiff, it breaks the chain and starts a new component.
            if (nums[i] - nums[i - 1] > maxDiff) {
                currComp++;
            }
            comp[i] = currComp;
        }

        // Step 2: Process queries and populate a primitive boolean array
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            // If they share the same component ID, a valid path exists
            ans[i] = (comp[u] == comp[v]);
        }

        return ans;
    }
}