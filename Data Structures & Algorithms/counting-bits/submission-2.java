class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int count = 0;
            int num = i;

            // Count 1s in binary representation
            while (num != 0) {
                if ((num & 1) == 1) { // check if last bit is 1
                    count++;
                }
                num >>= 1; // right shift to move to the next bit
            }

            ans[i] = count;
        }

        return ans;
    }
}
