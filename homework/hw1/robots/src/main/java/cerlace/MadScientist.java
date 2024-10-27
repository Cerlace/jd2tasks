package cerlace;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MadScientist {
    private final Map<RobotPart, Integer> partsStorage = new HashMap<>();

    public void addPartToStorage(RobotPart part) {
        if (partsStorage.containsKey(part)) {
            int count = partsStorage.get(part) + 1;
            partsStorage.replace(part, count);
        } else {
            partsStorage.put(part, 1);
        }
    }

    public int assembleRobots() {
        for (RobotPart robotPart : RobotPart.values()) {
            if (!partsStorage.containsKey(robotPart)) {
                return 0;
            }
        }
        return Collections.min(partsStorage.values());
    }
}
