/*Adding a Task at a Specific Position

You are developing a task tracker for a project where tasks are assigned unique IDs. These tasks are arranged in a linked list, based on the order in which they need to be completed. Sometimes, a new task needs to be inserted at a specific position in the list, ensuring it is prioritized correctly. Your task is to write a program to insert a new task at a given position in the task list and print the updated list after the insertion.

Write a program that inserts a new task (represented by a unique task ID) at a specific position in the task list. After the insertion, print the updated list of task IDs. If the entered position value is out the range, print the message as “Position out of range”.



Input Format

The first line contains an integer N, the number of task IDs initially added to the linked list.

The second line contains N space-separated integers representing the task IDs.

The third line contains an integer P, the position at which the new task ID should be inserted (1-based index).

The fourth line contains an integer M, the new task ID to be inserted.



Output Format

Print the updated task list with the elements separated by a space.



Constraints

NA



Sample Input

4

101 102 103 104

2

999



Sample Output

101 999 102 103 104



Explanation

The task list is initialized with 4 task IDs: 101 102 103 104. The new task ID 999 is inserted at position 2 (between 101 and 102). The updated list after insertion is 101 999 102 103 104. */
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class AddingATaskAtASpecificPosition {
    public static Node insertAtPosition(Node head, int position, int value) {
        if (position < 1) {
            System.out.println("Position out of range");
            return head;
        }

        Node newNode = new Node(value);

        if (position == 1) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of range");
            return head;
        }

        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int p = scanner.nextInt();
    }
}