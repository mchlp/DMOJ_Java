import java.util.*;

public class dmpg16b3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] design = new String[3];
        int designWidth = 0;
        for (int i=0; i<3; i++) {
            String line = in.nextLine().replace("/n", "");
            design[i] = line;
            if (line.length() > designWidth) {
                designWidth = line.length();
            }
        }
        String value = Integer.toString(in.nextInt());
        int height = in.nextInt();
        int width = in.nextInt()*2;

        for (int i=0; i<width+designWidth+2; i++) {
            System.out.print("=");
        }
        System.out.println();
        System.out.format("|%s", value);
        for (int i=0; i<designWidth+width-value.length(); i++) {
            System.out.print(" ");
        }
        System.out.println("|");
        int topBreak = 1;
        while (height > topBreak) {
            topBreak++;
            System.out.print("|");
            for (int i=0; i<designWidth+width-2; i++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }

        for (int i=0; i<3; i++) {
            System.out.print("|");
            for (int j=0; j<width/2; j++) {
                System.out.print(" ");
            }
            System.out.print(design[i]);
            for (int j=0; j<width/2; j++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }

        int bottomBreak = 0;
        while (height > bottomBreak+1) {
            bottomBreak++;
            System.out.print("|");
            for (int i = 0; i < designWidth + width; i++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }

        System.out.print("|");
        for (int i=0; i<designWidth+width-value.length(); i++) {
            System.out.print(" ");
        }
        System.out.format("%s|\n", value);

        for (int i=0; i<width+designWidth+2; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
