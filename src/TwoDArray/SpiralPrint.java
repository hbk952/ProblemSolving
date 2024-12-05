package TwoDArray;

import java.util.ArrayList;

public class SpiralPrint {

	public static void main(String[] args) {
		int a[][] = {{1,3,5},
				{10,11,16},
				{23,30,34}
				};
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int row = a.length;
		int col = a[0].length;

        int top = 0, left = 0, bottom = row - 1, right = col - 1;

        // Loop until all elements are not traversed.
        while (top <= bottom && left <= right) {

            // For moving left to right
            for (int i = left; i <= right; i++)
                ans.add(a[top][i]);

            top++;

            // For moving top to bottom.
            for (int i = top; i <= bottom; i++)
                ans.add(a[i][right]);

            right--;

            // For moving right to left.
            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    ans.add(a[bottom][i]);

                bottom--;
            }

            // For moving bottom to top.
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(a[i][left]);

                left++;
            }
        }
        ans.stream().forEach(System.out:: print);
	}

}
