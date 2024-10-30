Feature: Search existing user and update contract

  Scenario: TC2 - Search existed user and update contract
    Given I am logged in as an admin user
    When I open the PIM menu
    And I search for employee information
      | Employee Name           | Employee Id | Employment Status          | Include                        |
      | Sania Shaheen           | 0087        | Full-Time Permanent        | Customer Success Manager       |
    And I click on the Edit icon
    And I click on "Contact Details" Menu
    And I update the field "Street 1" and "Street 2"
    Then I should see a success message