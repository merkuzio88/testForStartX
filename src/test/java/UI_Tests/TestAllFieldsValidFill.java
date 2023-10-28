package UI_Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import settings.DesktopCaps;
import ui_activity.AuthFieldSteps;

@ExtendWith(DesktopCaps.class)
public class TestAllFieldsValidFill {

    @Test
    void testAllFieldsValidFill() {
        new AuthFieldSteps()
                .openAuthPage()
                .fillAllFieldsValid()
                .checkModalWindowSuccess();
    }
}
