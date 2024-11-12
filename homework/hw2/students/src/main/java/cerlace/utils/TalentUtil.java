package cerlace.utils;

import java.util.Random;

/**
 * Класс {@code TalentUtil} является утилитарным классом, содержащим
 * методы для генерации значения таланта.
 */
public class TalentUtil {
    private static final double MIN_TALENT = 0.1;
    private static final double MAX_TALENT = 1;

    private TalentUtil() {
    }

    /**
     * Метод генерирует псевдослучайное значение таланта, ограниченное
     * константами {@link #MIN_TALENT} (включительно), и {@link #MAX_TALENT} (включительно).
     * Также метод округляет полученное значение до двух знаков после запятой с помощью {@code RounderUtil}.
     *
     * @return псевдослучайное значение таланта, округленное до двух знаков после запятой.
     */
    public static double getRandomTalentValue() {
        double value = new Random().nextDouble(MIN_TALENT, MAX_TALENT + Double.MIN_VALUE);
        return RounderUtil.round(value, 2);
    }
}
