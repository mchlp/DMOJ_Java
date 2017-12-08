import java.util.Scanner;
import java.util.Stack;


public class IOI94p1v3 {
    static public class Tuple {
        public final int row;
        public final int col;
        public Tuple(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numRow = in.nextInt();

        int[][] sums = new int[numRow][numRow];
        int[][] numbers = new int[numRow][numRow];

        for (int i = 0; i < numRow; i++) {
            int[] singleLine = new int[numRow];
            int[] singleSum = new int[numRow];
            for (int j = 0; j < i + 1; j++) {
                singleLine[j] = in.nextInt();
                singleSum[j] = 0;
            }
            numbers[i] = singleLine;
            sums[i] = singleSum;
        }

        for(int i=0; i< numRow; i++) {
            for (int j = 0; j <= i; j++) {
                int sum = 0;
                if (i == 0 && j == 0) {
                    sum = numbers[i][j];
                } else if (j == 0) {
                    sum = sums[i - 1][j] + numbers[i][j];
                } else {
                    sum = Math.max(sums[i - 1][j], sums[i - 1][j - 1]) + numbers[i][j];
                }

                System.out.print(sum);
                System.out.print("\t");
                sums[i][j] = sum;
                if (sum > maxnum) {
                    maxnum = sum;
                }
            }
            System.out.println(" ");
        }

        System.out.println(maxnum);
    }

    public static  int maxnum = 0;
}
