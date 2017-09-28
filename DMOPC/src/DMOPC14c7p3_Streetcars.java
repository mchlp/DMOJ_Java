import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DMOPC14c7p3_Streetcars {

    public static void main (String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numStops = Integer.parseInt(in.readLine());
        int[] stopsPass = new int[numStops];
        int[] stopsOff = new int[numStops];
        for (int i=0; i<numStops; i++) {
            String[] input = in.readLine().split(" ");
            stopsPass[i] = Integer.parseInt(input[0]);
            stopsOff[i] = Integer.parseInt(input[1]);
        }

        System.out.println(getCars(132, stopsPass, stopsOff, numStops) - getCars(251, stopsPass, stopsOff, numStops));
    }

    private static int getCars (int cap, int[] mstopPass, int[] mstopsOff, int mnumStops) {
        int[] stopsPass = new int[mnumStops];
        int[] stopsOff = new int[mnumStops];

        for (int i=0; i<mnumStops; i++) {
            stopsPass[i] = mstopPass[i];
            stopsOff[i] = mstopsOff[i];
        }

        int numCars = 0;
        int curCap = 0;
        boolean pickup = true;

        while(pickup) {
            pickup = false;
            numCars++;
            curCap += cap;

            for (int i=0; i<mnumStops; i++) {

                curCap -= (int)(curCap*((double)stopsOff[i]/(double) 100));

                if (stopsPass[i] != 0) {
                    pickup = true;
                    if (stopsPass[i] <= curCap) {
                        curCap -= stopsPass[i];
                        stopsPass[i] = 0;
                    } else {
                        stopsPass[i] -= curCap;
                        curCap = 0;
                        break;
                    }
                }
            }
        }

        numCars -= 1;
        return numCars;
    }
}
