class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // ─── STEP 1: Build frequency map ───────────────────────────────
        // We count how many times each number appears.
        // map.getOrDefault(num, 0) returns existing count or 0 if first time.
        //
        // Input: nums = [1, 2, 2, 3, 3, 3, 3, 4, 4], k = 2
        //
        // After loop:
        //   map = { 1→1, 2→2, 3→4, 4→2 }
        //         (1 appears 1x, 2 appears 2x, 3 appears 4x, 4 appears 2x)

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // ─── STEP 2: Create buckets where index = frequency ────────────
        // Bucket array size = nums.length + 1  →  size 10 (indices 0..9)
        // A number with frequency F goes into bucket[F].
        // Max possible frequency = nums.length (if all elements are the same).
        //
        // Filling:
        //   key=1, freq=1  →  bucket[1] = [1]
        //   key=2, freq=2  →  bucket[2] = [2]
        //   key=3, freq=4  →  bucket[4] = [3]
        //   key=4, freq=2  →  bucket[2] = [2, 4]   ← 4 shares slot with 2
        //
        // Bucket state after loop:
        //   index:  0    1    2       3    4    5..9
        //   bucket: null [1] [2,4]  null  [3]  null...

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        // ─── STEP 3: Read right to left, collect top K ─────────────────
        // We scan from the highest index (= highest frequency) down to 0.
        // We stop as soon as we've collected k elements.
        //
        // result = new int[2]  →  [0, 0]   idx=0
        //
        // i=9  bucket[9]=null  → skip
        // i=8  bucket[8]=null  → skip
        // i=7  bucket[7]=null  → skip
        // i=6  bucket[6]=null  → skip
        // i=5  bucket[5]=null  → skip
        // i=4  bucket[4]=[3]   → result[0]=3   idx becomes 1
        //                         result = [3, 0]
        // i=3  bucket[3]=null  → skip
        // i=2  bucket[2]=[2,4] → result[1]=2   idx becomes 2
        //                         result = [3, 2]
        //                         idx==k (2==2) → outer loop exits
        //
        // Final result: [3, 2]  ✓  (the 2 most frequent elements)

        int[] result = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[idx++] = num;
                }
            }
        }
        return result;

        // ─── COMPLEXITY ────────────────────────────────────────────────
        // Time:  O(n)  — each step is a single linear pass
        // Space: O(n)  — map + bucket array both scale with input size
    }
}
/*
```
nums = [1,2,2,3,3,3,3,4,4]   k=2

STEP 1 → map    = {1:1, 2:2, 3:4, 4:2}

STEP 2 → bucket:
  [0] null
  [1] [1]
  [2] [2, 4]
  [3] null
  [4] [3]        ← highest freq

STEP 3 → scan right→left:
  i=4  grab 3   result=[3,_]
  i=2  grab 2   result=[3,2]  idx==k → STOP

return [3, 2] ✓*/