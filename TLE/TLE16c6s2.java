import java.util.*;

public class TLE16c6s2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        double case1;

        if (x1+y1 > x2+y2) {
            case1 = (x1 * 2) * (y1 * 2) / 2;
        }
        else {
            case1 = (x2 * 2) * (y2 * 2) / 2;
        }
        double difY = y1-y2;
        double difX = x1-x2;
        double m = difY/difX;
        double b = -m*(x1)+y1;
        double xInter = -b/m;

        double case2;
        if (m < 0 && m != Double.POSITIVE_INFINITY) {
             case2 = (Math.abs(b) * Math.abs(xInter)) / 2;
        }
        else {
            case2 = Double.MAX_VALUE;
        }

        //System.out.println(case1);
        //System.out.println(case2);
        //System.out.println(case3);
        System.out.println(Math.min(case1, case2));
    }
}
