package settings;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class PropertiesReader {

    public static String getProperties(String key) {
        Properties properties = new Properties();
        try (InputStream inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream("dynamic.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                log.error("Файл не найден в classpath");
            }
        } catch (IOException e) {
            log.error("Ошибка при чтении файла", e);
        }
        return properties.getProperty(key);
    }
}