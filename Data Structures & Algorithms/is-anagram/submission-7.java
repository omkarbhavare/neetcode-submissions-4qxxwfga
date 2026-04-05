class Solution {
    public boolean isAnagram(String s, String t) {

    // Anagrams must have the same length.
    // If lengths differ, they cannot be anagrams.
    if (s.length() != t.length()) return false;

    // This map will store the frequency of each character in string 's'
    // Key   → character
    // Value → how many times that character appears
    HashMap<Character, Integer> map = new HashMap<>();

    // Step 1: Count frequency of each character in 's'
    // We are building a reference count that 't' must exactly match.
    for (char c : s.toCharArray()) {
        // Increase count of character 'c' by 1
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    // Step 2: Reduce frequency using characters from 't'
    // Each character in 't' should cancel out one occurrence from 's'
    for (char c : t.toCharArray()) {

        // If 't' contains a character that was never in 's',
        // then the strings cannot be anagrams.
        if (!map.containsKey(c)) return false;

        // Decrease the frequency since this character is matched
        map.put(c, map.get(c) - 1);

        // If frequency becomes zero, remove the character
        // This keeps the map clean and small
        if (map.get(c) == 0) {
            map.remove(c);
        }
    }

    // Step 3: If all characters matched perfectly,
    // the map should be empty.
    // Empty map ⇒ every character in 's' was exactly matched by 't'
    return map.isEmpty();
}

}
