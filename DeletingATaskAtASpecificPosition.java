/*Deleting Tasks in a Task Management System
You are developing a task management application where tasks are represented by unique IDs. Users can delete tasks from the beginning of the task list to quickly remove the most urgent tasks. You need to write a program to handle the deletion of task IDs from the beginning of a linked list. After all deletions are completed, the final list of task IDs should be printed to confirm that the tasks have been removed.

Write a program to delete task IDs from the beginning of the linked list. After all deletions, print the entire linked list to show the updated list of task IDs. If the list is empty, Print the message as “List is empty”.



Input Format

The first line contains an integer N, the number of task IDs to be initially added to the linked list.

The second line contains N space-separated integers representing the task IDs.

The third line contains an integer M, the number of tasks to be deleted from the beginning.



Output Format

After completing all deletions, print the current linked list with elements separated by a space.



Example 1

Sample Input 1

5

301 302 303 304 305

3



Sample Output 1

304 305



Explanation

The linked list is initialized with 5 task IDs: 301 302 303 304 305. After the first deletion, the task ID 301 is removed. After the second deletion, the task ID 302 is removed. After the third deletion, the task ID 303 is removed. Finally, the linked list becomes 304 305.



Example 2

Sample Input 2

1

999

1



Sample Output 2

List is empty



Explanation

The linked list is initialized with a single task ID: 999.Since there is only one task in the list (999), deleting this single task will make the list empty.After performing the deletion, the list becomes empty.So that as per program's requirement print "List is empty". */
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeletingATaskAtASpecificPosition {
    public static Node deleteFromBeginning(Node head, int m) {
        for (int i = 0; i < m; i++) {
            if (head == null) {
                break;
            }
            head = head.next;
        }
        return head;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}