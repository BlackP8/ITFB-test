package library.driver;

import library.utils.ConfigUtil;

/**
 * @author - Pavel Romanov
 */

public enum Browsers {
    FIREFOX(ConfigUtil.getConfProperty("firefoxBrowser")),
    CHROME(ConfigUtil.getConfProperty("chromeBrowser"));

    private final String browser;

    Browsers(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }
}
