class Solution {
    public int minOperations(int[] nums, int k) {
         Arrays.sort(nums);
        
        int operations = 0;
        int prevMax = Integer.MAX_VALUE;  // Initialize the largest possible valid `h`
        
        // Iterate from largest to smallest element in the sorted array
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > k) {
                // If the current number is greater than k, we need to apply an operation
                // Check if it's valid to reduce it to a smaller number
                if (nums[i] < prevMax) {
                    operations++;  // Perform one operation
                    prevMax = nums[i];  // Update the maximum valid `h` for the next operation
                }
            } else if (nums[i] < k) {
                // If any number is smaller than k, it's impossible to make all equal to k
                return -1;
            }
        }

        return operations;   
    }
}