package cerlace.threads.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomCountUtil {
    private static final int RANDOM_COUNT_MIN = 1;
    private static final int RANDOM_COUNT_MAX = 4;

    private RandomCountUtil() {
    }

    /**
     * Метод выдает случаное число в премежутке
     * от {@link #RANDOM_COUNT_MIN} до {@link #RANDOM_COUNT_MAX}
     *
     * @return случаное число в промежутке.
     */
    public static int getCount() {
        return ThreadLocalRandom.current()
                .nextInt(RANDOM_COUNT_MAX) + RANDOM_COUNT_MIN;
    }
}
