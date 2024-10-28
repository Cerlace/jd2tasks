package cerlace.managment;

import cerlace.managment.enums.RobotPart;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MadScientist {
    private final Map<RobotPart, Integer> partsStorage = new HashMap<>();

    /**
     * Метод добавляет деталь в хранилище {@link #partsStorage}.
     *
     * @param part деталь, добавляемая в хранилище.
     */
    public void addPartToStorage(RobotPart part) {
        if (partsStorage.containsKey(part)) {
            int count = partsStorage.get(part) + 1;
            partsStorage.replace(part, count);
        } else {
            partsStorage.put(part, 1);
        }
    }

    /**
     * Метод возвращает колличество роботов,
     * которых можно собрать из деталей,
     * хранящихся в {@link #partsStorage}.
     *
     * @return колличество собранных роботов.
     */
    public int assembleRobots() {
        for (RobotPart robotPart : RobotPart.values()) {
            if (!partsStorage.containsKey(robotPart)) {
                return 0;
            }
        }
        return Collections.min(partsStorage.values());
    }
}
