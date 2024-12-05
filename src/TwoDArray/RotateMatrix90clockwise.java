package TwoDArray;
/* 3*3 matrix - 0-2 index
 * 00 -> 02, 01-> 12, 02-> 22
 * 10->01 , 11-> 11, 12-> 21
 * 20 -> 00, 21-> 10, 22-> 20
 * 
 * we need to move mat[i][j] to mat[j][n-i-1].
 * We first move elements in a temporary matrix, then copy the temporary to the original - O(n^2) and time and space.
 */

/*second approach - transpose and then reverse rows for clockwise 90.
 *  transpose and reverse columns for anticlockwise 90
 *  1  2  3					 1  4  7						 7  4  1
 *  4  5  6   —Transpose->   2  5  8     —-Reverse rows—->   8  5  2
 *  7  8  9                  3  6  9                         9  6  3
 */

public class RotateMatrix90clockwise {
	
	public static void main(String[] args) {
		int a[][] = { {1, 2, 3}, {4, 5, 6}, {7,8,9} };
		rotate90(a);
		rotate90viaTransposeAndReverse(a);

        // Print the rotated matrix
        for (int[] row : a) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
	}
	
	static void rotate90(int[][] mat) {
        int n = mat.length;

        int[][] res = new int[n][n]; // Initialize the result matrix with zeros

        for (int i = 0; i < n; i++) { // Flip the matrix clockwise using nested loops
            for (int j = 0; j < n; j++) {
                res[j][n - i - 1] = mat[i][j];
            }
        }

        for (int i = 0; i < n; i++) { // Copy result back to mat
            System.arraycopy(res[i], 0, mat[i], 0, n);
        }
    }
	
	static void rotate90viaTransposeAndReverse(int[][] mat) {
		int n = mat.length;
		// Perform Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;
            while (start < end) {
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }
    }

}
