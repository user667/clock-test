public class ClockTestSlim {
    private static final int[] NUMBER_OF_LIT_SEGMENTS = new int[]{/* 0 */ 6, /* 1 */ 2, /* 2 */ 5, /* 3 */ 5, /* 4 */ 4,/* 5 */ 5, /* 6 */ 6, /* 7 */ 3, /* 8 */ 7, /* 9 */ 6};
    public static void main(String[] args) {
        int max = 0;
        String maxStr = "";
        for (int hour = 0; hour < 24; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                final int sum = NUMBER_OF_LIT_SEGMENTS[hour % 10] + NUMBER_OF_LIT_SEGMENTS[hour / 10] + NUMBER_OF_LIT_SEGMENTS[minute % 10] + NUMBER_OF_LIT_SEGMENTS[minute / 10];
                if (sum > max) {
                    max = sum;
                    maxStr = String.format("%02d:%02d%n", hour, minute);
                }
            }
        }
        System.out.print(maxStr);
    }
}
