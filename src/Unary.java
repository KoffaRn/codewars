import java.util.Scanner;

public class Unary {
    public static void Unary(String args[]) {


        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        String binaryMessage = "";
        for(int i = 0; i < MESSAGE.length(); i++) {
            String charBinary = Integer.toBinaryString(MESSAGE.charAt(i));
            charBinary = String.format("%1$" + 7 + "s", charBinary).replace(' ', '0');
            binaryMessage += charBinary;
        }

        char lastChar = ' ';
        String zeroMessage = "";
        String[] encodeBits = new String[] {" 00 0", " 0 0"};

        for(int i = 0; i < binaryMessage.length(); i++) {
            if(binaryMessage.charAt(i) != lastChar) {
                lastChar = binaryMessage.charAt(i);
                zeroMessage += encodeBits[lastChar - '0'];
            }
            else {
                zeroMessage += "0";
            }
        }
        System.out.println(zeroMessage.substring(1));
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");

    }
    /*static String binaryToZero(String str) {
        char lastChar = 'a';
        String zeroStr = "";
        boolean firstPass = true;
        for(int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            if(currChar != lastChar) {
                if(firstPass) {
                    if(currChar == '0') zeroStr += "00 0";
                    else if(currChar == '1') zeroStr += "0 0";
                    firstPass = false;
                }
                else {
                    if(currChar == '0') zeroStr += " 00 0";
                    else if(currChar == '1') zeroStr += " 0 0";
                }
            }
            else zeroStr += "0";
            lastChar = currChar;
        }
        return zeroStr;
    }*/
}
