/*Removing a Task from a Specific Position

You are building a task tracker for project management, where each task is represented by a unique ID and tasks are stored in the order they need to be completed. Sometimes, due to changes in project priorities, certain tasks need to be removed from the list based on their position. Your task is to write a program that deletes a task at a specified position from the list and prints the updated list of remaining tasks.

Write a program that deletes a task (represented by a unique ID) from a given position in the linked list. After the deletion, print the updated list of task IDs. If the list is empty, Print the message as “List is empty”. If the entered position value is out the range, print the message as “Position out of range”.



Input Format

The first line contains an integer N, the number of task IDs initially added to the linked list.

The second line contains N space-separated integers representing the task IDs.

The third line contains an integer P, the position of the task to be deleted (1-based index).



Output Format

Print the updated task list with the elements separated by a space.



Constraints

The value of P will always be between 1 and N (both inclusive).



Example1

Sample Input

5

101 102 103 104 105

3



Sample Output

101 102 104 105



Explanation

The task list is initialized with 5 task IDs: 101 102 103 104 105. The task at position 3 (103) is removed from the list. The updated list after deletion is 101 102 104 105.



Example 2

Sample Input 2

0

1



Sample Output 2

List is empty



Explanation

The task list is initially empty. Attempting to delete at position 1 returns "List is empty"



Example 3

Sample Input 3

2

701 702

3



Sample Output 3

Position out of range



Explanation

The task list contains 2 IDs: 701, 702. Position 3 is out of range, so the message "Position out of range" is printed. */
import java.util.*;
class Node{
  int data;
  Node next;
  Node(int data){
    this.data=data;
    this.next=null;
  }
}
class RemovingTaskFromSpecificPosition{
  static Node insertAtEnd(Node head,int data){
    Node newNode=new Node(data);
    if (head==null)
      return newNode;
    Node temp=head;
    while (temp.next!=null)
      temp=temp.next;
    temp.next=newNode;
    return head;
  }
  static Node deletePos(Node head,int pos,int n){
    if(head==null)
      return null;
    if (pos==1)
      return head.next;
    Node temp=head;
    for (int i=1;temp!=null&&i<pos-1;i++)
      temp=temp.next;
    temp.next=temp.next.next;
    return head;
  }
  static void display(Node head){
    Node temp=head;
    while (temp!=null){
      System.out.print(temp.data+" ");
      temp=temp.next;
}
  }
}