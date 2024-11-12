package cerlace.strategies;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


abstract class StudyStrategyTest {

    protected StudyStrategy studyStrategy;

    @Test
    void learnStagesExistTest() {
        int testedLearnStagesSize = studyStrategy.getLearnStages().size();
        int unexpectedLearnStagesSize = 0;
        Assertions.assertNotEquals(unexpectedLearnStagesSize, testedLearnStagesSize);
    }

    abstract void studyTest();
}
