package demoqa.manager;

import demoqa.model.TestData;
import framework.configuration.JsonReader;

public class DataManager {
    private static final String FILE_PATH = "data.json";
    private static TestData testData;

    private DataManager() {
    }

    public static TestData getData() {
        if (testData == null) {
            testData = JsonReader.deserialization(FILE_PATH, TestData.class);
        }
        return testData;
    }
}
