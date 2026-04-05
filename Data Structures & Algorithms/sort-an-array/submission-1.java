class Solution {

    /*
     * Merge Sort:
     * Divide array into two halves
     * Recursively sort both halves
     * Merge sorted halves
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left;      // pointer for left half
        int j = mid + 1;   // pointer for right half
        int k = 0;         // pointer for temp array

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // Copy remaining left elements
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // Copy remaining right elements
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy sorted elements back to original array
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }
}