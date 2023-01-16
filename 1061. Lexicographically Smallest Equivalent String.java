/* You are given two strings of the same length s1 and s2 and a string baseStr.

We say s1[i] and s2[i] are equivalent characters.

For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
Equivalent characters follow the usual rules of any equivalence relation:

Reflexivity: 'a' == 'a'.
Symmetry: 'a' == 'b' implies 'b' == 'a'.
Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.

Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.

 

Example 1:

Input: s1 = "parker", s2 = "morris", baseStr = "parser"
Output: "makkek"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
The characters in each group are equivalent and sorted in lexicographical order.
So the answer is "makkek".
Example 2:

Input: s1 = "hello", s2 = "world", baseStr = "hold"
Output: "hdld"
Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [h,w], [d,e,o], [l,r].
So only the second letter 'o' in baseStr is changed to 'd', the answer is "hdld".
Example 3:

Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
Output: "aauaaaaada"
Explanation: We group the equivalent characters in s1 and s2 as [a,o,e,r,s,c], [l,p], [g,t] and [d,m], thus all letters in baseStr except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".
 

Constraints:

1 <= s1.length, s2.length, baseStr <= 1000
s1.length == s2.length
s1, s2, and baseStr consist of lowercase English letters. */

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        /*
        l<=>p
        e<=>r<=>o<=>a<=>s<=>c
        t<=>g
        c<=>r
        d<=>m
        */
        Map<Character, List<Character>> adjacencyList = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(ch1 == ch2)
                continue;
            if(adjacencyList.containsKey(ch1)) {
                List<Character> currentList = adjacencyList.get(ch1);
                if(!currentList.contains(ch2))
                    currentList.add(ch2);
            }
            else {
                List<Character> list = new ArrayList<>();
                list.add(ch2);
                adjacencyList.put(ch1, list);
            }

            if(adjacencyList.containsKey(ch2)) {
                List<Character> currentList = adjacencyList.get(ch2);
                if(!currentList.contains(ch1))
                    currentList.add(ch1);
            }
            else {
                List<Character> list = new ArrayList<>();
                list.add(ch1);
                adjacencyList.put(ch2, list);
            }
        }
        String answer = "";
        for(char ch : baseStr.toCharArray()) {
            visited = new boolean[26];
            traverse(adjacencyList, ch, visited);
            int retint=ch-'a';
            for(int i=0; i<26; i++) {
                if(visited[i] == true) {
                    retint=i;
                    break;
                }
            }
            
            retint+='a';
            char what=(char)retint;
            answer += what;
        }
        return answer;
    }
    
    boolean[] visited;

    public void traverse(Map<Character, List<Character>> adjacencyList, char ch, boolean[] visited) {
        visited[ch -'a'] = true;

        List<Character> list = adjacencyList.get(ch);
        if(list==null)return;
        for(int i = 0; i < list.size(); i++) {
            if(visited[list.get(i)-'a'] == true)
                continue;
            visited[list.get(i) - 'a'] = true;
            traverse(adjacencyList, list.get(i), visited);
        }
    }
}

// s1 = "parker", s2 = "morris"

/*
p->m
m->p
a->o
o->a
r->k, s
k->r
e->i
i->e
r->s
r->r
s->r
*/

/*
ac
bd
ce
ca
db
*/
