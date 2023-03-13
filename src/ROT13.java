public class ROT13 {
    public static String rot13(String message) {
        char[] result = message.toCharArray();
        for(int i = 0; i < result.length; i++) {
            if(result[i] >= 'a' && result[i] <= 'm') result[i] += 13;
            else if(result[i] >= 'A' && result[i] <= 'M') result[i] +=13;
            else if(result[i] >='n' && result[i] <= 'z') result[i] -=13;
            else if(result[i] >= 'N' && result[i] <= 'Z') result[i] -=13;
        }
        return new String(result);
    }
}
