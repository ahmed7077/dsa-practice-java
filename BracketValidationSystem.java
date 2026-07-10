/*Smart Code Editor Bracket Validation System
You are part of a development team working on a smart code editor designed to help developers write efficient, error-free code. One of the most common issues that developers face is the incorrect use of brackets—parentheses (), square brackets [], and curly braces {}—which are critical for structuring code blocks, function calls, array declarations, and other programming constructs. Mismanaging brackets can lead to syntax errors such as unmatched or misplaced brackets, potentially causing compilation failures or unintended behavior in the code.

To enhance productivity and reduce errors, the code editor will include a Bracket Validation System as part of its real-time syntax checking feature. This system is responsible for automatically validating whether a string containing just the characters '(', ')', '{', '}', '[', and ']' is valid based on the following rules:

Every open bracket must be closed by the same type of bracket.
Open brackets must be closed in the correct order.
Every closing bracket must have a corresponding open bracket of the same type.
The string can represent any combination of code-related expressions, such as method invocations, block statements, and array initializations. The Bracket Validation System must ensure that the string is syntactically correct based on the proper pairing and nesting of these brackets.



Input Format

A single string s consisting of the characters '(', ')', '{', '}', '[', and ']'.


Output Format

Return true if the string is valid, meaning all brackets are properly matched and nested.
Return false if the string is invalid.


Example 1

Sample Input 1

()



Sample Output 1

true



Explanation

The string contains a valid pair of parentheses.



Example 2

Sample Input2

(]



Sample Output 2

false



Explanation

The string has mismatched parentheses and square brackets, making it invalid. */
import java.util.*;

public class BracketValidationSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            else {
                if (stack.isEmpty()) {
                    System.out.println(false);
                    return;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(stack.isEmpty());
    }
}