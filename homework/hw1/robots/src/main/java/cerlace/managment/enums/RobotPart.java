package cerlace.managment.enums;

import java.util.concurrent.ThreadLocalRandom;

public enum RobotPart {
    HEAD,
    BODY,
    LEFT_HAND,
    RIGHT_HAND,
    LEFT_LEG,
    RIGHT_LEG,
    CPU,
    RAM,
    HDD;

    /**
     * Метод возвращает случайную часть робота.
     *
     * @return случайная часть робота.
     */
    public static RobotPart getRandomPart() {
        int partIndex = ThreadLocalRandom.current().nextInt(values().length);
        return values()[partIndex];
    }
}
