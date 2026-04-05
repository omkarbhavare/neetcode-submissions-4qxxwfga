public class Solution {
    public int singleNumber(int[] nums) {
        // Initialize result to 0. This will hold the final single number.
        int result = 0;

        // Loop through each number in the array
        for (int num : nums) {
            // Use XOR (^) to cancel out numbers that appear twice.
            // If a number appears twice: a ^ a = 0
            // If 0 is XORed with a number: 0 ^ a = a
            // So, all pairs will cancel out and only the single number will remain.
            result ^= num;
        }

        // Return the number that appears only once
        return result;
    }
}

/*

For input nums = [2, 3, 2, 4, 3]:

XOR steps:
0 ^ 2 = 2
2 ^ 3 = 1
1 ^ 2 = 3
3 ^ 4 = 7
7 ^ 3 = 4

🎯 Why does this work?
XOR (^) cancels out duplicate numbers:

a ^ a = 0

0 ^ a = a

Order doesn’t matter because XOR is commutative and associative.

So in this case:

2 ^ 2 = 0

3 ^ 3 = 0

Then: 0 ^ 0 ^ 4 = 4

Only 4 is left because it's the only number that appears once.


nums = [2, 3, 2, 4, 3]

result = 0000 0000  (0 in binary)


Step 1: result ^ 2
  0000 0000   (0)
^ 0000 0010   (2)
-----------
  0000 0010 = 2

Step 2: result ^ 3
  0000 0010   (2)
^ 0000 0011   (3)
-----------
  0000 0001 = 1


Step 3: result ^ 2
  0000 0001   (1)
^ 0000 0010   (2)
-----------
  0000 0011 = 3


Step 4: result ^ 4
  0000 0011   (3)
^ 0000 0100   (4)
-----------
  0000 0111 = 7


Step 5: result ^ 3
  0000 0111   (7)
^ 0000 0011   (3)
-----------
  0000 0100 = 4


0000 0100 = 4


Conclusion:
XOR cancels out matching bits.

All duplicates (2 and 3) were nullified.

Only 4 remained, which appears once.
*/