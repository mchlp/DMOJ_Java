import java.util.*;


public class TLE16c6j4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long len1 = in.nextLong();
        long len2 = in.nextLong();
        long len3 = in.nextLong();

        Deque<Integer> line1 = new LinkedList<Integer>();
        Deque<Integer> line2 = new LinkedList<Integer>();
        Deque<Integer> line3 = new LinkedList<Integer>();

        for (int i=0; i< len1; i++) {
            line1.addLast(in.nextInt());
        }
        for (int i=0; i< len2; i++) {
            line2.addLast(in.nextInt());
        }
        for (int i=0; i< len3; i++) {
            line3.addLast(in.nextInt());
        }

        int movetimeleft = 30;
        int totaltime = 0;
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        int num3 = Integer.MAX_VALUE;

        while (getRealSize(line1, num1) + getRealSize(line2, num2) + getRealSize(line3, num3) > 0) {
            num1 = getInitNum(line1, num1);
            num2 = getInitNum(line2, num2);
            num3 = getInitNum(line3, num3);

            int Checktime = 1;
            //int Checktime = Math.min(Math.min(num1, num2), Math.min(num3,movetimeleft));
            totaltime += Checktime;

            num1 = calcRemainTime(num1, Checktime);
            num2 = calcRemainTime(num2, Checktime);
            num3 = calcRemainTime(num3, Checktime);
            num1 = getNextNumber(line1, num1);
            num2 = getNextNumber(line2, num2);
            num3 = getNextNumber(line3, num3);

            movetimeleft -=Checktime;

            if (movetimeleft ==0) {

                movetimeleft = 30;
                int curLen1 = getRealSize(line1, num1);
                int curLen2 = getRealSize(line2, num2);
                int curLen3 = getRealSize(line3, num3);
                if (curLen1 > curLen2 && curLen2 > curLen3) {
                    line3.addLast(line1.removeLast());
                } else if (curLen1 > curLen3 && curLen2 < curLen3) {
                    line2.addLast(line1.removeLast());
                } else if (curLen1 < curLen2 && curLen2 < curLen3) {
                    line1.addLast(line3.removeLast());
                } else if (curLen1 > curLen2 && curLen1 < curLen3) {
                    line2.addLast(line3.removeLast());
                } else if (curLen1 < curLen3 && curLen2 > curLen3) {
                    line1.addLast(line2.removeLast());
                } else if (curLen1 > curLen3 && curLen2 > curLen1) {
                    line3.addLast(line2.removeLast());
                }
            }
        }
        System.out.println(totaltime);
    }

    private static int getRealSize(Deque<Integer> line, int num1) {
        return line.size() + (num1!=Integer.MAX_VALUE ? 1:0);
    }

    private static int getInitNum(Deque<Integer> line, int num) {
        return num == Integer.MAX_VALUE ? (line.size()>0 ? line.removeFirst(): Integer.MAX_VALUE) : num;
    }

    private static int calcRemainTime(int num1, int checktime) {
        return num1!= Integer.MAX_VALUE ? num1 - checktime : Integer.MAX_VALUE;
    }

    private static int getNextNumber(Deque<Integer> line, int num) {
        return (num == 0 && line.size()>0)?line.removeFirst():(num == 0 && line.size()==0? Integer.MAX_VALUE: num);
    }
}
