
// Approach 1
// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {

//         // Start inserting elements of nums2 from index m in nums1
//         // because first m elements of nums1 are already valid
//         int k = m;
//         int i = 0;

//         // Copy all elements of nums2 into the remaining space of nums1
//         while (i < n) {
//             nums1[k] = nums2[i];
//             i++;
//             k++;
//         }

//         // After copying, nums1 now contains all elements from both arrays
//         // Idea: simply sort nums1 to get the final merged sorted array
//         Arrays.sort(nums1);
//     }
// }


// Approach 2

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=m+n-1;
        for(int i=m-1, j=n-1 ; j>=0;){
            if(i >= 0 && nums1[i]>nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}