package cerlace.strategies;

import cerlace.dto.LearnStage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

abstract class StudyStrategyTest {

    protected StudyStrategy studyStrategy;

    protected int expectedStudyTimeMultiplier;
    protected List<LearnStage> expectedLearnStages;

    @Test
    void correctStudyTimeMultiplierTest() {
        Assertions.assertEquals(expectedStudyTimeMultiplier, studyStrategy.getStudyTimeMultiplier());
    }

    @Test
    void correctLearnStagesTest() {
        List<LearnStage> testedLearnStages = studyStrategy.getLearnStages();
        for (int i = 0; i < testedLearnStages.size(); i++) {
            LearnStage testedStage = testedLearnStages.get(i);
            LearnStage expectedStage = expectedLearnStages.get(i);
            Assertions.assertEquals(expectedStage, testedStage);
        }
    }

    abstract void studyTest();
}
