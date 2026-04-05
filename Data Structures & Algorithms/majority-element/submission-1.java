

class Solution {
    public int majorityElement(int[] nums) {
        // Step 1: Create a HashMap to store number -> frequency (count)
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 2: Fill the map with frequencies
        for (int num : nums) {
            // If the number is already in map, get its count; else use 0
            // Increase the count by 1 and put it back in map
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 3: Find the number which appears more than n/2 times
        int n = nums.length;
        for (int key : map.keySet()) {
            // If frequency of any key > n/2, return it as the majority element
            if (map.get(key) > n / 2) {
                return key;
            }
        }

        // Step 4: The problem says majority element always exists, so this return won't be reached
        return -1;
    }
}
