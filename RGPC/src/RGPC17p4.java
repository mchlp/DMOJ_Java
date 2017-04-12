import java.io.*;

public class RGPC17p4 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().split(" ");
        int numPoint = Integer.parseInt(input[0]);
        int numPath = Integer.parseInt(input[1]);

        long[][] data = new long[numPoint+1][2];
        data[1][0] = 0;
        data[1][1] = 1;

        long[][] inputData = new long[numPoint + 1][numPoint + 1];

        boolean good = true;

        for (int i = 0; i < numPath; i++) {
            input = in.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            long dis = Integer.parseInt(input[2]);
            if (end <= start) {
                good = false;
                break;
            }
            inputData[start][end] = dis;
        }
        if (good) {
            for (int start = 1; start <= numPoint; start++) {
                for (int end = numPoint; end > start; end--) {
                    if (inputData[start][end] > 0) {
                        long dis = inputData[start][end];
                        long[] prevData = data[start];
                        long newDis = prevData[0] + dis;
                        long newPoint = prevData[1] + 1;

                        if (newDis > data[end][0]) {
                            data[end][0] = newDis;
                            data[end][1] = newPoint;
                        }
                        if (newDis == data[end][0]) {
                            if (newPoint > data[end][1]) {
                                data[end][1] = newPoint;
                            }
                        }
                    }
                }
            }
        }

        if (!good) {
            System.out.println(-1);
        }
        else {
            System.out.print(data[numPoint][0] + " ");
            System.out.print(data[numPoint][1]);
        }
    }
}
