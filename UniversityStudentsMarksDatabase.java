/*University Student Marks Database

You are hired by the Registrar’s Office of a large university to develop an efficient system for managing student marks. Each student in the university has a unique Student ID ranging from 1 to 1000. Professors and administrators often need to input and retrieve student marks quickly, especially during exam season, when thousands of students are querying their grades.

To ensure that the system can handle this efficiently, you decide to implement a hash table to store student marks using a linear probing technique to handle collisions. The hash table will store student marks based on their Student ID, with the hash function defined as hash(ID) = ID / 100.



Input Format

The first line contains an integer n, the number of students.
The next n lines contain two values: the studentID and marks.


Output Format

For each student ID query, print their marks using linear probing. If the student ID is not found, print "Student not found."


Sample Input

5

101 85

202 90

305 78

206 88

107 92

3

101

107

500



Sample Output

85

92

Student not found



Explanation

Input:
The first input value 5 indicates that there are 5 students whose marks need to be stored.
The subsequent lines represent each student's Student ID and their Marks.
Student ID 101 has marks 85.
Student ID 202 has marks 90.
Student ID 305 has marks 78.
Student ID 206 has marks 88.
Student ID 107 has marks 92.
After the marks are stored, the program receives 3 queries:
Query for Student ID 101 returns the marks 85.
Query for Student ID 107 returns the marks 92 (after linear probing due to a collision at index 1).
Query for Student ID 500 returns "Student not found" because the ID is not in the system. */
import java.util.Scanner;
class Student
  {
    int id;
    int marks;
    Student(int id, int marks)
    {
      this.id=id;
      this.marks=marks;
    }
  }
public class UniversityStudentsMarksDatabase
  {
    public static void main(String args[])
    {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      Student table[]=new Student[20];
      for(int i=0;i<n;i++)
        {
          int id=sc.nextInt();
          int marks=sc.nextInt();
          int index=id/100;
          int start=index;
          while(table[index]!=null)
            {
              if(table[index].id==id)
              {
                table[index].marks=marks;
                break;
              }
              index=(index+1)%table.length;
              if(index==start) break;
            }
          if(table[index]==null)
            table[index]=new Student(id,marks);
                  
          }
      int q=sc.nextInt();
      for(int i=0;i<q;i++)
        {
          int searchId=sc.nextInt();
          int index=searchId/100;
          int start=index;
          boolean found=false;
          while(table[index]!=null)
            {
              if(table[index].id==searchId)
              {
                System.out.println(table[index].marks);
                found=true;
                break;
              }
              index=(index+1)%table.length;
              if(index==start)
                break;
            }
          if(!found)
            System.out.println("Student not found");
        }
    }
  }