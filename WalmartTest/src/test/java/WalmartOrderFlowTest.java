import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WalmartOrderFlowTest {

    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        //1. Open the Chrome browser
        driver = new ChromeDriver();

        //2. Input the Walmart page URL (https://www.walmart.com/)
        driver.get("https://www.walmart.com/");
        System.out.println("Open the Walmart URL");

        //3. Verify that the user is on the correct URL
        if (driver.getCurrentUrl().contains("https://www.walmart.com/"))
            //Passed
            System.out.println("The user is on the correct URL");

        else
            //Failed
            System.out.println("Invalid URL");

        Thread.sleep(2000);

        //3. Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(5000);
        System.out.println("Maximize the browser");

//        //4. Press and hold the PRESS AND HOLD button
//        WebElement captcha = driver.findElement(By.id("px-captcha"));
//        Actions actions = new Actions(driver);
//        actions.clickAndHold(captcha).perform();
//        Thread.sleep(15000);
//        actions.release().perform();

    }

    @Test (priority = 0)
    public void login() throws InterruptedException {

        //4. Click on the Sign in/Account button
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/span/header/nav/ul/li[2]/a")).click();
        Thread.sleep(2000);

        //5. Click on the Sign in or create account button
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div/span/header/nav/ul/li[2]/div/div/button")).click();
        Thread.sleep(7000);

        //4. Press and hold the PRESS AND HOLD button
        WebElement captcha = driver.findElement(By.id("px-captcha"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(captcha).perform();
        Thread.sleep(15000);
        actions.release().perform();


        //6. Select and enter a valid email address into the email address field
        driver.findElement(By.xpath("//*[@id=\"react-aria-1\"]")).sendKeys("Walmartboy@mailinator.com");
        Thread.sleep(2000);

        //7. Click on the continue button
        driver.findElement(By.xpath("//*[@id=\"login-continue-button\"]")).click();

        Thread.sleep(5000);
    }

/**
 * Test on hold because Walmart.com has technical issues and the captcha is not "captcha-ing".
 * Will continue another day
 */




}