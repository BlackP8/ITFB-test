package library.utils;

import library.driver.DriverFactory;

/**
 * @author - Pavel Romanov
 */

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

    public static void closeTab() {
        DriverFactory.getInstance().close();
    }

    public static void switchToPreviousTab() {;
        DriverFactory.getInstance().switchTo().window(originalWindow);
    }
}
