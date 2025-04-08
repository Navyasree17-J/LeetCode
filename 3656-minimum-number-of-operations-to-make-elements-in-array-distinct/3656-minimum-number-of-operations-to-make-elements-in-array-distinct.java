class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        
        // Loop until the array has distinct elements
        while (true) {
            // Create an array to count the frequency of each number in the remaining nums
            int[] freq = new int[101]; // Array to store frequency (1 <= nums[i] <= 100)
            
            // Count the frequency of each element in the current nums array
            for (int num : nums) {
                freq[num]++;
            }
            
            // Check if all elements are distinct
            boolean allDistinct = true;
            for (int count : freq) {
                if (count > 1) {
                    allDistinct = false;
                    break;
                }
            }
            
            // If all elements are distinct, we can stop
            if (allDistinct) {
                break;
            }
            
            // Otherwise, we perform an operation by removing the first 3 elements
            operations++;
            // Create a new array to store the elements after removal
            int n = nums.length;
            int[] newNums = new int[n - Math.min(3, n)];
            System.arraycopy(nums, Math.min(3, n), newNums, 0, n - Math.min(3, n));
            nums = newNums;
        }
        
        return operations;
    }
}