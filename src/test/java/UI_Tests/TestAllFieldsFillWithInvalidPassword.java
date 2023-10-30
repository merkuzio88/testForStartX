package UI_Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import settings.DesktopCaps;
import ui_activity.AuthFieldSteps;

/**
 * Тест проверки валидации некорректного пароля
 * <p>
 * * 1. Открываем страницу авторизации
 * * 2. Заполняем валидными данными все поля кроме поля password
 * * 3. Проверяем сообщение о некорректных данных
 */
@ExtendWith(DesktopCaps.class)
public class TestAllFieldsFillWithInvalidPassword {

    @Test
    void testAllFieldsFillWithInvalidPassword() {
        new AuthFieldSteps()
                .openAuthPage()
                .fillAllFieldsWithInvalidPassword()
                .checkPasswordError();
    }
}
