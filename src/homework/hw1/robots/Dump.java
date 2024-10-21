package homework.hw1.robots;

import java.util.ArrayList;
import java.util.List;

public class Dump {
    private final List<RobotPart> dump = new ArrayList<>();

    public void addPart(RobotPart part) {
        dump.add(part);
    }

    public RobotPart takeRandomPart() {
        int partIndex = (int) (Math.random() * dump.size());
        RobotPart robotPart = dump.get(partIndex);
        dump.remove(partIndex);
        return robotPart;
    }

    public boolean isEmpty() {
        return dump.isEmpty();
    }
}
