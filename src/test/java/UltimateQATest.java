//

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class UltimateQATest extends PageSetup{


    @Test
    public void TestOne(){
        WebElement buttonUsingID = driver.findElement(By.id("idExample"));
        buttonUsingID.click();

        WebElement buttonSuccessText = driver.findElement(By.className("entry-title"));
        Assertions.assertEquals("Button success", buttonSuccessText.getText());
    }

    @Test
    public void TestTwo() throws InterruptedException {

        WebElement nameTextField = driver.findElement(By.id("et_pb_contact_name_0"));
        nameTextField.sendKeys("Tester");

        WebElement emailTextField = driver.findElement(By.id("et_pb_contact_email_0"));
        emailTextField.sendKeys("tester@tester.com");

        Thread.sleep(2000);

        WebElement emailMeButton = driver.findElement(By.name("et_builder_submit_button"));
        emailMeButton.click();
        //emailMeButton.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        //sposoby na szukanie elementów na stronie:
        WebElement thanksForContactingUsText = driver.findElement(By.xpath("//div[@class='et-pb-contact-message']/p"));
        Assertions.assertEquals("Thanks for contacting us", thanksForContactingUsText.getText());

    }

    @Test
    public void TestThree() {
        List<WebElement> listOfQATitles = driver.findElements(By.xpath("//table[@id='htmlTableId']//tr"));
        //List<WebElement> listOfQATitles = driver.findElements(By.xpath("//table[@id='htmlTableId']//tr"));
        //   //table[@id='htmlTableId']//tr[4]/td[1]
        Assertions.assertEquals(4, listOfQATitles.size());
    }
    @Test
    public void TestFour(){

        List<String> listOfCars = new ArrayList<>();
        listOfCars.add("volvo");
        listOfCars.add("saab");
        listOfCars.add("opel");
        listOfCars.add("audi");

        for (int i=0; i<listOfCars.size();i++){
            WebElement dropdownOfCars = driver.findElement(By.xpath("//div[text()='Select an option and validate that it is selected']/select"));
            dropdownOfCars.click();

            WebElement dropdownOfCarsOption = driver.findElement(By.xpath("//option[@value='"+listOfCars.get(i)+"']"));
            dropdownOfCarsOption.click();

            Assertions.assertTrue(dropdownOfCarsOption.isSelected());
            Assertions.assertEquals(listOfCars.get(i),dropdownOfCarsOption.getText().toLowerCase());
        }
    }

}



