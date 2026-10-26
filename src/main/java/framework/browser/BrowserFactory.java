package framework.browser;

import framework.configuration.ConfigManager;
import framework.utils.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

public class BrowserFactory {

    private BrowserFactory() {
    }

    public static WebDriver createDriver() {
        String browser = ConfigManager.getConfig().getBrowser().toLowerCase();
        boolean startMaximized = ConfigManager.getConfig().isStartMaximized();
        String language = ConfigManager.getConfig().getLanguage();

        LoggerUtil.info("Create {} driver", browser);

        WebDriver driver;

        switch (browser) {

            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                List<String> chromeArgs = ConfigManager.getConfig().getChromeArguments();
                if (chromeArgs != null && !chromeArgs.isEmpty()) {
                    chromeOptions.addArguments(chromeArgs);
                }
                if (language != null && !language.isEmpty()) {
                    chromeOptions.addArguments("--lang=" + language);
                }
                driver = new ChromeDriver(chromeOptions);
            }

            case "firefox" -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                List<String> firefoxArgs = ConfigManager.getConfig().getFirefoxArguments();
                if (firefoxArgs != null && !firefoxArgs.isEmpty()) {
                    firefoxOptions.addArguments(firefoxArgs);
                }

                if (language != null && !language.isEmpty()) {
                    firefoxOptions.addPreference("intl.accept_languages", language);
                }
                driver = new FirefoxDriver(firefoxOptions);
            }

            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        if (startMaximized) {
            driver.manage().window().maximize();
        }

        return driver;
    }
}