import java.util.Arrays;
import java.util.Scanner;

public class HorseRacingDuals {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] horseP = new int[N];
        for (int i = 0; i < N; i++) {
            horseP[i] = in.nextInt();
        }
        int minDistance = Integer.MAX_VALUE;
        Arrays.parallelSort(horseP);
        for(int i = horseP.length -1; i > 0; i--) {
            int currDist = horseP[i] - horseP[i-1];
            if(currDist < minDistance) {
                minDistance = currDist;
            }
        }
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(Math.abs(minDistance));
    }
}
