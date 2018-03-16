import java.util.ArrayDeque;
import java.util.Scanner;

public class ccc18s3 {

    static class Point {
        public int x;
        public int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int w = in.nextInt();
        in.nextLine();
        Point start = null;
        int[][] dis = new int[w][h];
        char[][] map = new char[w][h];
        Point[][] port = new Point[w][h];
        for (int i = 0; i < h; i++) {
            String line = in.nextLine();
            for (int j = 0; j < w; j++) {
                dis[j][i] = -1;
                map[j][i] = line.charAt(j);
                if (line.charAt(j) == 'S') {
                    start = new Point(j, i);
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[j][i] == 'U') {
                    int x = j;
                    int y = i;
                    Point b = null;
                    while (y >= 0) {
                        if (map[x][y] == 'U') {
                            b = new Point(x, y);
                        } else {
                            break;
                        }
                        y--;
                    }
                    Point t = null;
                    y = i;
                    while (y < h) {
                        if (map[x][y] == 'U') {
                            t = new Point(x, y);
                        } else {
                            break;
                        }
                        y++;
                    }
                    Point end = new Point(t.x, t.y);
                    x = b.x;
                    y = b.y;
                    while (y <= t.y) {
                        port[x][y] = end;
                        y++;
                    }
                }
                if (map[j][i] == 'D') {
                    int x = j;
                    int y = i;
                    Point t = null;
                    while (y >= 0) {
                        if (map[x][y] == 'D') {
                            t = new Point(x, y);
                        } else {
                            break;
                        }
                        y--;
                    }
                    Point b = null;
                    y = i;
                    while (y < h) {
                        if (map[x][y] == 'D') {
                            b = new Point(x, y);
                        } else {
                            break;
                        }
                        y++;
                    }
                    x = b.x;
                    y = b.y;
                    Point end = new Point(t.x, t.y);
                    while (y >= t.y) {
                        port[x][y] = end;
                        y--;
                    }
                }
                if (map[j][i] == 'L') {
                    int x = j;
                    int y = i;
                    Point t = null;
                    while (x >= 0) {
                        if (map[x][y] == 'L') {
                            t = new Point(x, y);
                        } else {
                            break;
                        }
                        x--;
                    }
                    Point b = null;
                    x = j;
                    while (x < w) {
                        if (map[x][y] == 'L') {
                            b = new Point(x, y);
                        } else {
                            break;
                        }
                        x++;
                    }
                    x = b.x;
                    y = b.y;
                    Point end = new Point(t.x, t.y);
                    while (x >= t.x) {
                        port[x][y] = end;
                        x--;
                    }
                }
                if (map[j][i] == 'R') {
                    int x = j;
                    int y = i;
                    Point b = null;
                    while (x >= 0) {
                        if (map[x][y] == 'R') {
                            b = new Point(x, y);
                        } else {
                            break;
                        }
                        x--;
                    }
                    Point t = null;
                    x = j;
                    while (x < w) {
                        if (map[x][y] == 'R') {
                            t = new Point(x, y);
                        } else {
                            break;
                        }
                        x++;
                    }
                    x = b.x;
                    y = b.y;
                    Point end = new Point(t.x, t.y);
                    while (x <= t.x) {
                        port[x][y] = end;
                        x++;
                    }
                }
                if (map[j][i] == 'C') {
                    int x;
                    int y;
                    x = j - 1;
                    y = i;
                    while (x >= 0) {
                        if (map[x][y] == 'W') {
                            break;
                        }
                        if (map[x][y] == '.') {
                            map[x][y] = 'X';
                        }
                        x--;
                    }
                    x = j + 1;
                    while (x < w) {
                        if (map[x][y] == 'W') {
                            break;
                        }
                        if (map[x][y] == '.') {
                            map[x][y] = 'X';
                        }
                        x++;
                    }
                    x = j;
                    y = i - 1;
                    while (y >= 0) {
                        if (map[x][y] == 'W') {
                            break;
                        }
                        if (map[x][y] == '.') {
                            map[x][y] = 'X';
                        }
                        y--;
                    }
                    y = i + 1;
                    while (y < h) {
                        if (map[x][y] == 'W') {
                            break;
                        }
                        if (map[x][y] == '.') {
                            map[x][y] = 'X';
                        }
                        y++;
                    }
                    ;
                }
            }
        }

        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.push(start);
        dis[start.x][start.y] = 0;
        while (!queue.isEmpty()) {
            Point curPoint = queue.removeLast();
            if (port[curPoint.x][curPoint.y] != null) {
                if (dis[port[curPoint.x][curPoint.y].x][port[curPoint.x][curPoint.y].y] == -1 && map[port[curPoint.x][curPoint.y].x][port[curPoint.x][curPoint.y].y] != 'W' && map[port[curPoint.x][curPoint.y].x][port[curPoint.x][curPoint.y].y] != 'X' && map[port[curPoint.x][curPoint.y].x][port[curPoint.x][curPoint.y].y] != 'C') {
                    dis[port[curPoint.x][curPoint.y].x][port[curPoint.x][curPoint.y].y] = dis[curPoint.x][curPoint.y];
                    queue.push(port[curPoint.x][curPoint.y]);
                }
            }
            if (map[curPoint.x][curPoint.y] != 'W' && map[curPoint.x][curPoint.y] != 'C' && map[curPoint.x][curPoint.y] != 'X') {
                int newDis = dis[curPoint.x][curPoint.y] + 1;
                if (port[curPoint.x][curPoint.y] != null && port[curPoint.x][curPoint.y].x == curPoint.x && port[curPoint.x][curPoint.y].y == curPoint.y) {
                    newDis--;
                }
                if (curPoint.x < w - 1 && dis[curPoint.x + 1][curPoint.y] == -1 && map[curPoint.x + 1][curPoint.y] != 'W' && map[curPoint.x + 1][curPoint.y] != 'C' && map[curPoint.x + 1][curPoint.y] != 'X') {
                    dis[curPoint.x + 1][curPoint.y] = newDis;
                    queue.push(new Point(curPoint.x + 1, curPoint.y));
                }
                if (curPoint.x > 0 && dis[curPoint.x - 1][curPoint.y] == -1 && map[curPoint.x - 1][curPoint.y] != 'W' && map[curPoint.x - 1][curPoint.y] != 'C' && map[curPoint.x - 1][curPoint.y] != 'X') {
                    dis[curPoint.x - 1][curPoint.y] = newDis;
                    queue.push(new Point(curPoint.x - 1, curPoint.y));
                }
                if (curPoint.y < h - 1 && dis[curPoint.x][curPoint.y + 1] == -1 && map[curPoint.x][curPoint.y + 1] != 'W' && map[curPoint.x][curPoint.y + 1] != 'C' && map[curPoint.x][curPoint.y + 1] != 'X') {
                    dis[curPoint.x][curPoint.y + 1] = newDis;
                    queue.push(new Point(curPoint.x, curPoint.y + 1));
                }
                if (curPoint.y > 0 && dis[curPoint.x][curPoint.y - 1] == -1 && map[curPoint.x][curPoint.y - 1] != 'W' && map[curPoint.x][curPoint.y - 1] != 'C' && map[curPoint.x][curPoint.y - 1] != 'X') {
                    dis[curPoint.x][curPoint.y - 1] = newDis;
                    queue.push(new Point(curPoint.x, curPoint.y - 1));
                }
            }
        }


/*
        for (
                int i = 0;
                i < h; i++)

        {
            for (int j = 0; j < w; j++) {
                System.out.format("%3c", map[j][i]);
            }
            System.out.println();
        }

        System.out.println();

        for (
                int i = 0;
                i < h; i++)

        {
            for (int j = 0; j < w; j++) {
                System.out.format("%3d", dis[j][i]);
            }
            System.out.println();
        }

        System.out.println();

        for (
                int i = 0;
                i < h; i++)

        {
            for (int j = 0; j < w; j++) {
                try {
                    System.out.format("(%3d %3d)", port[j][i].x, port[j][i].y);
                } catch (NullPointerException e) {
                    System.out.print("(--- ---)");
                }
            }
            System.out.println();
        }

*/

        for (
                int i = 0;
                i < h; i++)

        {
            for (int j = 0; j < w; j++) {
                if (map[j][i] == '.' || map[j][i] == 'X') {
                    System.out.println(dis[j][i]);
                }
            }
        }
    }

}
