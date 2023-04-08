import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Defibrillator {

    public static void Defbrillator(String args[]) {
        Scanner in = new Scanner(System.in);
        String sLON = in.next();
        String sLAT = in.next();
        double LON = Double.parseDouble(sLON.replaceAll(",","."));
        double LAT = Double.parseDouble(sLAT.replaceAll(",","."));
        ArrayList<Defib> defibs = new ArrayList<>();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[] arrDefib = DEFIB.split(";");
            defibs.add(new Defib(Integer.parseInt(arrDefib[0]),arrDefib[1],arrDefib[2],arrDefib[3],Double.parseDouble(arrDefib[4].replaceAll(",",".")),Double.parseDouble(arrDefib[5].replaceAll(",","."))));
        }
        double minDistance = Double.MAX_VALUE;
        int defibIndex = 0;
        for(int i = 0; i < defibs.size(); i++) {
            double currDistance = getDist(LON, LAT, defibs.get(i).getLON(), defibs.get(i).getLAT());
            if(currDistance < minDistance) {
                minDistance = currDistance;
                defibIndex = i;
            }
        }
        System.out.println(defibs.get(defibIndex).name);
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
    }
    static double getDist(double LONA, double LATA, double LONB, double LATB) {
        double x = (LONB-LONA)*Math.cos((LATA+LATB)/2);
        double y = LATB - LATA;
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2)) * 6371;
    }
    static class Defib {
        int index;
        String name;
        String address;
        String phoneNumber;
        double LON;
        double LAT;
        public Defib(int index, String name, String address, String phoneNumber, double LON, double LAT){
            this.name=name;
            this.index=index;
            this.LON=LON;
            this.LAT=LAT;
        }
        double getLON() {
            return LON;
        }
        double getLAT() {
            return LAT;
        }
        int getIndex() {
            return index;
        }
    }
}
