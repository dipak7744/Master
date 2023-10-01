Feature: Compose Functionality in Gmail

  Scenario: Compose and Send Email
    Given User is on the Gmail login page
    When User log in with valid credentials
    And User click on the Compose button
    And User wait for the compose window to appear
    And User enter the recipient email address "dipakdemo66@gmail.com"
    And User enter the subject as "Incubyte"
    And User enter the body as "Automation QA test for Incubyte"
    And User click on the Send button
    Then the email should be sent successfully
    When User navigate to the Sent folder
    And User click on "Incubyte" subject email
    Then User should see a sent email with subject "Incubyte"
    And User should see the body "Automation QA test for Incubyte"
