class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] ans = new int[len1 + len2][2];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < len1 && j < len2) {
            while(i < len1 && j < len2 && nums1[i][0] < nums2[j][0]) {
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1];
                i++;
                k++;
            }
            while(i < len1 && j < len2 && nums1[i][0] > nums2[j][0]) {
                ans[k][0] = nums2[j][0];
                ans[k][1] = nums2[j][1];
                j++;
                k++;
            }
            if(i < len1 && j < len2 && nums1[i][0] == nums2[j][0]) {
                ans[k][0] = nums1[i][0];
                ans[k][1] = nums1[i][1] + nums2[j][1];
                i++;
                j++;
                k++;
            }
        }
        
        while(i < len1) {
            ans[k][0] = nums1[i][0];
            ans[k][1] = nums1[i][1];
            k++;
            i++;
        }
        
        while(j < len2) {
            ans[k][0] = nums2[j][0];
            ans[k][1] = nums2[j][1];
            k++;
            j++;
        }
        
        int[][] ansFinal = new int[k][2];
        
        for(int x = 0; x < k; x++) {
            for(int y = 0; y < 2; y++) {
                ansFinal[x][y] = ans[x][y];
            }
        }
        
        return ansFinal;
    }
}
