import java.util.Calendar;

/**
 * Clock test: what time of the day has the most segments on a 7-segment-24h-clock?
 */
public class ClockTestDbg extends ClockTest {
    private static final boolean DBG = true;
    private static final int KB = 1024;
    public static void main(String[] args) {
        final Calendar calendar = Calendar.getInstance();
        final long start = calendar.getTimeInMillis();
        int max = 0;
        String maxStr = "";
        for (int i = 0; i < MAD; i++) {
            calendar.add(Calendar.MINUTE, 1);
            final int hour = calendar.get(Calendar.HOUR);
            final int min = calendar.get(Calendar.MINUTE);
            final String time = String.format("%02d:%02d%n", hour, min);
            int sum = getSum(hour, min);
            if (sum > max) {
                max = sum;
                maxStr = time;
            }
            System.out.print(DBG ? time : "");
        }
        System.out.printf(DBG ? "-----%n" : "");
        System.out.print(maxStr);
        System.out.printf("%dms%n", System.currentTimeMillis() - start);

        final Runtime runtime = Runtime.getRuntime(); // Get the Java runtime
        runtime.gc(); // Run the garbage collector
        long memory = runtime.totalMemory() - runtime.freeMemory(); // Calculate the used memory
        System.out.printf("%dkb%n", memory / KB); // Used memory
    }
}
