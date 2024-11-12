package cerlace.utils;

import cerlace.dto.LearnStage;
import cerlace.dto.Skill;
import cerlace.strategies.impl.StrategyTypeThree;
import cerlace.students.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class PrintInfoUtilTest {
    private final PrintStream systemdOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(systemdOut);
    }

    @Test
    void printStudyInfoTest() {
        Map<LearnStage, Double> testMap = Map.of(LearnStage.LECTURE, 100.00);
        String expected =
                        "Лекции завершены за 100,00 часа.\n" +
                        "Полное обучение заняло 100,00 часа.\n";

        PrintInfoUtil.printStudyInfo(testMap);
        String testedString = outputStreamCaptor.toString().replace("\r\n", "\n");

        Assertions.assertEquals(expected, testedString);
    }

    @Test
    void printFullInfoOneStudentTest() {
        Student testStudent = new Student(new StrategyTypeThree());
        testStudent.setTalent(1.0);
        Skill testSkill = new Skill("Test Skill", 100);
        String expected =
                        "Студент, учащийся по стратегии \"Только практика\" с талантом 1,00.\n" +
                        "Практические занятия завершены за 300,00 часа.\n" +
                        "Полное обучение заняло 300,00 часа.\n" +
                        "-------------------------------------------\n";

        PrintInfoUtil.printFullInfo(testStudent, testSkill);
        String testedString = outputStreamCaptor.toString().replace("\r\n", "\n");

        Assertions.assertEquals(expected, testedString);
    }

    @Test
    void printFullInfoManyStudentsTest() {
        Student testStudent = new Student(new StrategyTypeThree());
        testStudent.setTalent(1.0);
        List<Student> testStudents = List.of(testStudent, testStudent);
        Skill testSkill = new Skill("Test Skill", 100);
        String expected =
                "-------------------------------------------\n" +
                "Навык: Test Skill, на освоение необходимо минимум 100,00 часов.\n" +
                "-------------------------------------------\n" +
                "Студент, учащийся по стратегии \"Только практика\" с талантом 1,00.\n" +
                "Практические занятия завершены за 300,00 часа.\n" +
                "Полное обучение заняло 300,00 часа.\n" +
                "-------------------------------------------\n" +
                "Студент, учащийся по стратегии \"Только практика\" с талантом 1,00.\n" +
                "Практические занятия завершены за 300,00 часа.\n" +
                "Полное обучение заняло 300,00 часа.\n" +
                "-------------------------------------------\n";

        PrintInfoUtil.printFullInfo(testStudents, testSkill);
        String testedString = outputStreamCaptor.toString().replace("\r\n", "\n");

        Assertions.assertEquals(expected, testedString);
    }
}
