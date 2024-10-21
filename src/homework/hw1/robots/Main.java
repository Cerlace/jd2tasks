package homework.hw1.robots;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        Dump dump = new Dump();

        for (int i = 0; i < 20; i++) {
            dump.addPart(RobotPart.getRandomPart());
        }

        MadScientist firstScientist = new MadScientist();
        MadScientist secondScientist = new MadScientist();

        Thread fabric = new Thread(new Fabric(dump));
        Thread firstServant = new Thread(new Servant(firstScientist, dump));
        Thread secondServant = new Thread(new Servant(secondScientist, dump));

        fabric.start();
        firstServant.start();
        secondServant.start();
        System.out.println("Фабрика начала работать, отправяем прислужников...");

        try {
            fabric.join();
            firstServant.join();
            secondServant.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int firstResult = firstScientist.assembleRobots();
        int secondResult = secondScientist.assembleRobots();
        System.out.printf("Первый ученый собрал %d роботов!\n", firstResult);
        System.out.printf("Второй ученый собрал %d роботов!\n", secondResult);
        if (firstResult > secondResult) {
            System.out.println("Победил первый ученый!");
        } else if (firstResult < secondResult) {
            System.out.println("Победил второй ученый!");
        } else {
            System.out.println("Ничья!");
        }
    }
}