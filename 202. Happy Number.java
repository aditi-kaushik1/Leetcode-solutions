class Solution {
    public boolean isHappy(int n) {
        for(int i = 0; i < 10; i++) {
            int sum = 0;
            while(n != 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
        }
        if(n == 1)
            return true;
        return false;
    }
}
