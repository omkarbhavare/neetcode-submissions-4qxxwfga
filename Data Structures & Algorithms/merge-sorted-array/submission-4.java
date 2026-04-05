
// Approach 1
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {

//         // Start inserting elements of nums2 from index m in nums1
//         // because first m elements of nums1 are already valid
//         int k = m;
//         int i = 0;

//         // Copy all elements of nums2 into the remaining space of nums1
//         while (i < n) {
//             nums1[k] = nums2[i];
//             i++;
//             k++;
//         }

//         // After copying, nums1 now contains all elements from both arrays
//         // Idea: simply sort nums1 to get the final merged sorted array
//         Arrays.sort(nums1);
//     }
// }


// Approach 2

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Index where the next largest element will be placed
        int insertPosition = m + n - 1;

        // Pointer to the last valid element in nums1
        int nums1Pointer = m - 1;

        // Pointer to the last element in nums2
        int nums2Pointer = n - 1;

        // Continue until all elements from nums2 are placed
        while (nums2Pointer >= 0) {

            // If nums1 still has elements and its current value is larger
            if (nums1Pointer >= 0 && nums1[nums1Pointer] > nums2[nums2Pointer]) {

                // Place nums1 element at the insert position
                nums1[insertPosition] = nums1[nums1Pointer];
                nums1Pointer--;

            } else {

                // Place nums2 element at the insert position
                nums1[insertPosition] = nums2[nums2Pointer];
                nums2Pointer--;
            }

            // Move insert position to the left
            insertPosition--;
        }
    }
}