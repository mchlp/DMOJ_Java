import java.io.*;

public class DMOPC16c4p1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long j = Long.parseLong(in.readLine());
        for (int i = 0; i < j; i++) {
            long num = Long.parseLong(in.readLine());
            boolean goodNum = true;
            while (num > 1) {
                if (num%2 != 0) {
                    goodNum = false;
                    break;
                }
                num /= 2;
            }
            if (goodNum) {
                System.out.println("T");
            }
            else {
                System.out.println("F");
            }
        }
    }
}