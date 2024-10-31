package cerlace.students;

import cerlace.dto.LearnStage;
import cerlace.dto.Skill;
import cerlace.strategies.StudyStrategy;
import cerlace.utils.TalentUtil;

import java.util.Map;

/**
 * Класс {@code Student} является классом, реализующим
 * логику студента. Содержит поле {@link #talent}, содержащее
 * значение таланта студента, и поле {@link  #studyStrategy},
 * содержащее стратегию обучения.
 */
public class Student {

    private double talent;
    private StudyStrategy studyStrategy;

    /**
     * Конструктор создает объект студента, задает ему случайное значение
     * таланта с помощью {@code TalentUtil}, и стратегию обучения.
     *
     * @param studyStrategy стратегия обучения.
     */
    public Student(StudyStrategy studyStrategy) {
        this.talent = TalentUtil.getRandomTalentValue();
        this.studyStrategy = studyStrategy;
    }

    /**
     * Метод делегирует задачу по изучению навыка объекту {@link  #studyStrategy}.
     *
     * @param skill изучаемый навык;
     * @return {@code Map<LearnStage, Double>}, которая содержит
     * данные о времени, затраченном на каждую стадию обучения.
     */
    public Map<LearnStage, Double> learnSkill(Skill skill) {
        return studyStrategy.study(skill.getHoursToLearn(), talent);
    }

    @Override
    public String toString() {
        return String.format(
                "Студент, учащийся по стратегии \"%s\" с талантом %.2f.",
                studyStrategy, talent);
    }

    public double getTalent() {
        return talent;
    }

    public void setTalent(double talent) {
        this.talent = talent;
    }

    public void setStudyStrategy(StudyStrategy studyStrategy) {
        this.studyStrategy = studyStrategy;
    }

    public StudyStrategy getStudyStrategy() {
        return studyStrategy;
    }
}
