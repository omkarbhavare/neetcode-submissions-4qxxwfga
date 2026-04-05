class Solution {
    public int[] productExceptSelf(int[] nums) {

        // ─── Count zeros & build total product (skip zeros) ────────────
        // zeroCount tracks how many zeros exist
        // total = product of all non-zero elements
        //
        // nums = [1, 2, 3, 4]  → zeroCount=0, total=24
        // nums = [1, 2, 0, 4]  → zeroCount=1, total=8
        // nums = [1, 0, 0, 4]  → zeroCount=2, total=4

        int total = 1;
        int zeroCount = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                total *= num;
            }
        }

        // ─── Fill answer based on zero count ───────────────────────────
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            if (zeroCount >= 2) {
                // Case 1: two or more zeros
                // every product = 0, nothing survives
                // [1,0,0,4] → [0, 0, 0, 0]
                ans[i] = 0;

            } else if (zeroCount == 1) {
                // Case 2: exactly one zero
                // only the zero's position gets total, everything else = 0
                // [1,2,0,4] → [0, 0, 8, 0]
                ans[i] = (nums[i] == 0) ? total : 0;

            } else {
                // Case 3: no zeros
                // simple division: total / nums[i]
                // [1,2,3,4] → [24, 12, 8, 6]
                ans[i] = total / nums[i];
            }
        }

        return ans;
    }
}
/*

**Tracing all 3 cases:**
```
Case 3 — no zeros
nums  = [1,  2,  3,  4]   total=24  zeroCount=0
ans   = [24, 12, 8,  6] ✓

Case 2 — one zero
nums  = [1,  2,  0,  4]   total=8   zeroCount=1
ans   = [0,  0,  8,  0] ✓
             ↑ only zero's index gets total

Case 1 — two zeros
nums  = [1,  0,  0,  4]   total=4   zeroCount=2
ans   = [0,  0,  0,  0] ✓*/