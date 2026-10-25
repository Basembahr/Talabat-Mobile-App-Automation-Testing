package Base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class Page_Base {

        protected AndroidDriver driver;

        public Page_Base(AndroidDriver driver) {
            this.driver = driver;
        }

        public void Enter_Text(By elementLocator, String text) {

            waitUntilVisible(elementLocator);

            driver.findElement(elementLocator).sendKeys(text);
        }

        public void Click_Button(By elementLocator) {

            waitUntilClickable(elementLocator);

            driver.findElement(elementLocator).click();
        }

        public void waitUntilVisible(By elementLocator) {

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(30));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(elementLocator)
            );
        }

        public void waitUntilClickable(By elementLocator) {

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(30));

            wait.until(
                    ExpectedConditions.elementToBeClickable(elementLocator)
            );
        }

        public void waitUntilInvisible(By elementLocator) {

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(30));

            wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(elementLocator)
            );
        }

        public String Get_Text(By elementLocator) {

            waitUntilVisible(elementLocator);

            return driver.findElement(elementLocator).getText();
        }

        public boolean Is_Element_Displayed(By elementLocator) {

            try {
                WebDriverWait wait =
                        new WebDriverWait(driver, Duration.ofSeconds(5));

                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(elementLocator)
                );

                return true;

            } catch (TimeoutException e) {
                return false;
            }
        }

    public void Swipe_Filter_Bar_Left() {

        driver.executeScript(
                "mobile: swipeGesture",
                Map.of(
                        "left", 250,
                        "top", 420,
                        "width", 650,
                        "height", 150,
                        "direction", "left",
                        "percent", 0.40
                )
        );
    }


    }

