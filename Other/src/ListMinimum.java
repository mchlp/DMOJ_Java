import java.io.*;
import java.util.*;

public class ListMinimum {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(in.readLine().trim());
        int[] list = new int[num];
        for (int i=0; i<num; i++) {
            list[i] = Integer.parseInt(in.readLine().trim());
        }
        Arrays.sort(list);
        for (int n : list) {
            System.out.println(n);
        }
    }
}
