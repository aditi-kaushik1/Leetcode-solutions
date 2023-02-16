class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        boolean flag = false;
        if((coordinates[1][0] - coordinates[0][0]) == 0)
            flag = true;
        double slope = (double)(coordinates[1][1] - coordinates[0][1])/(coordinates[1][0] - coordinates[0][0]);
        for(int i = 2; i < coordinates.length; i++) {
            if(flag == true && coordinates[i][0] - coordinates[0][0] != 0)
                return false;
            if(flag == true && coordinates[i][0] - coordinates[0][0] == 0)
                continue;
            if((double)(coordinates[i][1] - coordinates[0][1])/(coordinates[i][0] - coordinates[0][0]) != slope)
                return false;
        }
        return true;
    }
}
