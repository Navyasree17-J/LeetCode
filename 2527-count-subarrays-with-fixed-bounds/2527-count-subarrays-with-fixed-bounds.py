class Solution(object):
    def countSubarrays(self, nums, minK, maxK):
        """
        :type nums: List[int]
        :type minK: int
        :type maxK: int
        :rtype: int
        """
        count = 0
        lastMinK = -1
        lastMaxK = -1
        lastInvalid = -1

        # Iterate through the nums array
        for i, num in enumerate(nums):
            # If the current number is out of bounds (less than minK or greater than maxK)
            if num < minK or num > maxK:
                lastInvalid = i  # Mark the position as invalid

            # If the current number is equal to minK, update lastMinK
            if num == minK:
                lastMinK = i

            # If the current number is equal to maxK, update lastMaxK
            if num == maxK:
                lastMaxK = i

            # Now we check if both minK and maxK have appeared before
            if lastMinK != -1 and lastMaxK != -1:
                # Count subarrays that end at i and include both minK and maxK
                # Subarrays must start after the lastInvalid position
                count += max(0, min(lastMinK, lastMaxK) - lastInvalid)

        return count

# Example usage:
nums = [1, 3, 5, 2, 7, 5]
minK = 1
maxK = 5
solution = Solution()
print(solution.countSubarrays(nums, minK, maxK))  # Output: 2