import javax.sound.midi.Soundbank;
import java.util.*;
import java.io.*;
import java.math.*;


public class MovesInMaze {
    static int h;
    static int w;
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class queueNode {
        Point pt;
        int dist;
        public queueNode(Point pt, int dist) {
            this.pt = pt;
            this.dist = dist;
        }
    }
    static boolean isValid(int y, int x) {
        return (y >= 0) && (y < h) && (x >= 0) && (x < w);
    }
    static int rowNum[] = {-1, 0, 0, 1};
    static int colNum[] = {0, -1, 1, 0};

    static int BFS(char mat[][], Point src, Point dest) {
        if(mat[src.y][src.x] != '.' || mat[dest.y][dest.x] != '.') {
            System.out.println("Not .");
            return -1;
        }
        boolean[][] visited = new boolean[h][w];

        visited[src.x][src.y] = true;
        Queue<queueNode> q = new LinkedList<>();
        queueNode s = new queueNode(src, 0);
        q.add(s);

        while(!q.isEmpty()) {
            queueNode curr = q.peek();
            Point pt = curr.pt;

            if(pt.x == dest.x && pt.y == dest.y) {
                return curr.dist;
            }
            q.remove();
            for(int i = 0; i < 4; i++) {
                int row = pt.x + rowNum[i];
                int col = pt.y + colNum[i];

                if(isValid(row, col) && mat[row][col] == '.' && !visited[row][col]) {
                    visited[row][col] = true;
                    queueNode Adjcell = new queueNode(new Point(row, col), curr.dist +1);
                    q.add(Adjcell);
                }
            }
        }
        return -1;
    }
    /*public static void main(String args[]) {
        char[] moves = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Scanner in = new Scanner(System.in);
        int startingX = 0;
        int startingY = 0;
        w = in.nextInt();
        h = in.nextInt();
        char[][] mat = new char[h][w];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int y = 0; y < h; y++) {
            String ROW = in.nextLine();
            for(int x = 0; x < ROW.length(); x++) {
                if(ROW.charAt(x) == 'S') {
                    startingX = x;
                    startingY = y;
                    mat[y][x] = '.';
                }
                else mat[y][x] = ROW.charAt(x);
            }

        }
        Point start = new Point(startingX, startingY);
        Point dest = new Point(3, 1);
        System.out.println(BFS(mat, start, dest));
        System.out.println(start.x + " " + start.y);


        for(int y = 0; y < h; y++) {
            for(int x = 0; x < w; x++) {
                System.out.print(mat[y][x]);
            }
            System.out.println("");
        }
       /* for (int i = 0; i < h; i++) {

            // Write an answer using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println("answer");
        }*/
    }
