package UI_Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import settings.DesktopCaps;
import ui_activity.AuthFieldSteps;

/**
 * Тест проверки валидации некорректного имени
 * <p>
 * * 1. Открываем страницу авторизации
 * * 2. Заполняем валидными данными все поля кроме поля userName
 * * 3. Проверяем сообщение о некорректных данных
 */
@ExtendWith(DesktopCaps.class)
public class TestAllFieldsFillWithInvalidName {

    @Test
    void testAllFieldsFillWithInvalidName() {
        new AuthFieldSteps()
                .openAuthPage()
                .fillAllFieldsWithInvalidName()
                .checkNameError();
    }
}
