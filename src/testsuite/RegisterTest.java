package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //Find Register link element and click on it
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
        //Find Element of Message
        String expectedMessage = "Signing up is easy!";
        //Find text element
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualMessage = actualMessageElement.getText();
        //Validate actual and expected Message
        Assert.assertEquals("Not a valid Message : ", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //Find Register link element and click on it
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();
        //Find Element of First Name field
        WebElement firstNameField = driver.findElement(By.xpath("//input[@id='customer.firstName']"));
        //Send First Name to First name field
        firstNameField.sendKeys(("Neha"));
        //Find Element of Last Name field
        WebElement lastNameField = driver.findElement(By.xpath("//input[@id='customer.lastName']"));
        //Send Last Name to Last Name field
        lastNameField.sendKeys("Patel");
        //Find Element of Address field
        WebElement addressField = driver.findElement(By.xpath("//input[@id='customer.address.street']"));
        //Send address to address field
        addressField.sendKeys("3 Wembley Road");
        //Find Element of City field
        WebElement cityField = driver.findElement(By.xpath("//input[@id='customer.address.city']"));
        //Send city name to city field
        cityField.sendKeys("Wembley");
        //Find Element of State field
        WebElement stateField = driver.findElement(By.xpath("//input[@id='customer.address.state']"));
        //Send State name to state field
        stateField.sendKeys("Middlesex");
        //Find Element of Zip Code field
        WebElement zipCodeField = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
        //Send Zip Code to Zip Code field
        zipCodeField.sendKeys("HA0 2RG");
        //Find Element of Phone field
        WebElement phoneField = driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
        //Send Phone number to Phone field
        phoneField.sendKeys("07852554569");
        //Find Element of SSN field
        WebElement ssnField = driver.findElement(By.xpath("//input[@id='customer.ssn']"));
        //Send SSN number to SSN field
        ssnField.sendKeys("AA-12-34-56-B");
        //Find Element of userName field
        WebElement userNameField = driver.findElement(By.xpath("//input[@id='customer.username']"));
        //Send Username to username field
        userNameField.sendKeys("neha123456");
        //Find Element of Password field
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='customer.password']"));
        // Send password to Password field
        passwordField.sendKeys("Abc123!");
        //Find Element of Password field
        WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@id='repeatedPassword']"));
        // Send password to Password field
        confirmPasswordField.sendKeys("Abc123!");
        //Find Register link element and click on it
        WebElement clickRegister = driver.findElement(By.xpath("//input[@value='Register']"));
        clickRegister.click();
        String expectedMessage = "Your account was created successfully. You are now logged in.";
        //Find text element
        WebElement actualMessageElement = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualMessage = actualMessageElement.getText();
        //Validate actual and expected Message
        Assert.assertEquals("Not a valid Message : ", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
