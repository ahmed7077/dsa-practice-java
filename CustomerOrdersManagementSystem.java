/*Customer Orders Management System
Imagine you are a software developer working for a large e-commerce company, similar to Amazon or Flipkart, where customers place thousands of orders every day. Each order is assigned a unique identifier, called an Order ID. The company needs an efficient system to manage and retrieve customer details based on these Order IDs.

Your task is to develop a Customer Orders Management System that stores customer names associated with their unique Order IDs and allows the customer support team to quickly retrieve a customer’s name using the Order ID.

This system will be used by the customer support team to answer inquiries related to customers' orders. When customers call or email asking about their orders, the support team will query the system by providing the Order ID, and the system should instantly return the customer’s name. If the Order ID is not valid or the order was never placed, the system should respond with "Order not found."

To handle these operations efficiently, you decide to implement a Direct Address Table, where each index represents an Order ID, and the value stored at that index is the customer's name.



Input Format


The first line contains an integer n, the number of orders.
The next n lines contain two values: the orderID (0 ≤ orderID ≤ 1000) and the customerName.


Output Format

For a given list of queries, print the customer name corresponding to the queried orderID. If the order ID is invalid or not found, print "Order not found."


Sample Input

3

100 Alice

101 Bob

300 Charlie

2

100

200



Sample Output

Alice

Order not found



Explanation

The first input 3 means there are 3 orders.
Next, for each order:
Order ID 100 is linked to Alice.
Order ID 101 is linked to Bob.
Order ID 300 is linked to Charlie.
After storing these orders, the program reads 2, meaning there are two queries.
The first query asks for Order ID 100, and the system returns "Alice".
The second query asks for Order ID 200, which is not in the system, so the system returns "Order not found." */
import java.util.Scanner;

public class CustomerOrdersManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); 
        String[] directAddressTable = new String[1001];
        for (int i = 0; i < n; i++) {
            int orderID = scanner.nextInt();
            scanner.nextLine();
            String customerName = scanner.nextLine();
            directAddressTable[orderID] = customerName;
        }
        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            int orderID = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (orderID >= 0 && orderID <= 1000) {
                String customerName = directAddressTable[orderID];
                if (customerName != null) {
                    System.out.println(customerName);
                } else {
                    System.out.println("Order not found.");
                }
            } else {
                System.out.println("Order ID out of range.");
            }
        }

        scanner.close();
    }
}