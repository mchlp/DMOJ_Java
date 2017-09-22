import java.util.*;

public class dmpg17s2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCity = in.nextInt();
        int numQuery = in.nextInt();
        in.nextLine();
        boolean[][] data = new boolean[numCity+1][numCity+1];

        for (int i=0; i<numQuery; i++) {
            String[] q = in.nextLine().split(" ");
            String com = q[0];
            int city1 = Integer.parseInt(q[1]);
            int city2 = Integer.parseInt(q[2]);

            if (com.equals("A")) {
                data[city1][city2] = true;
                data[city2][city1] = true;
            }
            else {
                if (findPath(data, city1, city2)) {
                    System.out.println("Y");
                }
                else {
                    System.out.println("N");
                }
            }
        }
    }
    private static boolean findPath(boolean[][] data, int city1, int city2) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(city1);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int curVisit = queue.remove();
            if (visited.contains(curVisit)) {
                continue;
            }
            if (curVisit == city2) {
                return true;
            }
            for (int i=0; i<data[curVisit].length; i++) {
                if (data[curVisit][i]) {
                    if (!visited.contains(i)) {
                        queue.add(i);
                    }
                }
            }
        }
        return false;
    }
}
