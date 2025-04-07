class Solution {
    public boolean canPartition(int[] nums) {
         int sum = 0;
        
        // Calculate the total sum of the array
        for (int num : nums) {
            sum += num;
        }
        
        // If the sum is odd, it's impossible to partition the array into two subsets with equal sum
        if (sum % 2 != 0) {
            return false;
        }
        
        // The target sum for each subset is half of the total sum
        int target = sum / 2;
        
        // Create a boolean DP array to store if a subset sum is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Sum of 0 is always achievable
        
        // Iterate over each number in the array
        for (int num : nums) {
            // Traverse the dp array from right to left
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        // If dp[target] is true, then we can partition the array into two subsets with equal sum
        return dp[target];
    }
}