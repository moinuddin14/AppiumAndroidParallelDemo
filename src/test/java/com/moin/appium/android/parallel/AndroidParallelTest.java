package com.moin.appium.android.parallel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by moin
 * on February, 2020
 **/
public class AndroidParallelTest {

    AppiumDriver<MobileElement> driver = null;

    @BeforeTest(alwaysRun = true)
    @Parameters({"platform", "udid", "systemPort", "port"})
    public void setup(String platform, String udid, String systemPort, String port) throws Exception {
//        URL url = new URL("http://127.0.0.1:"+port+"/wd/hub");
        URL url = new URL("http://127.0.0.1:4727/wd/hub");
        String[] platformInfo = platform.split(" ");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformInfo[0]);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformInfo[1]);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, systemPort);
        capabilities.setCapability(MobileCapabilityType.ORIENTATION, "PORTRAIT");
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/moin/Downloads/demo.apk");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        driver = new AndroidDriver<MobileElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testMethod() throws InterruptedException {
        Thread.sleep(20000);
        driver.findElementById("android:id/switch_widget").click();
        System.out.println("Accessibility Title... "+driver.findElementById("android:id/title").getText());
        Thread.sleep(20000);
    }

    @AfterTest(alwaysRun = true)
    public void teardown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
