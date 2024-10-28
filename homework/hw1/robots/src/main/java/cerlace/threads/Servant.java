package cerlace.threads;

import cerlace.managment.Dump;
import cerlace.managment.MadScientist;
import cerlace.threads.utils.RandomCountUtil;

public class Servant implements Runnable {

    private static final int NIGHTS_COUNT = 100;
    private static final int NIGHT_DURATION = 100;
    private final MadScientist madScientist;
    private final Dump dump;

    /**
     * Конструктор создает объект прислужника.
     *
     * @param madScientist содержит ссылку на ученого, которому
     *                     прислужник должен приносить детали.
     * @param dump         содержит ссылку на свалку, на которой
     *                     прислужник ищет детали.
     */
    public Servant(MadScientist madScientist, Dump dump) {
        this.madScientist = madScientist;
        this.dump = dump;
    }

    /**
     * Метод имитирует работу прислужника по сбору
     * частей роботов со свалки {@link #dump}, и
     * передачи частей ученому {@link #madScientist}
     * в течении {@link #NIGHTS_COUNT} ночей, каждая из
     * которых длится {@link #NIGHT_DURATION} мс.
     */
    @Override
    public void run() {
        for (int i = 0; i < NIGHTS_COUNT; i++) {
            int partsCount = RandomCountUtil.getCount();
            for (int j = 0; j < partsCount; j++) {
                synchronized (dump) {
                    if (!dump.isEmpty()) {
                        madScientist.addPartToStorage(dump.takeRandomPart());
                    } else {
                        break;
                    }
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
