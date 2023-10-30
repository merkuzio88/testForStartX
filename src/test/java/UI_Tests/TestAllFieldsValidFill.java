package UI_Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import settings.DesktopCaps;
import ui_activity.AuthFieldSteps;

/**
 * Тест проверки заполнения всех полей валидными данными
 * <p>
 * * 1. Открываем страницу авторизации
 * * 2. Заполняем валидными данными все поля
 * * 3. Проверяем что появилась модалка ввода кода проверки
 */
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
