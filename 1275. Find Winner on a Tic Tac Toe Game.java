class Solution {
    public String tictactoe(int[][] moves) {
        //Solution 1
        // int len = moves.length;
        // if(len < 5)
        //     return "Pending";
        // int countPrincipalDiagonal = 0;
        // int countReverseDiagonal = 0;
        // int countOf0 = 0;
        // int countOf1 = 0;
        // int countOf2 = 0;
        // int countsOf0 = 0;
        // int countsOf1 = 0;
        // int countsOf2 = 0;

        // for(int i = 0; i < moves.length; i+= 2) {
        //     if((moves[i][0] == 0 && moves[i][1] == 0) || (moves[i][0] == 1 && moves[i][1] == 1) || (moves[i][0] == 2 && moves[i][1] == 2))
        //         countPrincipalDiagonal++;
            
        //     if((moves[i][0] == 2 && moves[i][1] == 0) || (moves[i][0] == 1 && moves[i][1] == 1) || (moves[i][0] == 0 && moves[i][1] == 2))
        //         countReverseDiagonal++;
            
        //     if(moves[i][0] == 0)
        //         countOf0++;
        //     if(moves[i][0] == 1)
        //         countOf1++;
        //     if(moves[i][0] == 2)
        //         countOf2++;
            
        //     if(moves[i][1] == 0)
        //         countsOf0++;
        //     if(moves[i][1] == 1)
        //         countsOf1++;
        //     if(moves[i][1] == 2)
        //         countsOf2++;
        // }
        // if(countPrincipalDiagonal == 3 || countReverseDiagonal == 3 || countOf0 == 3 || countOf1 == 3 || countOf2 == 3 || countsOf0 == 3 || countsOf1 == 3 || countsOf2 == 3)
        //     return "A";
        // countPrincipalDiagonal = 0;
        // countReverseDiagonal = 0;
        // countOf0 = 0;
        // countOf1 = 0;
        // countOf2 = 0;
        // countsOf0 = 0;
        // countsOf1 = 0;
        // countsOf2 = 0;

        // for(int i = 1; i < moves.length; i+= 2) {
        //     if((moves[i][0] == 0 && moves[i][1] == 0) || (moves[i][0] == 1 && moves[i][1] == 1) || (moves[i][0] == 2 && moves[i][1] == 2))
        //         countPrincipalDiagonal++;
            
        //     if((moves[i][0] == 2 && moves[i][1] == 0) || (moves[i][0] == 1 && moves[i][1] == 1) || (moves[i][0] == 0 && moves[i][1] == 2))
        //         countReverseDiagonal++;

        //     if(moves[i][0] == 0)
        //         countOf0++;
        //     if(moves[i][0] == 1)
        //         countOf1++;
        //     if(moves[i][0] == 2)
        //         countOf2++;
            
        //     if(moves[i][1] == 0)
        //         countsOf0++;
        //     if(moves[i][1] == 1)
        //         countsOf1++;
        //     if(moves[i][1] == 2)
        //         countsOf2++;
        // }
        // if(countPrincipalDiagonal == 3 || countReverseDiagonal == 3 || countOf0 == 3 || countOf1 == 3 || countOf2 == 3 || countsOf0 == 3 || countsOf1 == 3 || countsOf2 == 3)
        //     return "B";

        // if(moves.length == 9)
        //     return "Draw";
        // else
        //     return "Pending";

        //Solution 2
        //Referred Solution : https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/solutions/441422/java-python-c-0ms-short-and-simple-all-8-ways-to-win-in-one-array/
        
        int[] A = new int[8];
        int[] B = new int[8];

        for(int i = 0; i < moves.length; i++) {
            int[] player = ((i % 2) == 0)? A: B;
            int r = moves[i][0];
            int c = moves[i][1];
            player[r]++;
            player[c + 3]++;
            if(r == c)
                player[6]++;
            if(r + c == 2)
                player[7]++;
        }

        for(int i = 0; i < 8; i++) {
            if(A[i] == 3)
                return "A";
            if(B[i] == 3)
                return "B";
        }

        return (moves.length == 9)?"Draw" : "Pending";
    }
}
