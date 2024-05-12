package demo;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@aria-describedby='i2 i3']")).sendKeys("Soubhagya Das");
        driver.findElement(By.xpath("//textarea[@aria-labelledby='i5']")).sendKeys("I want to be the best QA Engineer! "+String.valueOf(System.currentTimeMillis()));
        driver.findElement(By.xpath("(//div[contains(@class,'AB7Lab Id5V1')])[1]")).click();
        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'uHMk6b fsHoPb')]"));
        for (WebElement webElement : options) {
            webElement.click();
        }
        driver.findElement(By.xpath("//span[text()='Choose']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@role='option' and @data-value='Mr']")).click();
        Thread.sleep(5000);
        LocalDate todaydate = LocalDate.now();
        LocalDate newdate = todaydate.minusDays(7);
        String datestr= String.valueOf(newdate);
        String[] arr1= datestr.split("-");
        List<String> arrList = new ArrayList<>();
        arrList = Arrays.asList(arr1);
         Actions actions = new Actions(driver);
         actions.moveToElement(driver.findElement(By.xpath("//input[@type='date']"))).click();
         actions.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).keyUp(Keys.SHIFT);
         actions.sendKeys(arrList.get(2)).sendKeys(arrList.get(1)).sendKeys(arrList.get(0));
         //actions.build().perform();
         
        
        DateFormat format = new SimpleDateFormat("hh mm aa");
        String time = format.format(new Date()).toString();
        String[] arr2= time.split(" ");
        List<String> arrList01 = new ArrayList<>();
        arrList01 = Arrays.asList(arr2);
        actions.moveToElement(driver.findElement(By.xpath("(//input[@type='text'])[2]"))).click();
        actions.sendKeys(arrList01.get(0));
        actions.moveToElement(driver.findElement(By.xpath("(//input[@type='text'])[3]"))).click();
        actions.sendKeys(arrList01.get(1));
        actions.build().perform();
        Thread.sleep(5000);
        //driver.get("https://www.amazon.in/");
        //9th step pop-up is not coming in UI that's why I'm skipping the 9th step
        driver.findElement(By.xpath("//span[text()='Submit']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.className("vHW8K")).getText());
        System.out.println("end Test case: testCase02");
    }


}
