/*Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
In a UNIX-style file system, a period '.' refers to the current directory. Furthermore, a double period '..' moves the directory up a level.
Note that the returned canonical path must always begin with a slash '/', and there must be only a single slash '/' between two directory names. 
The last directory name (if it exists) must not end with a trailing '/'. 
Also, the canonical path must be the shortest string representing the absolute path.*/


class Solution {
    public String simplifyPath(String path) {
        //Create a stack
        Stack<String> stack=new Stack<>();
        //Create a string array called p. Use .split() function
        //to split the String path into a string array after removing the delimiter "/"
        //The .split() method removes "//" too
        String[] p=path.split("/");
        //Run a loop to check each element of the string array.
        for(int i=0;i<p.length;i++){
            //Check if the stack is not empty and ".." is present, 
            //then pop the previous element.
            if(!stack.empty() && p[i].equals(".."))
                stack.pop();
            //If the element is not .. or . or empty, then push it in the stack.
            else if(!p[i].equals("..") && !p[i].equals(".") && !p[i].equals(""))
                stack.push(p[i]);
        }
        //Create a list by taking the stack as the argument. 
        //The elements of stack form the list.
        List<String> list=new ArrayList(stack);
        return "/"+String.join("/",list);
    }
}
