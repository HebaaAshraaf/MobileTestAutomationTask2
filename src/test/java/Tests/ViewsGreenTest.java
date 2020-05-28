package Tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ViewsGreenTest {
    AndroidDriver driver;

    @BeforeTest
    public void launchingAUT() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("appuim-version", "1.15.1");
        caps.setCapability("Version", "7.0");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "Appium");
        caps.setCapability("appPackage", "com.example.android.apis");
        caps.setCapability("appActivity", "com.example.android.apis.ApiDemos");
        caps.setCapability("orientationg", "PORTRAIT");
        caps.setCapability("noReset", "true");

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    }

    @Test
    public void TestChooseTheGreenColor() {
        driver.findElementByXPath("//*[contains(@text,'Views')]").click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
                + ".instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "Spinner" + "\").instance(0))")).click();
        driver.findElementById("spinner1").click();
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)"
                + ".instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + "green" + "\").instance(0))")).click();
    }

    @AfterTest
    public void afterTest(){
        driver.closeApp();
    }
}
