package framework.configuration;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConfigData {
    private String baseUrl;
    private int timeout;
    private int shortTimeout;
    private String browser;
    private boolean startMaximized;
    private String language;
    private List<String> chromeArguments;
    private List<String> firefoxArguments;
}