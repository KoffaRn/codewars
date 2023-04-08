import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

public class AsciiArt {
    /*
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int height = in.nextInt();
        String abc = "abcdefghijklmnopqrstuvwxyz?";
        if (in.hasNextLine()) {
            in.nextLine();
        }
        String T = in.nextLine();
        T = T.toLowerCase();

        for (int i = 0; i < height; i++) {
            String ROW = in.nextLine();
            for(int j = 0; j<T.length(); j++) {
                int index = abc.indexOf(T.substring(j, j+1));
                if(index == -1) index = abc.length() - 1;
                System.out.print(ROW.substring(index*length, index*length+length));
            }
            System.out.println();
        }
    }*/
}
