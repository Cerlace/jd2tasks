package cerlace.strategies;

import cerlace.dto.LearnStage;
import cerlace.strategies.impl.StrategyTypeOne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Map;

class StudyStrategyOneTest extends StudyStrategyTest {

    @BeforeEach
    void init() {
        studyStrategy = new StrategyTypeOne();
        expectedStudyTimeMultiplier = 1;

        expectedLearnStages = new ArrayList<>();
        expectedLearnStages.add(LearnStage.ANALISE);
        expectedLearnStages.add(LearnStage.PRACTICE);
        expectedLearnStages.add(LearnStage.LECTURE);
    }
    @Test
    @Override
    void studyTest() {
        Map<LearnStage, Double> testedMap = studyStrategy.study(30, 1);
        Assertions.assertEquals(10, testedMap.get(LearnStage.ANALISE));
        Assertions.assertEquals(10, testedMap.get(LearnStage.PRACTICE));
        Assertions.assertEquals(10, testedMap.get(LearnStage.LECTURE));
    }
}
