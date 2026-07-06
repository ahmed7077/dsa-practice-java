/*Task ID Management System

You are developing a simple task management application where tasks are represented by unique IDs. Users can add new tasks at the beginning of the task list for quick access.

You need to write a program to insert each given task ID at the beginning of a linked list one by one. After all insertions are completed, the final list of task IDs should be printed to confirm the additions.



Input Format

The first line contains an integer N, the number of task IDs to be initially added to the linked list.
The second line contains N space-separated integers representing the task IDs.


Output Format

After completing all insertions, print the current linked list with elements separated by a space.



Sample Input 1

5

201 202 203 204 205



Sample Output 1

205 204 203 202 201



Explanation

Initially the linked list is empty. The first task ID 201 is inserted at the beginning, and the list becomes 201. The second task ID 202 is inserted at the beginning, and the list becomes 202 201. The third task ID 203 is inserted at the beginning, and the list becomes 203 202 201. The fourth task ID is inserted at the beginning, and the list becomes 204 203 202 201. The fifth task ID is inserted at the beginning, and the list becomes 205 204 203 202 201. */
import java.util.*;
class Node{
  int data;
  Node next;
  Node(int data){
    this.data=data;
    this.next=null;
  }
}
public class TaskIdManagementSystem{
  static Node insertAtBeginning(Node head, int data){
    Node newNode= new Node(data);
    newNode.next=head;
    return newNode;
  }
  public static void printList(Node head){
    Node current=head;
    while (current!=null){
      System.out.print(current.data+" ");
      current=current.next;
    }
    System.out.println();
  }
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Node head=null;
    for (int i=0;i<n;i++){
      int taskId=sc.nextInt();
      head=insertAtBeginning(head,taskId);
    }
    printList(head);
  }
}