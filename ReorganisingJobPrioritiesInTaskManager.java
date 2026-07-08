/*Reorganizing Job Priorities in a Task Manager
Imagine you're using a task manager application that keeps a list of jobs scheduled for execution. Each job has a priority, and they are arranged in a list based on when they were added. Due to certain changes in requirements, you need to swap the priority of a specific job (at a given position from the start) with another job that is located the same distance from the end of the list.

For example, if the task at position k = 2 from the beginning needs to be swapped with the task at position k = 2 from the end, this will ensure that important tasks can move up or down based on their urgency.

Swap the job at the k-th position from the start of the list with the k-th position from the end.



Input Format

The first line contains a list of integers (or job IDs) representing the task list in the task manager.

The second line contains an integer k, representing the position of the task to swap from both the start and the end.



Output Format

The output is a list of job IDs where the k-th job from the start and the k-th job from the end have been swapped.



Sample Input

5

1 2 3 4 5

2



Sample Output

1 4 3 2 5



Explanation

 The job list [1, 2, 3, 4, 5] and k = 2. Swap the second task from the start (Job 2) with the second task from the end (Job 4). After swapping, the list becomes [1, 4, 3, 2, 5]. */
 import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReorganisingJobPrioritiesInTaskManager {
    public static Node swapKthNodes(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        if (k > length) {
            return head;
        }

        if (2 * k - 1 == length) {
            return head;
        }

        Node x = head;
        Node xPrev = null;
        for (int i = 1; i < k; i++) {
            xPrev = x;
            x = x.next;
        }

        Node y = head;
        Node yPrev = null;
        for (int i = 1; i < length - k + 1; i++) {
            yPrev = y;
            y = y.next;
        }

        if (xPrev != null) {
            xPrev.next = y;
        } else {
            head = y;
        }

        if (yPrev != null) {
            yPrev.next = x;
        } else {
            head = x;
        }

        Node temp = x.next;
        x.next = y.next;
        y.next = temp;

        return head;
    }
}