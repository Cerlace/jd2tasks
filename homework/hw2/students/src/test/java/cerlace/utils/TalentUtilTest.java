package cerlace.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TalentUtilTest {

    @Test
    void getRandomTalentValueTest() {
        double talentMin = 0.1;
        double talentMax = 1;

        for (int i = 0; i < 100; i++) {
            double tested = TalentUtil.getRandomTalentValue();
            Assertions.assertTrue(tested >= talentMin && tested <= talentMax);
        }
    }
}
