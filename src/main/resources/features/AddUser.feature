Feature: Add User

  Scenario: TC1 - Add user success
    Given the admin user is logged in with username "Admin" and password "admin123"
    When the admin opens the Admin menu
    And clicks on the Add button
    And inputs valid info
      | UserRole      | Employee Name    | Status   | UserName | Password | Confirm Password |
      | ESS           | Ranga Akunuri    | Enabled  | valid    | valid    | valid            |
    Then the user should be added successfully
    When the admin logs out
    And the new user "valid" logs in with password "valid"
    Then the user login should be successful