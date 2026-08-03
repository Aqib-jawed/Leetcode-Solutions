class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        
        // dp[i % 4] will store the max relative score from index i.
        // We initialize dp values beyond array length (base cases) to 0.
        int dp1 = 0; // represents dp[i + 1]
        int dp2 = 0; // represents dp[i + 2]
        int dp3 = 0; // represents dp[i + 3]
        
        // Process backward from the end of the array
        for (int i = n - 1; i >= 0; i--) {
            int currentSum = 0;
            int maxScore = Integer.MIN_VALUE;
            
            // Try taking k = 1, 2, or 3 stones
            for (int k = 1; k <= 3 && i + k <= n; k++) {
                currentSum += stoneValue[i + k - 1];
                
                int opponentScore = 0;
                if (k == 1) opponentScore = dp1;
                else if (k == 2) opponentScore = dp2;
                else if (k == 3) opponentScore = dp3;
                
                maxScore = Math.max(maxScore, currentSum - opponentScore);
            }
            
            // Shift values for the next step (moving left)
            dp3 = dp2;
            dp2 = dp1;
            dp1 = maxScore;
        }
        
        // dp1 now holds dp[0], the result for Alice starting first
        if (dp1 > 0) {
            return "Alice";
        } else if (dp1 < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}