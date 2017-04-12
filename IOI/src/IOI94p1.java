import java.util.*;

public class IOI94p1 {

    static Map<Integer, Integer> MEMO = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numRow = in.nextInt();
        int[][] lines = new int[numRow][numRow];
        for (int i=0; i < numRow; i++) {
            int[] intLine = new int[numRow];
            for (int j=0; j<i+1; j++) {
                intLine[j] = in.nextInt();
            }
            lines[i] = intLine;
        }
        System.out.println(get(0,0,numRow-1, lines));
        ArrayList list = new ArrayList(MEMO.keySet());
        Collections.sort(list);
        /*for (Object key:list) {
            System.out.println(key + " " + MEMO.get(key));
        }*/
    }

    public static int get(int row, int col,  int maxRow, int[][] lines) {
        int loc = row*1000+col;
        if (!MEMO.containsKey(loc)) {
            if (row == maxRow) {
                MEMO.put(loc, lines[row][col]);
            }
            else {
                int[] newLoc1 = {row+1, col};
                int[] newLoc2 = {row+1, col+1};
                if (!MEMO.containsKey(newLoc1)) {
                    get(newLoc1[0], newLoc1[1], maxRow, lines);
                }
                //if (col < row) {
                if (!MEMO.containsKey(newLoc2)) {
                    get(newLoc2[0], newLoc2[1], maxRow, lines);
                }

                int[] posNextRow = new int[2];
                posNextRow[0] = MEMO.get(newLoc1[0]*1000+newLoc1[1]);
                posNextRow[1] = MEMO.get(newLoc2[0]*1000+newLoc2[1]);
                MEMO.put(loc, lines[row][col] + Math.max(posNextRow[0], posNextRow[1]));
            }
        }
        return (MEMO.get(loc));
    }
}
