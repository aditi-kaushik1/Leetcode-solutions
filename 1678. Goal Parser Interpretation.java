class Solution {
    public String interpret(String command) {
        int i = 0;
        String answer = "";
        int len = command.length();
        while(i != len) {
            if(command.charAt(i) == 'G') {
                answer += 'G';
                i++;
            }

            else if(command.charAt(i) == '(' && command.charAt(i + 1) == ')') {
                answer += 'o';
                i += 2;
            }

            else {
                answer += "al";
                i += 4;
            }
        }
        return answer;
    }
}
