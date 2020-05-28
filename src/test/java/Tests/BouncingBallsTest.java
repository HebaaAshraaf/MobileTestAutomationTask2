package Tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BouncingBallsTest {
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
    public void TestTheTouchSwipeAction() {
        driver.findElementByXPath("//*[contains(@text,'Animation')]").click();
        driver.findElementByXPath("//*[contains(@text,'Bouncing Balls')]").click();
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(300,300))
                .waitAction(new WaitOptions().withDuration(Duration.ofMillis(2000)))
                .moveTo(PointOption.point(600, 600))
                .release()
                .perform();
    }

    @AfterTest
    public void afterTest(){
        driver.closeApp();
    }
}
