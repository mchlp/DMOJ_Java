import java.util.*;


public class IOI94p1v2 {
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
            int[] singleLine = new int[i + 1];
            int[] singleSum = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                singleLine[j] = in.nextInt();
                singleSum[j] = 0;
            }
            numbers[i] = singleLine;
            sums[i] = singleSum;
        }

        Stack<Tuple> path = new Stack<Tuple>();
        Tuple first = new Tuple(0,0);
        sums[first.row][first.col] = numbers[first.row][first.col];
        maxnum = numbers[first.row][first.col];
        path.push(first);

        deepNavigate(numbers, sums, path, first, numRow-1);
        calcMax(numbers, sums, path, numRow-1);
        System.out.println(maxnum);
    }

    public static void deepNavigate(int[][]numbers, int[][] sums, Stack<Tuple> path, Tuple currPath, int bottomRow){
        for(int i=currPath.row+1; i<=bottomRow; i++){
            int sum = sums[i-1][currPath.col] + numbers[i][currPath.col];
            if (sum > sums[currPath.row][currPath.col]){
                sums[i][currPath.col] = sum;
                if (sum > maxnum){maxnum = sum;}
            }

            path.push(new Tuple(i, currPath.col));
        }
    }

    public static void calcMax(int[][] numbers, int[][] sums, Stack<Tuple> path, int bottomRow){
        int maxSum = 0;
        while (path.size() > 1) {
            Tuple curLoc = path.pop();
            Tuple prevLoc = path.peek();

            if(curLoc.col == prevLoc.col){
                Tuple rightLoc = new Tuple(curLoc.row, curLoc.col + 1);
                int sum = sums[prevLoc.row][prevLoc.col] + numbers[rightLoc.row][rightLoc.col];
                if (sum > sums[rightLoc.row][rightLoc.col]){
                    sums[rightLoc.row][rightLoc.col] = sum;
                    if (sum > maxnum){maxnum = sum;}
                }
                path.push(rightLoc);

                deepNavigate(numbers, sums, path, rightLoc, bottomRow);
            }
        }
    }

    public static  int maxnum = 0;
}
