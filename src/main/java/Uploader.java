import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;


public class Uploader {
    private static WebDriver driver = null;

    //TODO this is a crap way of doing constants. Just a demo though so it will do
    private static final String EMAIL = "someemail@fakeemail.com";
    private static final String PASSWORD = "somesupersecretpassword";
    private static final String CV_PATH = "/Users/thomassquires/Downloads/test.txt";

    public static void main(String[] args) {
        System.out.print(String.format("Uploading %s to http://www.reed.co.uk", CV_PATH));
        driver = new FirefoxDriver();
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.reed.co.uk/");

        //Login
        driver.findElement(By.id("topSignInLink")).click();
        driver.findElement(By.id("topSignInEmail")).sendKeys(EMAIL);
        driver.findElement(By.id("topSignInPassword")).sendKeys(PASSWORD);
        driver.findElement(By.id("topSignInPassword")).submit();

        driver.get("https://www.reed.co.uk/account/cvandcoverletter");

        driver.findElement(By.className("icon-pc-small")).click();
        WebElement upload = driver.findElement(By.id("cvUploadBtn"));
        upload.sendKeys(CV_PATH);
    }
}
