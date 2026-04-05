class Solution {
    public int[] twoSum(int[] nums, int target) {

        // HashMap to store number → its index
        // Key   = number from the array
        // Value = index of that number
        HashMap<Integer, Integer> map = new HashMap<>();

        // Loop through the array once
        for (int i = 0; i < nums.length; i++) {

            // Calculate the number needed to reach the target
            // target = nums[i] + complement
            int complement = target - nums[i];

            // Check if the complement already exists in the map
            // If yes, we have found two numbers that add up to target
            if (map.containsKey(complement)) {

                // Return the index of the complement (stored earlier)
                // and the current index
                return new int[] { map.get(complement), i };
            }

            // Store the current number with its index
            // This happens AFTER the check to avoid using the same element twice
            map.put(nums[i], i);
        }

        // If no valid pair is found (edge case)
        // LeetCode usually guarantees one solution, so this is just a fallback
        return new int[] { -1, -1 };
    }
}
