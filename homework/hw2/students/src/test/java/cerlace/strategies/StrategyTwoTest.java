package cerlace.strategies;

import cerlace.dto.LearnStage;
import cerlace.strategies.impl.StrategyTypeTwo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class StrategyTwoTest extends StudyStrategyTest {

    @BeforeEach
    void init() {
        studyStrategy = new StrategyTypeTwo();
    }

    @Test
    @Override
    void studyTest() {
        Map<LearnStage, Double> testedMap = studyStrategy.study(30, 1);
        Assertions.assertEquals(30, testedMap.get(LearnStage.ANALISE));
        Assertions.assertEquals(30, testedMap.get(LearnStage.PRACTICE));
    }
}
