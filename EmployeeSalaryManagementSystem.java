/*Employee Salary Management System

Imagine you are a software developer for a mid-sized company that has several employees. Each employee has a unique Employee ID that ranges from 100 to 999. The company needs to manage and store the salaries of these employees efficiently. The HR department frequently queries the salaries of employees based on their Employee IDs.

To manage the data efficiently, you decide to use a Hash Table with a simple hash function to store the salaries based on the Employee ID. The hash function helps you to quickly find an employee's salary using their Employee ID. This system will be used regularly by the HR department to ensure smooth payroll operations.



Input Format

The first line contains an integer n, the number of employees.
The next n lines contain two values: the employeeID and the salary.


Output Format

For each employee ID query, print their salary using the hash function. If the employeeID is not found, print "Employee not found."


Sample Input

3

101 5000

205 4500

310 6000

2

101

400



Sample Output

5000

Employee not found



Explanation

The first input 3 means there are 3 employees.
Next, for each employee:
Employee ID 101 has a salary of $5000.
Employee ID 205 has a salary of $4500.
Employee ID 310 has a salary of $6000.
After storing these employee salaries, the program reads 2, meaning there are two queries.
The first query asks for Employee ID 101, and the system returns 5000.
The second query asks for Employee ID 400, which is not in the system, so the system returns "Employee not found." */

import java.util.HashMap;
import java.util.Scanner;

public class EmployeeSalaryManagementSystem {
    private static HashMap<Integer, Integer> salaryMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of employees
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Input employee IDs and salaries
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            int employeeID = Integer.parseInt(parts[0]);
            int salary = Integer.parseInt(parts[1]);
            salaryMap.put(employeeID, salary);
        }

        // Number of queries
        int q = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Process queries
        for (int i = 0; i < q; i++) {
            String line = scanner.nextLine();
            int employeeID = Integer.parseInt(line);

            if (salaryMap.containsKey(employeeID)) {
                System.out.println(salaryMap.get(employeeID));
            } else {
                System.out.println("Employee not found.");
            }
        }

        scanner.close();
    }
}