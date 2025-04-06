class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        quickSort(nums, 0, nums.length - 1);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        int maxSize = 0, maxIndex = -1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;  
            prev[i] = -1; 
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (maxIndex != -1) {
            while (maxIndex != -1) {
                result.add(nums[maxIndex]);
                maxIndex = prev[maxIndex];
            }
            reverse(result);
        } else {
            result.add(nums[0]); 
        }
        return result;
    }
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    private void reverse(List<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }  
    }
}