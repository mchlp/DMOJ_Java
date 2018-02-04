import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

public class ccc03s3 {

    public static void main(String[] args) {

        FastReader reader = new FastReader();
        int area = reader.nextInt();
        int row = reader.nextInt();
        int col = reader.nextInt();

        ArrayDeque<Point> queue = new ArrayDeque<>();

        int rooms[] = new int[65];

        boolean[][] visited = new boolean[col][row];
        char[][] map = new char[col][row];

        for (int i = 0; i < row; i++) {
            String line = reader.nextLine().trim();
            for (int j = 0; j < col; j++) {
                map[j][i] = line.charAt(j);
            }
        }

        while (true) {
            findLoop:
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[j][i] == '.') {
                        if (!visited[j][i]) {
                            visited[j][i] = true;
                            queue.push(new Point(j, i));
                            break findLoop;
                        }
                    }
                }
            }
            if (queue.isEmpty()) {
                break;
            } else {
                int rmArea = 0;
                while (!queue.isEmpty()) {
                    Point curPoint = queue.pop();
                    try {
                        if (map[curPoint.x + 1][curPoint.y] == '.' && !visited[curPoint.x + 1][curPoint.y]) {
                            visited[curPoint.x + 1][curPoint.y] = true;
                            queue.push(new Point(curPoint.x + 1, curPoint.y));
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        int a = 0;
                    }
                    try {
                        if (map[curPoint.x - 1][curPoint.y] == '.' && !visited[curPoint.x - 1][curPoint.y]) {
                            visited[curPoint.x - 1][curPoint.y] = true;
                            queue.push(new Point(curPoint.x - 1, curPoint.y));
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        int a = 0;
                    }
                    try {
                        if (map[curPoint.x][curPoint.y + 1] == '.' && !visited[curPoint.x][curPoint.y + 1]) {
                            visited[curPoint.x][curPoint.y + 1] = true;
                            queue.push(new Point(curPoint.x, curPoint.y + 1));
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        int a = 0;
                    }
                    try {
                        if (map[curPoint.x][curPoint.y - 1] == '.' && !visited[curPoint.x][curPoint.y - 1]) {
                            visited[curPoint.x][curPoint.y - 1] = true;
                            queue.push(new Point(curPoint.x, curPoint.y - 1));
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        int a = 0;
                    }
                    rmArea++;
                }
                rooms[rmArea]++;
            }
        }
        int mkRoom = 0;
        getRooms:
        for (int i = 64; i > 0; i--) {
            for (int j = 0; j < rooms[i]; j++) {
                if (area - i >= 0) {
                    mkRoom++;
                    area -= i;
                } else {
                    break getRooms;
                }
            }
        }
        if (mkRoom == 1) {
            System.out.format("%d room, %d square metre(s) left over", mkRoom, area);
        } else {
            System.out.format("%d rooms, %d square metre(s) left over", mkRoom, area);
        }
    }
}
