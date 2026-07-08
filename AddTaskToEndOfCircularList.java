/*Adding a Task to the End of a Circular To-Do List

You are developing a task management system where tasks are stored in a circular to-do list. Each task is represented by a unique task ID. The circular nature of the list allows users to loop through their tasks continuously. Your task is to write a program that inserts a new task at the end of the circular linked list and prints the updated list of task IDs.

Write a program to append a new task (represented by a unique task ID) to the end of the singly circular linked list representing the to-do list. After the insertion, print the updated list of task IDs by traversing the list once starting from the head.



Input Format

The first line contains an integer N, the number of initial tasks in the to-do list.

The second line contains N space-separated integers representing the task IDs.



Output Format

Print the updated list of task IDs in sequence from the head of the list, traversing the circular list once.



Constraints

The input values are all positive integers.

There will be at least one task initially in the to-do list.



Sample Input

4

101 102 103 104



Sample Output

101 102 103 104



Explanation

The circular linked list is initially empty, and the first task with ID 101 is inserted, making it the head, pointing to itself. The second task ID 102 is inserted at the end, and the last node 101 now points to 102, which points back to the head. The third task ID 103 is added, with the last node 102 pointing to 103, and 103 pointing back to 101. The fourth task ID 104 is inserted at the end, with 103 pointing to 104, and 104 in turn points back to the head 101. */
import java.util.*;
class Node{
  int data;
  Node next;
  Node(int data){
    this.data=data;
    this.next=null;
  }
}
class AppendingBookToLibraryCatalog{
  static Node insertAtEnd(Node head, int data){
    Node newNode=new Node(data);
    if(head==null){
      head=newNode;
      newNode.next=head;
      return newNode;
    }
    Node temp=head;
    while(temp.next!=head)
      temp=temp.next;
    temp.next=newNode;
    newNode.next=head;
    return head;
  }
  static void display(Node head){
    Node temp=head;
    do{
      System.out.print(temp.data+" ");
      temp=temp.next;
    }
      while(temp!=head);
  }
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Node head=null;
}
}