public class ClockTestSlim {
    protected static final int[] NUM = new int[] {
            /* 0 */ 6, /* 1 */ 2, /* 2 */ 5, /* 3 */ 5, /* 4 */ 4,
            /* 5 */ 5, /* 6 */ 6, /* 7 */ 3, /* 8 */ 7, /* 9 */ 6,
    };
    protected static int getSum(final int hour, final int min) {
        return NUM[hour % 10] + NUM[hour / 10] + NUM[min % 10] + NUM[min / 10];
    }
    public static void main(String[] args) {
        int max = 0;
        String maxStr = "";
        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                final int sum = getSum(hour, minute);
                if (sum > max) {
                    max = sum;
                    maxStr = String.format("%02d:%02d%n", hour, minute);
                }
            }
        }
        System.out.print(maxStr);
    }
}
