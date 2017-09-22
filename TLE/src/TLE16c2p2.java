import java.util.*;

public class TLE16c2p2 {

    private static long tx, ty, tz;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long numMicro = in.nextLong();
        long mx = in.nextLong();
        long my = in.nextLong();
        long mz = in.nextLong();
        tx = in.nextLong();
        ty = in.nextLong();
        tz = in.nextLong();

        long maxNumEach = Math.max(getNum(mx, my, mz), Math.max(getNum(mx, mz, my), Math.max(getNum(my, mx, mz), Math.max(getNum(my, mz, mx), Math.max(getNum(mz, my, mx), getNum(mz, mx, my))))));
        if (maxNumEach == 0){
            System.out.println("SCAMMED");
        }
        else {
            System.out.println((long) Math.ceil((double) numMicro/(double) maxNumEach));
        }
    }

    private static long getNum(long x, long y, long z) {
        return ((long) (Math.ceil(tx/x) * Math.ceil(ty/y) * Math.ceil(tz/z)));
    }
}
