class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        int mid = 0;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(mid * mid == num)
                return true;
            else if(mid > num/mid)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}
