/*Removing the Last Book from a Library Catalog

You are building a digital library system where each book is represented by a unique book ID. The library catalog is stored as a doubly linked list, allowing users to navigate through the list of books. Occasionally, books are removed from the library, and when a book is removed from the end of the catalog, it should no longer appear in the list. Your task is to write a program that deletes the last book from the catalog and prints the updated list of book IDs.

Write a program to delete the last book from the doubly linked list representing the library catalog. After the deletion, print the updated list of book IDs. If the list is empty, Print the message as “List is empty”.



Input Format

The first line contains an integer N, the number of books initially in the catalog.

The second line contains N space-separated integers representing the book IDs.



Output Format

Print the updated list of book IDs in sequence from the start to the end of the catalog after the last book has been removed.



Constraints

The input values are all positive integers.

There will be at least 1 book in the catalog initially.



Example 1

Sample Input 1

5

101 102 103 104 105



Sample Output 1

101 102 103 104



Explanation

The catalog is initialized with 5 book IDs: 101 102 103 104 105. The last book ID 105 is removed from the end of the catalog. The updated list after deletion is 101 102 103 104.



Example 2

Sample Input 2

1

701



Sample Output 2

List is empty



Explanation

The catalog initially contains one book ID: 701. After removing the last book (701), the list becomes empty.So the output will be "List is empty" */
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

public class RemovingLastBookFromLibraryCatalog {
    public static Node deleteFromEnd(Node head, Node tail) {
        if (head == null) {
            return null;
        }

        if (head == tail) {
            return null;
        }

        Node newTail = tail.prev;
        if (newTail != null) {
            newTail.next = null;
        }
        tail.prev = null; 

        return newTail;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
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
                newNode.prev = tail;
                tail = newNode;
            }
        }

        tail = deleteFromEnd(head, tail);
        
        if (tail == null) {
            head = null;
        }

        printList(head);
        
        scanner.close();
    }
}