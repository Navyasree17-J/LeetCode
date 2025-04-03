class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxValue = 0;
        long maxLeft = Long.MIN_VALUE;
        long[] maxRight = new long[n];
        maxRight[n-1]=nums[n-1];
        for(int k = n-2; k >=0;k--){
            maxRight[k] = Math.max(nums[k], maxRight[k+1]);
        }
        for(int j =1; j<n-1; j++){
            maxLeft=Math.max(maxLeft, nums[j - 1]);
            long tripleValue = (maxLeft - nums[j]) * maxRight[j+1];
            maxValue=Math.max(maxValue, tripleValue);
        }
        return maxValue;         
    }
}