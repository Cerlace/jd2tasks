package homework.hw1.robots;

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

    public static RobotPart getRandomPart() {
        return values()[(int) (Math.random() * values().length)];
    }
}
