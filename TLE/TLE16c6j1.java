import java.io.*;

public class TLE16c6j1 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = in.readLine().split(" ");
        int paperAmount = Integer.parseInt(tokens[0]);
        int maxCap = Integer.parseInt(tokens[1]);

        int numAction = Integer.parseInt(in.readLine());

        int preSec = 0;
        int sec = 0;
        int pap = 0;
        boolean end = false;

        while (numAction > 0) {
            tokens = in.readLine().split(" ");
            sec = Integer.parseInt(tokens[0]);
            pap = Integer.parseInt(tokens[1]);
            numAction--;

            if (paperAmount < sec - preSec) {
                System.out.format("The printer melts at %d second(s).", preSec + paperAmount + 1);
                end = true;
                break;
            } else if (paperAmount - (sec - preSec) + pap > maxCap) {
                System.out.format("The printer jams at %d second(s).", sec);
                end = true;
                break;

            }
            paperAmount = paperAmount - (sec - preSec) + pap;
            preSec = sec;
        }

        if (!end) {
            System.out.printf("The printer melts at %d second(s).", sec+paperAmount+1);
        }
    }
}
