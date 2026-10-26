package framework.utils;

import net.datafaker.Faker;

public class TextGenerator {

    private static final Faker faker = new Faker();

    private TextGenerator() {
    }

    public static String getGeneratedText(int length) {
        LoggerUtil.info("Generate text with length {}", length);
        return faker.lorem().characters(length, false);
    }
}