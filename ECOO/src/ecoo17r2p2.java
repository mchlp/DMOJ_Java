import java.util.*;

public class ecoo17r2p2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] translations = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int c = 0; c < 10; c++) {
            int numLine = in.nextInt();
            in.nextLine();
            char[][] data = new char[numLine][numLine];
            int[] start = new int[3];
            for (int i = 0; i < numLine; i++) {
                String line = in.nextLine();
                char[] lineData = new char[numLine];
                int j = 0;
                for (char ch : line.toCharArray()) {
                    lineData[j] = ch;
                    if (ch == 'S') {
                        start[0] = i;
                        start[1] = j;
                        start[2] = 0;
                    }
                    j++;
                }
                data[i] = lineData;
            }
            //System.out.println(Arrays.toString(start));
            //for (char[] printLine : data) {
            //    System.out.println(Arrays.toString(printLine));
            //}

            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            int numKeys = 0;
            int[][] visited = new int[numLine][numLine];
            for (int[] row : visited) {
                Arrays.fill(row, -1);
            }

            int[][] chestList = new int[numLine][numLine];
            for (int[] row : chestList) {
                Arrays.fill(row, -1);
            }
            int[][] keyList = new int[numLine][numLine];
            for (int[] row : keyList) {
                Arrays.fill(row, -1);
            }
            while (!queue.isEmpty()) {
                int[] curNode = queue.remove();
                int[] curCoords = {curNode[0], curNode[1]};
                if (visited[curCoords[0]][curCoords[1]] == -1 || visited[curCoords[0]][curCoords[1]] > curNode[2]) {
                    int curKeysNeeded = curNode[2];
                    visited[curCoords[0]][curCoords[1]] = curKeysNeeded;

                    char curData = data[curNode[0]][curNode[1]];
                    switch (curData) {
                        case 'K':
                            if (curKeysNeeded == 0) {
                                numKeys++;
                            }
                            else {
                                if (keyList[curCoords[0]][curCoords[1]] == -1) {
                                    keyList[curCoords[0]][curCoords[1]] = curKeysNeeded;
                                } else {
                                    if (keyList[curCoords[0]][curCoords[1]] > curKeysNeeded) {
                                        keyList[curCoords[0]][curCoords[1]] = curKeysNeeded;
                                    }
                                }
                            }
                            break;
                        case '.':
                            break;
                        case '#':
                            continue;
                        case 'T':
                            if (chestList[curCoords[0]][curCoords[1]] == -1) {
                                chestList[curCoords[0]][curCoords[1]] = curKeysNeeded;
                            } else {
                                if (chestList[curCoords[0]][curCoords[1]] > curKeysNeeded) {
                                    chestList[curCoords[0]][curCoords[1]] = curKeysNeeded;
                                }
                            }
                            break;
                        case 'S':
                            break;
                        default:
                            curKeysNeeded = Math.max(curKeysNeeded, Character.getNumericValue(curData));
                    }

                    for (int[] translate : translations) {
                        int[] newNode = {curNode[0], curNode[1], curKeysNeeded};
                        newNode[0] += translate[0];
                        newNode[1] += translate[1];

                        if (newNode[0] >= numLine || newNode[0] < 0 || newNode[1] >= numLine || newNode[1] < 0) {
                            continue;
                        }
                        if (visited[newNode[0]][newNode[1]] == -1) {
                            queue.add(newNode);
                        }
                    }
                }
            }
            /**
            for (int[] printLine : chestList) {
                System.out.println(Arrays.toString(printLine));
            }

            System.out.println("------------------");

            for (int[] printLine : keyList) {
                System.out.println(Arrays.toString(printLine));
            }
            System.out.println("------------------");
             **/

            int[] obtainableKeyList = new int[10];
            for (int[] row:keyList) {
                for (int col:row) {
                    if (col != -1) {
                        obtainableKeyList[col]++;
                    }
                }
            }

            for (int i=0; i<obtainableKeyList.length; i++) {
                if (i <= numKeys) {
                    numKeys += obtainableKeyList[i];
                }
            }

            //System.out.println(numKeys);

            int numOpenableChest = 0;
            for (int[] row:chestList) {
                for (int col:row) {
                    if (col <= numKeys && col != -1) {
                        numOpenableChest++;
                    }
                }
            }
            System.out.println(numOpenableChest);
        }
    }
}
