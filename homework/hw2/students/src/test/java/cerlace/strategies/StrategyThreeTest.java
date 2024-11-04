package cerlace.strategies;

import cerlace.dto.LearnStage;
import cerlace.strategies.impl.StrategyTypeThree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class StrategyThreeTest extends StudyStrategyTest {

    @BeforeEach
    void init() {
        studyStrategy = new StrategyTypeThree();
    }

    @Test
    @Override
    void studyTest() {
        Map<LearnStage, Double> testedMap = studyStrategy.study(30, 1);
        Assertions.assertEquals(90, testedMap.get(LearnStage.PRACTICE));
    }
}
