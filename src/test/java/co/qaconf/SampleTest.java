package co.qaconf;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SampleTest {

    private AppiumDriver driver;

    @BeforeEach
    public void configuracionAppium() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554")
                .setPlatformVersion("11.0")
                .setAppPackage("com.google.android.youtube")
                .setAppActivity("com.google.android.youtube.HomeActivity")
                .setIsHeadless(true)
                .setAutoGrantPermissions(true);
        options.setCapability("skipHiddenApiCheck", true);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
    }


    @Test
    void sampleTestSerenity(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shortsButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//*[contains(@text,'Shorts')]"))
        );
        shortsButton.click();
    }
}