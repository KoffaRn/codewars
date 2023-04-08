public class HumanReadableTime {
    public static String makeReadable(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int resSeconds = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, resSeconds);
    }
}
