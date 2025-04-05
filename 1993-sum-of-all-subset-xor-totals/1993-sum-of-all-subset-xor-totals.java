class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int totalXORSum = 0;
        for(int mask= 0; mask<(1<<n); mask++ ){
            int subsetXOR= 0;
            for(int i = 0; i<n; i++){
                if((mask & (1<<i)) !=0){
                    subsetXOR ^= nums[i];
                }
            }
            totalXORSum += subsetXOR;
        }
        return totalXORSum;
    }
}