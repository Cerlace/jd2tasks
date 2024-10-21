package homework.hw1.robots;

public class Fabric implements Runnable {
    private static final int RANDOM_COUNT_MIN = 1;
    private static final int RANDOM_COUNT_MAX = 4;
    private static final int NIGHTS_COUNT = 100;
    private static final int NIGHT_DURATION = 100;
    private final Dump dump;

    public Fabric(Dump dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int i = 0; i < NIGHTS_COUNT; i++) {
            for (int j = 0; j < randomCount(); j++) {
                synchronized (dump) {
                    dump.addPart(RobotPart.getRandomPart());
                }
            }
            try {
                Thread.sleep(NIGHT_DURATION);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int randomCount() {
        return (int) (Math.random() * RANDOM_COUNT_MAX) + RANDOM_COUNT_MIN;
    }
}
