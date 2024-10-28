package cerlace.managment;

import cerlace.managment.enums.RobotPart;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Dump {
    private static final int STARTED_PARTS_COUNT = 20;
    private final List<RobotPart> dump;

    /**
     * Конструктор создает объект свалки,
     * и вызывает метод {@link #initializeDump()},
     * для получения начального состояния свалки.
     */
    public Dump() {
        this.dump = initializeDump();
    }

    /**
     * Метод добавляет деталь на свалку {@link #dump}.
     *
     * @param part деталь, добавляемая на свалку.
     */
    public void addPart(RobotPart part) {
        dump.add(part);
    }

    /**
     * Метод выбирает случайную часть работа
     * из {@link #dump}, и удаляет ее.
     *
     * @return случаная часть из свалки.
     */
    public RobotPart takeRandomPart() {
        int partIndex = ThreadLocalRandom.current().nextInt(dump.size());
        RobotPart robotPart = dump.get(partIndex);
        dump.remove(partIndex);
        return robotPart;
    }

    /**
     * Метод проверяет {@link #dump} на
     * наличие элементов.
     *
     * @return true, если свалка пуста.
     */
    public boolean isEmpty() {
        return dump.isEmpty();
    }

    /**
     * Метод возвращает список, заполненный
     * {@link #STARTED_PARTS_COUNT} случайных частей роботов.
     *
     * @return List<RobotPart>, заполненный начальными значениями.
     */
    private List<RobotPart> initializeDump() {
        List<RobotPart> dumpWithParts = new ArrayList<>();
        for (int i = 0; i < STARTED_PARTS_COUNT; i++) {
            dumpWithParts.add(RobotPart.getRandomPart());
        }
        return dumpWithParts;
    }

}
