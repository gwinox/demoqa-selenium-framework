package framework.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import framework.utils.LoggerUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class JsonReader {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonReader() {
    }

    public static <T> T deserialization(String filePath, Class<T> valueType) {
        LoggerUtil.info("Start reading JSON file: {}", filePath);

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);

        try {
            if (inputStream != null) {
                LoggerUtil.info("File {} found in resources. Reading as stream...", filePath);
                try (inputStream) {
                    return MAPPER.readValue(inputStream, valueType);
                }
            } else {
                LoggerUtil.info("File {} not found in resources. Trying to read by direct path...", filePath);
                return MAPPER.readValue(new File(filePath), valueType);
            }
        } catch (IOException e) {
            LoggerUtil.error("Failed to read JSON file: " + filePath, e);
            throw new IllegalStateException("Failed to read JSON file: " + filePath, e);
        }
    }
}