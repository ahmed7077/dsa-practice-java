/*Order Processing System
Imagine you're developing a restaurant food ordering system where customers place orders, and these orders are processed in a first-in-first-out (FIFO) manner. This system should allow new orders to be added to the queue, the next order to be served (processed), and the system to show which order is next in line. You are tasked with implementing the system using two stacks, as your data structure only allows stack operations.

You are required to implement a queue-like structure using two stacks. This system must handle the following operations:

Add new order: Whenever a customer places a new order, it should be added to the back of the queue.
Process the next order: When the restaurant is ready to serve, it should remove and process the order from the front of the queue.
Peek the next order: The restaurant staff should be able to see which order is next without removing it.
Check if the queue is empty: The system should check whether there are any pending orders.
Your task is to implement a Main class that mimics a FIFO queue using two stacks and supports the following operations:

push(int order) – Adds a new order to the back of the queue.
pop() – Removes the front order and returns it.
peek() – Returns the front order without removing it.
empty() – Checks if the queue is empty, returning true if there are no orders and false otherwise.


Input Format

The first line contains the number of operations to be performed.
Each subsequent line specifies one operation like push, pop, peek, or empty.


Output Format

For push: Print the order number added.
For pop: Print the order processed (removed from the front).
For peek: Print the order number at the front of the queue.
For empty: Print true if the queue is empty, false otherwise.


Sample Input

6

push 101

push 102

peek

pop

peek

empty



Sample Output

Order added: 101

Order added: 102

Next order: 101

Order processed: 101

Next order: 102

Is queue empty: false



Explanation

push 101: Adds order 101 to the queue. Queue state: [101].
push 102: Adds order 102 behind 101. Queue state: [101, 102].
peek: Returns the front order (101), which is the next to be processed.
pop: Removes and processes order 101, leaving the queue with [102].
peek: Now the front order is 102.
empty: The queue still has one order, so the result is false. */
import java.util.*;

public class OrderProcessingSystem {

    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    static void push(int x) {
        s1.push(x);
        System.out.println("Order added: " + x);
    }

    static int pop() {
        shift();
        return s2.pop();
    }

    static int peek() {
        shift();
        return s2.peek();
    }

    static boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    static void shift() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            switch (parts[0]) {

                case "push":
                    int val = Integer.parseInt(parts[1]);
                    push(val);
                    break;

                case "pop":
                    System.out.println("Order processed: " + pop());
                    break;

                case "peek":
                    System.out.println("Next order: " + peek());
                    break;

                case "empty":
                    System.out.println("Is queue empty: " + empty());
                    break;
            }
        }
    }
}