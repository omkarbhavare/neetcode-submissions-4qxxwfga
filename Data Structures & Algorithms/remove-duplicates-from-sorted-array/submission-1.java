class Solution {

    public int removeDuplicates(int[] nums) {

        // Slow pointer marks position of last unique element
        int slow = 0;

        // Fast pointer scans the array
        for (int fast = 1; fast < nums.length; fast++) {

            // If current element is different from last unique element
            if (nums[fast] != nums[slow]) {

                // Move slow pointer forward
                slow++;

                // Place new unique element
                nums[slow] = nums[fast];
            }
        }

        // Number of unique elements = slow index + 1
        return slow + 1;
    }
}