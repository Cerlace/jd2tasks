package cerlace.utils;

/**
 * Класс {@code RounderUtil} являтся утилитарным классом, содержащим
 * методы для округления чисел с плавающей точкой.
 */
public class RounderUtil {

    private RounderUtil() {
    }

    /**
     * Метод округляет число с плавающей точкой до указанного
     * колличества знаков после запятой.
     *
     * @param number        число для округления;
     * @param decimalPlaces колличество знаков после запятой;
     * @return округленное число.
     */
    public static double round(double number, int decimalPlaces) {
        double roundCoefficient = Math.pow(10, decimalPlaces);
        return Math.round(number * roundCoefficient) / roundCoefficient;
    }
}
