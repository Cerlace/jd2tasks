package cerlace.utils;

import cerlace.dto.LearnStage;
import cerlace.dto.Skill;
import cerlace.students.Student;

import java.util.List;
import java.util.Map;

/**
 * Класс {@code PrintInfoUtil} является утилитарным классом, содержащим
 * методы для вывода информации для задачи в консоль в удобном виде.
 */
public class PrintInfoUtil {

    private static final String SEPARATOR = "-------------------------------------------";

    private PrintInfoUtil() {
    }

    /**
     * Выводит в консоль полную информацию об обучении навыку группы студентов.
     *
     * @param students группа студентов;
     * @param skill    изучаемый навык.
     */
    public static void printFullInfo(List<Student> students, Skill skill) {
        System.out.println(SEPARATOR + "\n" + skill + "\n" + SEPARATOR);
        students.forEach((x) -> printFullInfo(x, skill));
    }

    /**
     * Выводит в консоль полную информацию об обучении навыку одного студента.
     *
     * @param student студент;
     * @param skill   изучаемый навык.
     */
    public static void printFullInfo(Student student, Skill skill) {
        System.out.println(student);
        printStudyInfo(student.learnSkill(skill));
        System.out.println(SEPARATOR);
    }

    /**
     * Выводит консоль информацию об этапах обучения.
     *
     * @param learnTimeMap {@code Map<LearnStage, Double>}, которая содержит
     *                     данные о времени, затраченном на каждую стадию.
     */
    public static void printStudyInfo(Map<LearnStage, Double> learnTimeMap) {
        StringBuilder studyReport = new StringBuilder();
        double timeForStudy = 0;
        for (LearnStage stage : learnTimeMap.keySet()) {
            double timeForStage = learnTimeMap.get(stage);
            studyReport.append(String.format("%s завершены за %.2f часа.\n", stage, timeForStage));
            timeForStudy += timeForStage;
        }
        studyReport.append(String.format("Полное обучение заняло %.2f часа.", timeForStudy));

        System.out.println(studyReport);
    }
}
