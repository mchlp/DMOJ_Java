import java.util.Scanner;

public class BattlePositions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numStation = in.nextInt();
        int minTroops = in.nextInt();
        int numWaves = in.nextInt();
        int[] troops = new int[numStation+1];

        for (int i=0; i<numWaves; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            int numTroops = in.nextInt();
            troops[start-1] += numTroops;
            troops[end] -= numTroops;
        }

        int min = 0;
        int count = 0;
        for (int i=0; i<numStation; i++) {
            count += troops[i];
            if (count < minTroops) {
                min++;
            }
        }
        System.out.println(min);
    }
}