/*Appending a Book to a Library Catalog
You are designing a digital library system where books are represented by unique book IDs. The library catalog is stored as a doubly linked list, allowing users to navigate both forwards and backwards through the list of books. When a new book is added to the library, it needs to be appended to the end of the catalog. Your task is to write a program that inserts a new book at the end of the catalog and prints the updated list of book IDs.

Write a program to append a new book (represented by a unique book ID) to the end of the doubly linked list representing the library catalog. After the insertion, print the updated list of book IDs.



Input Format

The first line contains an integer N, the number of books initially in the catalog.

The second line contains N space-separated integers representing the book IDs.



Output Format

Print the updated list of book IDs in sequence from the start to the end of the catalog.



Constraints

The input values are all positive integers.

There will be at least 1 book in the catalog initially.



Sample Input

4

201 202 203 204



Sample Output

201 202 203 204



Explanation

Initially, the catalog is empty. First, the new book ID 201 is appended to the end of the catalog. The list becomes 201. Then the second book ID 202 is appended to the end of the catalog, making the list 201 202. Next, the third book ID 203 is appended to the end of the catalog, updating the list to 201 202 203. Finally, the fourth book ID 204 is appended to the end of the catalog, resulting in the final list of book IDs: 201 202 203 204. */
import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class AppendingBookToLibraryCatalog {
    public static Node appendToEnd(Node head, Node tail, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
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
            if (head == null) {
                head = new Node(value);
                tail = head;
            } else {
                Node newNode = new Node(value);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        
        printList(head);
        
        scanner.close();
    }
}