package test.org.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.org.pages.AdminPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddUserStep {

    private AdminPage adminPage;

    @Given("the admin user is logged in with username {string} and password {string}")
    public void the_admin_user_is_logged_in(String username, String password) {
        adminPage = new AdminPage();
        assertTrue(adminPage.login(username, password));
    }

    @When("the admin opens the Admin menu")
    public void the_admin_opens_the_admin_menu() {
        assertTrue(adminPage.openAdminMenu());
    }

    @When("clicks on the Add button")
    public void clicks_on_the_add_button() {
        // This step is implicitly handled when adding user
    }

    @When("inputs valid info")
    public void inputs_valid_info(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMaps(String.class, String.class).get(0);
        String userRole = data.get("UserRole");
        String employeeName = data.get("Employee Name");
        String status = data.get("Status");
        String username = data.get("UserName");
        String password = data.get("Password");

        assertTrue(adminPage.addUser(userRole, employeeName, status, username, password));
    }

    @Then("the user should be added successfully")
    public void the_user_should_be_added_successfully() {
        // Verification can be done here if needed
    }

    @When("the admin logs out")
    public void the_admin_logs_out() {
        assertTrue(adminPage.logout());
    }

    @When("the new user {string} logs in with password {string}")
    public void the_new_user_logs_in(String username, String password) {
        assertTrue(adminPage.userLogin(username, password));
    }

    @Then("the user login should be successful")
    public void the_user_login_should_be_successful() {
        // Verification can be done here if needed
    }
}
