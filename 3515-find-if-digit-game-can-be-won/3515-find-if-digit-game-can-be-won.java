class Solution {
    public boolean canAliceWin(int[] nums) {
        int count1=0, count2=0;
        int n= nums.length;
        for(int i=0; i<n; i++)
        {
            if(nums[i]<10)
            {
               count1 += nums[i];
            }
            else
            {
                count2+= nums[i];
            }
        }
        return count1!=count2;
    }
}