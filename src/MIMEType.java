import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MIMEType {
    public static void MIMEType(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        HashMap<String, String> lookup = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            lookup.put("."+EXT.toLowerCase(), MT);
        }
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            FNAME = FNAME.toLowerCase();
            String FEXT = "UNKOWN";
            if(FNAME.contains(".")) FEXT = FNAME.substring(FNAME.lastIndexOf('.'));
            if(lookup.containsKey(FEXT)) {
                System.out.println(lookup.get(FEXT));
            }
            else System.out.println("UNKNOWN");
        }

        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
        //System.out.println("UNKNOWN");
    }
}
