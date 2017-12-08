import java.util.*;

public class VMSSbronzeWk5_Melanioana {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean tree = false;
        String treeStat = in.nextLine();
        if (treeStat.equals("trees!")) {
            tree = true;
        }
        double [] markList = new double[4];
        double [] weightList = new double[4];
        double maxW = 0;

        for (int i=0; i<4; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            double w = in.nextDouble();
            markList[i] = (double)a/(double)b;
            weightList[i] = w;
            if (w > maxW) {
                maxW = w;
            }
        }

        double total = 0;

        for (int i=0; i<4; i++) {
            if (weightList[i] == maxW) {
                if (tree) {
                    total += maxW*100;
                }
            }
            else {
                total += markList[i]*100*weightList[i];
            }
        }
        System.out.print(Math.round(total));
    }
}
