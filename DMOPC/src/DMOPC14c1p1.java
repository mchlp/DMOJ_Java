import java.util.*;

public class DMOPC14c1p1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] iArray = new int[num];
        for (int i = 0; i < num; i++) {
            iArray[i] = in.nextInt();
        }
        Arrays.sort(iArray);

        int middle = iArray.length/2;
        if (iArray.length%2 == 1) {
            System.out.print(Math.round(iArray[middle]));
        }
        else {
            System.out.print(Math.round((iArray[middle-1] + iArray[middle]) /2.0));
        }

    }
}
