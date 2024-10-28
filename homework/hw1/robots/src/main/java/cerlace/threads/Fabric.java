package cerlace.threads;

import cerlace.managment.Dump;
import cerlace.managment.enums.RobotPart;
import cerlace.threads.utils.RandomCountUtil;

public class Fabric implements Runnable {
    private static final int NIGHTS_COUNT = 100;
    private static final int NIGHT_DURATION = 100;
    private final Dump dump;

    /**
     * Конструктор создает объект фабрики.
     *
     * @param dump содержит ссылку на свалку, на которую
     *             фабрика выбрасывает детали.
     */
    public Fabric(Dump dump) {
        this.dump = dump;
    }

    /**
     * Метод имитирует работу фабрики по выбрасыванию
     * частей роботов на свалку {@link #dump}
     * в течении {@link #NIGHTS_COUNT} ночей, каждая из
     * которых длится {@link #NIGHT_DURATION} мс.
     */
    @Override
    public void run() {
        for (int i = 0; i < NIGHTS_COUNT; i++) {
            int partsCount = RandomCountUtil.getCount();
            for (int j = 0; j < partsCount; j++) {
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
}
