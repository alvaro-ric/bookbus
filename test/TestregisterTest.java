
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class TestregisterTest {

    WebDriver driver;

    public void invokeBrowser() {
        try {
            System.setProperty("webdriver.chrome.driver", "D:\\Exe\\Jar\\selenium\\chromedriver.exe");
//            ChromeOptions options = new  ChromeOptions();
//            options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//            driver.get("http://localhost:8080/BookBus/register.jsp");

            registerCompany();
            Thread.sleep(1000);
            adminOperation();
            Thread.sleep(1000);
            managerOperation();
            completeRegistration();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerCompany() {
        driver.get("http://localhost:8080/BookBus/register.jsp");
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.findElement(By.id("firstName")).click();
        driver.findElement(By.id("firstName")).sendKeys("alvaro");
        driver.findElement(By.id("lastName")).click();
        driver.findElement(By.id("lastName")).sendKeys("iradukunda");
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("alvaro@gmail.com");
        driver.findElement(By.id("phoneNumber")).click();
        driver.findElement(By.id("phoneNumber")).sendKeys("0788");
        driver.findElement(By.id("companyName")).click();
        driver.findElement(By.id("companyName")).sendKeys("alvaro");
        driver.findElement(By.id("companySize")).click();
        {
            WebElement dropdown = driver.findElement(By.id("companySize"));
            dropdown.findElement(By.xpath("//option[. = '11 - 50']")).click();
        }
        driver.findElement(By.id("companySize")).click();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.id("passwordConfirm")).click();
        driver.findElement(By.id("passwordConfirm")).sendKeys("123456789");
        driver.findElement(By.cssSelector(".py-3")).click();
//        driver.close();
    }

//    public void adminlogin() {
//        driver.get("http://localhost:8080/BookBus/register.jsp");
//        driver.manage().window().setSize(new Dimension(1366, 768));
//        driver.findElement(By.id("firstName")).click();
//        driver.findElement(By.id("firstName")).sendKeys("alvaro");
//        driver.findElement(By.id("lastName")).click();
//        driver.findElement(By.id("lastName")).sendKeys("iradukunda");
//        driver.findElement(By.id("email")).click();
//        driver.findElement(By.id("email")).sendKeys("alvaro@gmail.com");
//        driver.findElement(By.id("phoneNumber")).click();
//        driver.findElement(By.id("phoneNumber")).sendKeys("0788");
//        driver.findElement(By.id("companyName")).click();
//        driver.findElement(By.id("companyName")).sendKeys("alvaro");
//        driver.findElement(By.id("companySize")).click();
//        {
//            WebElement dropdown = driver.findElement(By.id("companySize"));
//            dropdown.findElement(By.xpath("//option[. = '11 - 50']")).click();
//        }
//        driver.findElement(By.id("companySize")).click();
//        driver.findElement(By.id("password")).click();
//        driver.findElement(By.id("password")).sendKeys("123456789");
//        driver.findElement(By.id("passwordConfirm")).click();
//        driver.findElement(By.id("passwordConfirm")).sendKeys("123456789");
//        driver.findElement(By.cssSelector(".py-3")).click();
////        driver.close();
//    }
    public void managerOperation() {
        driver.get("http://localhost:8080/BookBus/login.jsp");
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.findElement(By.name("email")).sendKeys("alvaro@gmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("123456789");
        driver.findElement(By.cssSelector(".bg-indigo-500")).click();
        driver.findElement(By.cssSelector("div:nth-child(1) > .w-full")).click();
        driver.findElement(By.linkText("Add account")).click();
        driver.findElement(By.id("departuredate")).click();
        driver.findElement(By.id("departuredate")).sendKeys("murenzi");
        driver.findElement(By.id("departuretime")).click();
        driver.findElement(By.id("departuretime")).sendKeys("jack");
        driver.findElement(By.name("phonenumber")).click();
        driver.findElement(By.name("phonenumber")).sendKeys("07845222222");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("murenzi@gmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("987654321");
        driver.findElement(By.name("password2")).click();
        driver.findElement(By.name("password2")).sendKeys("987654321");
        driver.findElement(By.cssSelector(".inline-flex")).click();
        driver.findElement(By.cssSelector("div:nth-child(1) > .w-full")).click();
        driver.findElement(By.linkText("Manage Accounts")).click();
        driver.findElement(By.linkText("Approve")).click();
        driver.findElement(By.cssSelector("div:nth-child(2) > .w-full")).click();
        driver.findElement(By.linkText("Request Route")).click();
        driver.findElement(By.cssSelector(".border-b:nth-child(1) .w-4")).click();
        driver.findElement(By.cssSelector(".border-b:nth-child(2) path")).click();
        driver.findElement(By.cssSelector("div:nth-child(3) > .w-full")).click();
        driver.findElement(By.cssSelector("div:nth-child(2) > .w-full")).click();
        driver.findElement(By.linkText("All Routes")).click();
        driver.findElement(By.cssSelector("div:nth-child(3) > .w-full")).click();
        driver.findElement(By.linkText("Add Journey")).click();
        driver.findElement(By.id("route")).click();
        driver.findElement(By.cssSelector("div:nth-child(4) > .w-full > .flex")).click();
        driver.findElement(By.cssSelector("div:nth-child(5) > .w-full > .flex")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.close();
    }

    public void adminOperation() {
        driver.get("http://localhost:8080/BookBus/adminlogin.jsp");

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("super@gmail.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("super@pass");
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("div:nth-child(3) > .w-full .h-4")).click();
        driver.findElement(By.linkText("All Companies")).click();
        driver.findElement(By.linkText("Approve")).click();
        driver.findElement(By.cssSelector(".border-b:nth-child(2) .focus\\3Aoutline-none:nth-child(2)")).click();
        driver.findElement(By.linkText("Approve")).click();
        driver.findElement(By.linkText("Details")).click();
        driver.findElement(By.cssSelector("div:nth-child(2) > .w-full")).click();
        driver.findElement(By.linkText("All Routes")).click();
        driver.findElement(By.id("source")).click();
        driver.findElement(By.id("source")).sendKeys("kigali");
        driver.findElement(By.id("destination")).click();
        driver.findElement(By.id("destination")).sendKeys("rwamagana");
        driver.findElement(By.cssSelector(".inline-flex")).click();
        driver.findElement(By.id("source")).click();
        driver.findElement(By.id("source")).sendKeys("muhanga");
        driver.findElement(By.id("destination")).click();
        driver.findElement(By.id("destination")).sendKeys("huye");
        driver.findElement(By.cssSelector(".inline-flex")).click();
        driver.close();
    }

//    public void addCoursesThenViewDetails(){
//        List<WebElement> elements = driver.findElements(By.className("course"));
//        elements.get(2).click();
//        elements.get(4).click();
//        elements.get(6).click();
//        driver.findElement(By.className("view__details")).click();
//    }
//    public void addCoursesThenComplete(){
//        List<WebElement> elements = driver.findElements(By.className("course"));
//        elements.get(2).click();
//        elements.get(4).click();
//        elements.get(6).click();
//        driver.findElement(By.className("complete__registation")).click();
//    }
    public void completeRegistration() {
        driver.findElement(By.className("complete")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        }
        driver.findElement(By.id("register")).click();
    }

    public void register() {
        driver.findElement(By.id("register")).click();
    }

    public void testGoingBack() {
        driver.findElement(By.className("back")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {

        }
//        addCoursesThenViewDetails();
        completeRegistration();
    }

    public static void main(String[] args) {
        TestregisterTest test = new TestregisterTest();
        test.invokeBrowser();
    }
}
