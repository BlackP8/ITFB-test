package utils;

import driver.DriverFactory;

public class TabUtil {
    private static String originalWindow = DriverFactory.getInstance().getWindowHandle();

    public static void changeTab() {
        for (String windowHandle : DriverFactory.getInstance().getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                DriverFactory.getInstance().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static String getTabURL() {
        return DriverFactory.getInstance().getCurrentUrl();
    }

    public static void closeTab() {
        DriverFactory.getInstance().close();
    }

    public static void switchToPreviousTab() {;
        DriverFactory.getInstance().switchTo().window(originalWindow);
    }
}
