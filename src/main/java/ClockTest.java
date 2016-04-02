import java.util.Calendar;

/**
 * Clock test: what time of the day has the most segments on a 7-segment-24h-clock?
 */
public class ClockTest {
    static final int HAD = 60 * 24;
    static final int[] NUM = new int[]{
            /* 0 */ 6, /* 1 */ 2, /* 2 */ 5, /* 3 */ 5, /* 4 */ 4,
            /* 5 */ 5, /* 6 */ 6, /* 7 */ 3, /* 8 */ 7, /* 9 */ 6,
    };
    static int getSum(final int hour, final int min) {
        return NUM[hour % 10] + NUM[hour / 10] + NUM[min % 10] + NUM[min / 10];
    }
    public static void main(String[] args) {
        final Calendar calendar = Calendar.getInstance();
        int max = 0;
        String maxStr = "";
        for (int i = 0; i < HAD; i++) {
            calendar.add(Calendar.MINUTE, 1);
            final int hour = calendar.get(Calendar.HOUR);
            final int min = calendar.get(Calendar.MINUTE);
            final int sum = getSum(hour, min);
            if (sum > max) {
                max = sum;
                maxStr = String.format("%02d:%02d%n", hour, min);
            }
        }
        System.out.print(maxStr);
    }
}
