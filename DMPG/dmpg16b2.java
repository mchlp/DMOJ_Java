import java.util.*;

public class dmpg16b2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCase = in.nextInt();

        for (int i=0; i<numCase; i++) {
            int numPpl = in.nextInt();
            int numBeat = 0;
            int curScore = in.nextInt();
            for (int j=0; j<numPpl-1; j++) {
                int checkScore = in.nextInt();
                if (checkScore > curScore) {
                    numBeat++;
                }
            }
            double money = Math.round(Math.sqrt(numPpl-numBeat)*10000)/(double)100;
            System.out.format("Bob wins $%.2f at IOI!", money);
        }
    }
}
