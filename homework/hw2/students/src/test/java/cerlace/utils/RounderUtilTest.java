package cerlace.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RounderUtilTest {

    @Test
    void roundTest() {
        double expected = 30.02;
        double tested = RounderUtil.round(30.02111332, 2);
        Assertions.assertEquals(expected,tested);
    }

}
