package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find Element of userName field
        WebElement validUserName = driver.findElement(By.xpath("//input[@type='text']"));
        //Send Valid Username to username field
        validUserName.sendKeys("neha12345");
        //Find Element of Password field
        WebElement validPassword = driver.findElement(By.xpath("//input[@type='password']"));
        // Send valid password to Password field
        validPassword.sendKeys("Abc123!");
        //Find Login element and click on it
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        String expectedMessage = "Accounts Overview";
        //Find text element
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualMessage = actualMessageElement.getText();
        //Validate actual and expected Message
        Assert.assertEquals("Not a valid Message : ", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Find Element of Invalid userName field
        WebElement invalidUserName = driver.findElement(By.xpath("//input[@type='text']"));
        //Send invalid Username to username field
        invalidUserName.sendKeys("neha54321");
        //Find Element of Password field
        WebElement invalidPassword = driver.findElement(By.xpath("//input[@type='password']"));
        // Send invalid password to Password field
        invalidPassword.sendKeys("123ABC!");
        //Find Login element and click on it
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        String expectedMessage = "The username and password could not be verified.";
        //Find text element
        WebElement actualMessageElement = driver.findElement(By.xpath("//p[@class='error']"));
        String actualMessage = actualMessageElement.getText();
        //Validate actual and expected Message
        Assert.assertEquals("Not a valid Message : ", expectedMessage, actualMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Find Element of userName field
        WebElement validUserName = driver.findElement(By.xpath("//input[@type='text']"));
        //Send Valid Username to username field
        validUserName.sendKeys("neha12345");
        //Find Element of Password field
        WebElement validPassword = driver.findElement(By.xpath("//input[@type='password']"));
        // Send valid password to Password field
        validPassword.sendKeys("Abc123!");
        //Find Login element and click on it
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        //Find Logout element and click on it
        WebElement logout = driver.findElement(By.xpath("//a[@href='/parabank/logout.htm']"));
        logout.click();
        String expectedMessage = "Customer Login";
        //Find text element
        WebElement actualMessageElement = driver.findElement(By.xpath("//h2[contains(text(),'Customer Login')]"));
        String actualMessage = actualMessageElement.getText();
        //Validate actual and expected Message
        Assert.assertEquals("Not a valid Message : ", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
