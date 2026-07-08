/*Finding the Critical Task in a Project Workflow

Imagine you are managing a long-term project with a series of tasks arranged in a linear sequence. Each task is dependent on the completion of the previous one, and the tasks are stored in a singly linked list. At certain points in the project, you want to identify the critical task, which lies in the middle of the task flow, so you can allocate additional resources to it and ensure timely completion.

In case there are two middle tasks, you want to focus on the second middle task as it represents the next crucial step in the project.

You are given the head of a singly linked list, where each node represents a task in a project workflow. Your task is to find and return the middle task. If the list has two middle tasks, return the second middle task and all the tasks after it.



Input Format

The input consists of a linked list represented by its head node.

Each node contains an integer value representing the task ID or any relevant information.



Output Format

The output will be a list of integers starting from the middle node to the end of the linked list.

If there are two middle nodes, the output should start from the second middle node.



Sample Input 1

5

1 2 3 4 5



Sample Output 1

3 4 5



Explanation

The list contains tasks with IDs: 1 -> 2 -> 3 -> 4 -> 5.

The total number of tasks is 5, and the middle task is task 3.

Since the list has an odd number of tasks, the function returns task 3 and all tasks following it (3 -> 4 -> 5).

Thus, task 3 is the critical point in the workflow, and the system returns the tasks starting from the middle node. */
import java.util.*;
class Node{
  int data;
  Node next;
  Node(int data){
    this.data=data;
    this.next=null;
  }
}
class  FindCriticalTaskInProjectWorkflow{
  static Node insertAtEnd(Node head,int data){
    Node newNode=new Node(data);
    if(head==null)
      return newNode;
    Node temp=head;
    while(temp.next!=null)
      temp=temp.next;
    temp.next=newNode;
    return head;
  }
  static Node findMiddle(Node head){
    Node slow=head;
    Node fast=head;
    while(fast!=null && fast.next!=null){
      slow=slow.next;
      fast=fast.next.next;
    }
    return slow;
  }
  static void display(Node head){
    Node temp=head;
    while(temp!=null){
      System.out.print(temp.data+" ");
      temp=temp.next;
    }
  }
}