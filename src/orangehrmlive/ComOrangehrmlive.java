package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-2 - ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */

public class ComOrangehrmlive {

    static String browser = "Chrome";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/\n";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("Firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        }else {
            System.out.println("Wrong browser name");
        }
        //Open Url
        driver.get(baseUrl);
        //Maximise the browser
        driver.manage().window().maximize();
        //Implicit wait timing to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Print the title page
        String title = driver.getTitle();
        System.out.println("The title of the page: " + title);
        //Print the current Url
        System.out.println(driver.getCurrentUrl());
        //Print the page source
        System.out.println("The page source of the current URL is: " + driver.getPageSource());
        //Click on the forgot password link
        WebElement forgetPasswordLink = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[4]/p"));
        forgetPasswordLink.click();
        Thread.sleep(2000);
        //Print current URL
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        //Navigate back to login page
        driver.navigate().to(baseUrl);
        Thread.sleep(2000);
        //Refresh the page
        driver.navigate().refresh();
        //Enter the email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("Admin");
        Thread.sleep(2000);
        //Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        //Click on login button
        WebElement login = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
        login.click();
        Thread.sleep(2000);
        //Close the Browser
        driver.quit();


    }



}
