package test.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage {
    private WebDriver driver;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchEmployee(String employeeName, String employeeId) {
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(employeeName);
        driver.findElement(By.id("empsearch_id")).sendKeys(employeeId);
        driver.findElement(By.id("searchBtn")).click();
    }

    public void clickEditIcon() {
        driver.findElement(By.xpath("//a[contains(@href, 'edit')]")).click();
    }

    public void updateEmploymentStatus(String status) {
        driver.findElement(By.id("employmentStatus")).sendKeys(status);
    }

    public void includeJobTitle(String jobTitle) {
        driver.findElement(By.id("job_title")).sendKeys(jobTitle);
    }

    public void goToContactDetails() {
        driver.findElement(By.xpath("//a[text()='Contact Details']")).click();
    }

    public void updateContactDetails(String street1, String street2) {
        driver.findElement(By.id("contact_street1")).clear();
        driver.findElement(By.id("contact_street1")).sendKeys(street1);
        driver.findElement(By.id("contact_street2")).clear();
        driver.findElement(By.id("contact_street2")).sendKeys(street2);
        driver.findElement(By.id("btnSave")).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(By.cssSelector(".message.success")).getText();
    }
}
