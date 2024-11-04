package cerlace.students;

import cerlace.dto.Skill;
import cerlace.strategies.StudyStrategy;
import cerlace.utils.TalentUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StudentTest {

    @Test
    void learnSkillTest() {
        StudyStrategy studyStrategy = Mockito.mock(StudyStrategy.class);

        double testTalent = 1;
        Skill testSkill = new Skill("Test skill", 30);
        Student student = new Student(studyStrategy);
        student.setTalent(testTalent);

        student.learnSkill(testSkill);

        Mockito.verify(studyStrategy).study(testSkill.getHoursToLearn(), testTalent);
    }
}
