/*Product ID Insertion in Inventory
You are working on a real-time inventory management system where you need to maintain a list of product IDs in a linked list. As new products are added to the inventory, their IDs are appended at the end of the list. You have been tasked with writing a program to handle this operation.

Write a program to insert a new product ID at the end of the linked list. After the completion of insertion, print the entire linked list to confirm that the new ID has been added.



Input Format

The first line contains an integer N, the number of product IDs to be initially added to the linked list.

The second line contains N space-separated integers, representing the product IDs.



Output Format

After inserting the product ID, print the current linked list, with elements separated by a space.



Sample Input

5

101 102 103 104 105



Sample Output

101 102 103 104 105



Explanation

Initially the linked list is empty. The first product ID 101 is inserted at the end, and the list becomes 101. The second product ID 102 is inserted at the end, and the list becomes 101 102. The third product ID 103 is inserted at the end, and the list becomes 101 102 103. The fourth product ID 104 is inserted at the end, and the list becomes 101 102 103 104. The fifth product ID 105 is inserted at the, and the list becomes 101 102 103 104 105. */
import java.util.*;
class Node{
  int data;
  Node next;
  Node(int data){
    this.data=data;
    this.next=null;
  }
}
class ProductIdInsertion{
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
  static void display(Node head){
    Node temp=head;
    while (temp!=null){
      System.out.print(temp.data+" ");
      temp=temp.next;
    }
  }
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Node head=null;
    for (int i=0;i<n;i++)
      head=insertAtEnd(head,sc.nextInt());
    display(head);
  }
}