Feature: Login feature

  @positive
  Scenario: Login with valid credentials
    Given Login page is opened
    When Valid login credentials are entered
    And 'Login' button is clicked
    Then User is logged in

  @negative
  Scenario Outline: Login with both invalid email and password credentials
    Given Login page is opened
    When <invalid email> is entered
    And <invalid password> is entered
    And 'Login' button is clicked
    Then Error message appears
    Examples:
      | invalid email          | invalid password |
      | invalidemail@gmail.com | invalidpassword  |
      | testemail1@gmail.com   | testpassword     |
      | Testemail@gmail.com    | Testpassword!    |
      | TESTEMAIL@GMAIL.COM    | TESTPASSWORD!    |


  @negative
  Scenario: Login with invalid email
    Given Login page is opened
    When Invalid email is entered
    And Valid password is entered
    And 'Login' button is clicked
    Then Invalid mail error message appears

  @negative
  Scenario: Login with invalid password
    Given Login page is opened
    When Valid email is entered
    And Invalid password is entered
    And 'Login' button is clicked
    Then Invalid password error message appears

  @negative
  Scenario Outline: Login with blank credentials
    Given Login page is opened
    When <email> is entered
    And <password> is entered
    And 'Login' button is clicked
    Then Void field message appears
    Examples:
      | email               | password      |
      |                     | testpassword! |
      | testemail@gmail.com |               |
      |                     |               |

  @positive
  Scenario: Password reset
    Given Login page is opened
    When 'I've forgotten my password' link is clicked
    And Password reset page is opened
    And User's correct email is entered
    And 'Send reset email' button is clicked
    Then Reset password link is sent to user's account

