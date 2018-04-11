import java.util.Scanner;

public class ccchk08j2 {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        while (N-- > 0) {
            char[] d = in.nextLine().toCharArray();
            int sum = 0;
            for (char di : d) {
                sum += Integer.parseInt(Character.toString(di));
                if (sum >= 10) {
                    sum = sum%10+sum/10;
                }
            }
            System.out.println(sum);
        }

    }

}
