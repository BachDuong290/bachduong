package test.org.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginSteps {
    WebDriver driver;

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user enters valid username {string} and password {string}")
    public void theUserEntersValidCredentials(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("the user enters invalid username {string} and password {string}")
    public void theUserEntersInvalidCredentials(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("clicks on the login button")
    public void clicksOnTheLoginButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("the user should be redirected to the dashboard page")
    public void theUserShouldBeRedirectedToTheDashboardPage() {
        String dashboardText = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
        Assert.assertEquals(dashboardText, "Dashboard");
        driver.quit();
    }

    @Then("an error message {string} should be displayed")
    public void anErrorMessageShouldBeDisplayed(String errorMessage) {
        String actualError = driver.findElement(By.xpath("//p[contains(text(), 'Invalid credentials')]")).getText();
        Assert.assertEquals(actualError, errorMessage);
        driver.quit();
    }

    @Given("the user is logged in with username {string} and password {string}")
    public void theUserIsLoggedInWithUsernameAndPassword(String username, String password) {
        theUserNavigatesToTheLoginPage();
        theUserEntersValidCredentials(username, password);
        clicksOnTheLoginButton();
    }

    @When("the user clicks on the logout button")
    public void theUserClicksOnTheLogoutButton() {
        driver.findElement(By.xpath("//p[text()='Logout']")).click();
    }

    @Then("the user should be redirected to the login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        String loginText = driver.findElement(By.xpath("//h5[text()='Login']")).getText();
        Assert.assertEquals(loginText, "Login");
        driver.quit();
    }
}
