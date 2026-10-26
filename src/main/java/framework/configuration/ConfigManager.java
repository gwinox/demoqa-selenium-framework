package framework.configuration;

public class ConfigManager {
    private static final String FILE_PATH = "config.json";
    private static ConfigData configData;

    private ConfigManager() {
    }

    public static ConfigData getConfig() {
        if (configData == null) {
            configData = JsonReader.deserialization(FILE_PATH, ConfigData.class);
        }
        return configData;
    }
}
