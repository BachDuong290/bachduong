package test.org.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UpdateUserStep {
    private WebDriver driver;

    @Given("I am logged in as an admin user")
    public void i_am_logged_in_as_an_admin_user() {
        // Setup WebDriverManager to manage ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create a new instance of ChromeDriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Perform login
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        usernameField.sendKeys("admin");
        passwordField.sendKeys("admin_password");
        loginButton.click();
    }

    @When("I open the PIM menu")
    public void i_open_the_PIM_menu() {
        WebElement pimMenu = driver.findElement(By.id("pimMenu"));
        pimMenu.click();
    }

    @When("I search for employee information")
    public void i_search_for_employee_information(io.cucumber.datatable.DataTable dataTable) {
        // Get the employee data from the DataTable
        String employeeName = dataTable.cell(0, 0);
        String employeeId = dataTable.cell(0, 1);
        String employmentStatus = dataTable.cell(0, 2);
        String include = dataTable.cell(0, 3);

        // Fill in the search form
        WebElement nameField = driver.findElement(By.id("employeeName"));
        WebElement idField = driver.findElement(By.id("employeeId"));
        WebElement statusField = driver.findElement(By.id("employmentStatus"));
        WebElement includeField = driver.findElement(By.id("include"));

        nameField.sendKeys(employeeName);
        idField.sendKeys(employeeId);
        statusField.sendKeys(employmentStatus);
        includeField.sendKeys(include);

        // Submit the search
        WebElement searchButton = driver.findElement(By.id("searchButton"));
        searchButton.click();
    }

    @When("I click on the Edit icon")
    public void i_click_on_the_Edit_icon() {
        WebElement editIcon = driver.findElement(By.cssSelector("editIconSelector")); // Replace with actual selector
        editIcon.click();
    }

    @When("I click on \"Contact Details\" Menu")
    public void i_click_on_Contact_Details_Menu() {
        WebElement contactDetailsMenu = driver.findElement(By.id("contactDetailsMenu"));
        contactDetailsMenu.click();
    }

    @When("I update the field {string} and {string}")
    public void i_update_the_field(String street1, String street2) {
        WebElement street1Field = driver.findElement(By.id("street1"));
        WebElement street2Field = driver.findElement(By.id("street2"));
        WebElement saveButton = driver.findElement(By.id("saveButton"));

        // Update the street fields
        street1Field.clear();
        street1Field.sendKeys(street1);
        street2Field.clear();
        street2Field.sendKeys(street2);

        // Click save
        saveButton.click();
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        // Verify success message
        WebElement successMessage = driver.findElement(By.id("successMessage"));
        assert successMessage.isDisplayed();

        // Close the driver
        driver.quit();
    }
}
