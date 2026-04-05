public class Solution {
    public int hammingWeight(int n) {
        int count = 0; // Count of 1s

        while (n != 0) {
            n = n & (n - 1); // Removes the rightmost 1 bit
            count++;         // Increase count each time a 1 is removed
        }

        return count; // Final number of 1s
    }
}


/*

n = 23

Its binary representation (32-bit) is: 00000000 00000000 00000000 00010111


🔁 Step 1:

n      = 00000000 00000000 00000000 00010111  (23)
n - 1  = 00000000 00000000 00000000 00010110  (22)
------------------------------------------------
n & n-1= 00000000 00000000 00000000 00010110  → removes rightmost 1
✅ count = 1


🔁 Step 2:

n      = 00000000 00000000 00000000 00010110  (22)
n - 1  = 00000000 00000000 00000000 00010101  (21)
------------------------------------------------
n & n-1= 00000000 00000000 00000000 00010100  → removes rightmost 1
✅ count = 2


🔁 Step 3:

n      = 00000000 00000000 00000000 00010100  (20)
n - 1  = 00000000 00000000 00000000 00010011  (19)
------------------------------------------------
n & n-1= 00000000 00000000 00000000 00010000  → removes rightmost 1
✅ count = 3


🔁 Step 4:

n      = 00000000 00000000 00000000 00010000  (16)
n - 1  = 00000000 00000000 00000000 00001111  (15)
------------------------------------------------
n & n-1= 00000000 00000000 00000000 00000000  → removes last 1
✅ count = 4

Final State:
n = 0 → Exit loop.

✅ Total 1s counted = 4

Each n = n & (n - 1) removes one 1 bit from n.
Repeat this until all bits are 0, and you've counted all 1s

*/