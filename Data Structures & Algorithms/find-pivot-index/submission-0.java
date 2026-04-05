class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        // leftPrefix[i] = sum of nums[0..i-1] (LEFT of index i)
        int[] leftPrefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            leftPrefix[i + 1] = leftPrefix[i] + nums[i];
        }

        // rightPrefix[i] = sum of nums[i+1..n-1] (RIGHT of index i)
        int[] rightPrefix = new int[n];   // size n, not n+1
        // rightPrefix[n-1] = 0 by default (nothing right of last element)
        for (int i = n - 2; i >= 0; i--) {
            rightPrefix[i] = rightPrefix[i + 1] + nums[i + 1];
        }

        // Pivot: leftSum == rightSum at index i
        for (int i = 0; i < n; i++) {
            if (leftPrefix[i] == rightPrefix[i]) {
                return i;
            }
        }
        return -1;
    }
}