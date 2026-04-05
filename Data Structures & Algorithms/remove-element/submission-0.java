class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;  // This will track the position to place elements that are not equal to 'val'

        // Traverse through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is NOT equal to the value we want to remove
            if (nums[i] != val) {
                nums[index] = nums[i];  // Move this valid element to the front
                index++;                // Increment the index for next valid placement
            }
        }

        // Return the count of elements remaining after removing 'val'
        return index;
    
        
    }
}

/* What if i want to remove duplicate elements from the array as well */

/*
public int removeElementAndDuplicates(int[] nums, int val) {
        HashSet<Integer> seen = new HashSet<>();
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // Skip if the element matches val or is already seen
            if (nums[i] != val && !seen.contains(nums[i])) {
                seen.add(nums[i]);
                nums[index] = nums[i];
                index++;
            }
        }

        return index; // New length after removing val and duplicates
    }


int[] nums = {0, 1, 2, 2, 0, 3, 0, 4, 2};
int val = 2;

New length: 4
Updated array: [0, 1, 3, 4]


    */