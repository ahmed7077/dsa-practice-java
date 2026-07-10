/*Undo Operation in a Text Editor
In modern text editors, when users type text, they often need to reverse their actions, like performing an undo operation. This scenario demonstrates how we can simulate this functionality by reversing a string using a stack. The stack follows the Last In, First Out (LIFO) principle, making it ideal for tasks such as reversing the order of elements or undoing the most recent actions.

We will build a program where:

The user types a sentence.
The program simulates the undo operation by reversing the text using a stack.


Input Format

The user will enter a single line of text (a sentence) that they have "typed" in the text editor.


Output Format

The program will display the reversed version of the input sentence, simulating the result of an undo operation.


Sample Input

Welcome to the coding world



Sample Output

dlrow gnidoc eht ot emocleW



Explanation

The user types the sentence "Welcome to the coding world". The program pushes each character of the string onto a stack: W, e, l, c, o, m, e, , t, o, , t, h, e, , c, o, d, i, n, g, , w, o, r, l, d.

Using the LIFO principle, when the program pops each character from the stack, it retrieves the characters in reverse order.

The output shows the sentence reversed: dlrow gnidoc eht ot emocleW. */
import java.util.Scanner;

class CustomStack {
    private char[] arr;
    private int top;
    private int capacity;

    public CustomStack(int size) {
        capacity = size;
        arr = new char[capacity];
        top = -1;
    }

    public void push(char c) {
        if (top == capacity - 1) {
            return;
        }
        arr[++top] = c;
    }

    public char pop() {
        if (top == -1) {
            return '\0';
        }
        return arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class UndoOperationInATextEditior {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        int n = 0;
        while (n < input.length()) {
            n++;
        }

        CustomStack stack = new CustomStack(n);

        for (int i = 0; i < n; i++) {
            stack.push(input.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        System.out.println(reversed);
        
        scanner.close();
    }
}