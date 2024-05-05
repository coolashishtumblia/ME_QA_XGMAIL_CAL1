package demo;

import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");
        String url=driver.getCurrentUrl();
        if(url.toLowerCase().contains("calendar")){
            System.out.println("TestCase01: PASSED");
        }
        else{
            System.out.println("TestCase01: FAILED");
        }
        System.out.println("end Test case: testCase01");
    }
    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        driver.get("https://calendar.google.com/");
        Thread.sleep(3000);
        WebElement view=driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[2]/div[3]/div/div/div/div[5]/div/div[1]/div[1]/div/button/span"));
        view.click();
        WebElement month=driver.findElement(By.xpath("//li[@data-viewkey='month']"));
        month.click();
        Thread.sleep(5000);
        WebElement vieweElement=driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[2]/div[3]/div/div/div/div[5]/div/div[1]/div[1]/div/button/span"));
        String message=vieweElement.getText();
        Thread.sleep(3000);
        WebElement today=driver.findElement(By.xpath("//div[@data-datekey='27803']"));
        today.click();
        Thread.sleep(3000);
        WebElement task=driver.findElement(By.xpath("//*[@id='tabTask']/div[2]"));
        task.click();
        Thread.sleep(3000);
        WebElement title=driver.findElement(By.xpath("//input[@placeholder='Add title and time']"));
        title.sendKeys("Crio INTV Task Automation");
        Thread.sleep(3000);
        WebElement description=driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        description.sendKeys("Crio INTV Calendar Task Automation");
        Thread.sleep(3000);
        WebElement save=driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/div/div/div[2]/span/div/div[1]/div[2]/div[2]/div[4]/button"));
        save.click();
        WebElement succussfullpopup=driver.findElement(By.xpath("//div[@class='VYTiVb']"));
       String msg= succussfullpopup.getText();
        if(message.contains("Month") && msg.equals("Task created")){
            System.out.println("TestCase02: PASSED");
        }
        else{
            System.out.println("TestCase02: FAILED");
        }
        System.out.println("end Test case: testCase02");
        Thread.sleep(3000);
    }
    public  void testCase03()throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        driver.get("https://calendar.google.com/");
        Thread.sleep(3000);
        WebElement task=driver.findElement(By.xpath("//*[@id='YPCqFe']/div/div/div/div[2]/div[4]/div[3]/div/div[6]/div/div/div/span[1]/span[2]"));
        task.click();
        Thread.sleep(3000);
        WebElement edit=driver.findElement(By.xpath("//*[@id='yDmH0d']/div[1]/div/div[2]/span/div/div[1]/div/div/div[2]/div[1]/span/button/span"));
        edit.click();
        Thread.sleep(3000);
        WebElement description=driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        description.click();
        Actions actions=new Actions(driver);
        Thread.sleep(3000);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);
        description.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        Thread.sleep(3000);
        WebElement save=driver.findElement(By.xpath("//*[@id='yDmH0d']/div/div/div[2]/span/div/div[8]/div/button"));
        save.click();
        Thread.sleep(3000);
        task=driver.findElement(By.xpath("//*[@id='YPCqFe']/div/div/div/div[2]/div[4]/div[3]/div/div[6]/div/div/div/span[1]/span[2]"));
        task.click();
        Thread.sleep(3000);
        WebElement updateddescription=driver.findElement(By.xpath("//*[@id='yDmH0d']/div/div/div[2]/span/div/div[2]/div[3]/div[2]"));
        String updatedmsg=updateddescription.getText();
        if(updatedmsg.contains("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application")){
            System.out.println("TestCase03: PASSED");
        }
        else{
            System.out.println("TestCase03: FAILED");
        }
        System.out.println("end Test case: testCase03");
    }
    public  void testCase04()throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        driver.get("https://calendar.google.com/");
        Thread.sleep(3000);
        WebElement task=driver.findElement(By.xpath("//*[@id='YPCqFe']/div/div/div/div[2]/div[4]/div[3]/div/div[6]/div/div/div/span[1]/span[2]"));
        task.click();
        Thread.sleep(3000);
        WebElement delete=driver.findElement(By.xpath("//*[@id='yDmH0d']/div/div/div[2]/span/div/div[1]/div/div/div[2]/div[2]/span/button"));
        delete.click();
        WebElement succussfullpopup=driver.findElement(By.xpath("//div[@class='VYTiVb']"));
        String msg= succussfullpopup.getText();
        if(msg.equals("Task deleted")){
            System.out.println("TestCase04: PASSED");
        }
        else{
            System.out.println("TestCase04: FAILED");
        }
        System.out.println("end Test case: testCase04");
    }

}
