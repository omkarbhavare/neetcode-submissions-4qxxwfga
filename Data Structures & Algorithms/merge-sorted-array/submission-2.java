class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m;
        int i=0;
        while(i<n){
            nums1[k] = nums2[i];
            i++;
            k++;
        }

        Arrays.sort(nums1);
    }
}