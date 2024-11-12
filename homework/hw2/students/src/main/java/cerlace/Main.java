package cerlace;

import cerlace.dto.Skill;
import cerlace.strategies.StudyStrategy;
import cerlace.strategies.impl.StrategyTypeOne;
import cerlace.strategies.impl.StrategyTypeThree;
import cerlace.strategies.impl.StrategyTypeTwo;
import cerlace.students.Student;
import cerlace.utils.PrintInfoUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Skill javaCore = new Skill("JavaCore", 198);

        List<StudyStrategy> strategies = new ArrayList<>();
        strategies.add(new StrategyTypeOne());
        strategies.add(new StrategyTypeTwo());
        strategies.add(new StrategyTypeThree());

        List<Student> students = new ArrayList<>();

        for (StudyStrategy strategy : strategies) {
            for (int i = 0; i < 3; i++) {
                students.add(new Student(strategy));
            }
        }

        PrintInfoUtil.printFullInfo(students, javaCore);
    }
}
