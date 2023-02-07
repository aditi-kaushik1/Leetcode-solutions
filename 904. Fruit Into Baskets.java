class Solution {
    public int totalFruit(int[] fruits) {
        int currentNum = 0;
        int maxNum = 0;
        int firstTree = fruits[0];
        int secondTree = -1;
        int lastOccurenceOfFirstTree = -1;
        int lastOccurenceOfSecondTree = -1;
        int start = 0;
        int end = 0;
        int len = fruits.length;

        while(end < len && start <= end) {
            if(secondTree == -1 && fruits[end] != firstTree) {
                secondTree = fruits[end];
                lastOccurenceOfSecondTree = end;
                end++;
                currentNum++;
                maxNum = Math.max(currentNum, maxNum);
            }

            else if(fruits[end] == firstTree || fruits[end] == secondTree) {
                if(fruits[end] == firstTree)
                    lastOccurenceOfFirstTree = end;
                else
                    lastOccurenceOfSecondTree = end;
                currentNum++;
                maxNum = Math.max(currentNum, maxNum);
                end++;
                System.out.println("End is :" + end);
            }

            else {
                if(fruits[end - 1] == firstTree) {
                    while(start != lastOccurenceOfSecondTree) {
                        start++;
                    }
                    start++;
                    currentNum = end - start;
                    secondTree = fruits[end];
                }

                else {
                    while(start != lastOccurenceOfFirstTree) {
                        start++;
                    }
                    start++;
                    currentNum = end - start;
                    firstTree = fruits[end];
                }
            }
        }
        return maxNum;
    }
}
