/*Security Camera Image Processing System

A security system captures images of an area in a binary format using a grid of pixels, where 1 represents a white pixel (presence of light) and 0 represents a black pixel (absence of light). The images are used to monitor and analyze the area for unusual activity.

However, to simplify the analysis, the system needs to process each image in two steps:

Flip the Image Horizontally: Reverse each row of the image.
Invert the Image: Replace each 0 with 1 and each 1 with 0.
Write a program to process the images using the described operations and return the modified images.



Input Format

The first line contains an integer n, representing the dimensions of the square image matrix.
The next n lines contain n binary integers (0 or 1) each, representing the pixel values of the image.


Output Format

Output the modified image matrix after flipping and inverting.


Sample Input

3

1 1 0

1 0 1

0 0 0



Sample Output

1 0 0

0 1 0

1 1 1

Explanation

Original Image

1 1 0

1 0 1

0 0 0

Step 1 - Flip Horizontally

Row 1: [1, 1, 0] -> [0, 1, 1]

Row 2: [1, 0, 1] -> [1, 0, 1]

Row 3: [0, 0, 0] -> [0, 0, 0]

Result after flipping:



0 1 1

1 0 1

0 0 0

Step 2 - Invert

Row 1: [0, 1, 1] -> [1, 0, 0]

Row 2: [1, 0, 1] -> [0, 1, 0]

Row 3: [0, 0, 0] -> [1, 1, 1]

Result after inverting:



1 0 0

0 1 0

1 1 1 */
import java.util.*;
class SecurityCameraImageProcessing{
  public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[][] A=new int[n][n];
    for (int i=0;i<n;i++)
      for (int j=0;j<n;j++)
        A[i][j]=sc.nextInt();
    for (int i=0;i<n;i++){
      for (int j=n-1;j>-1;j--)
          System.out.print(1-A[i][j]+" ");
      System.out.println();
    }
  }
}