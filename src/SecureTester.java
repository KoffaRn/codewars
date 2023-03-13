public class SecureTester{

    public static boolean alphanumeric(String s){
        if(s.length() < 1) return false;
        return s.matches("^[a-zA-Z0-9]*$");
    }
}