import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageSetup {
    String projectLocation = System.getProperty("user.dir");
    WebDriver driver;

    @BeforeEach
    public void pageSetup(){
        System.setProperty("webdriver.chrome.driver",projectLocation+"/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

    }

    @AfterEach
    public void pageTeardown(){

        driver.close();
    }
}
