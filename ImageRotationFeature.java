/*Image Rotation Feature
Imagine a photo editing application that allows users to edit and manipulate images. One of the features of this application is to rotate an image by 90 degrees clockwise. The image is represented as an n x n 2D matrix, where each element is a pixel value. Write a program to implement this feature and rotate the image in-place, meaning you have to modify the input matrix directly without using extra space.



Input Format

The first line contains an integer n, representing the dimensions of the square image matrix.
The next n lines contain n integers each, representing the pixel values of the image.


Output Format

Output the rotated image matrix.


Sample Input

3

1 2 3

4 5 6

7 8 9



Sample Output

7 4 1

8 5 2

9 6 3



Explanation

The original image matrix is:

1 2 3

4 5 6

7 8 9

After rotating the image by 90 degrees clockwise, the updated matrix becomes:

7 4 1

8 5 2

9 6 3 */
import java.util.*;
class ImageRotationFeature{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[][] A=new int[n][n];
    for (int i=0;i<n;i++)
      for (int j=0;j<n;j++)
        A[i][j]=sc.nextInt();
    for (int i=0;i<n;i++){
      for (int j=n-1;j>-1;j--){
        if (j>0)
          System.out.print(A[j][i]+" ");
        else
          System.out.print(A[j][i]);
      }
      System.out.println();
    }
  }
}