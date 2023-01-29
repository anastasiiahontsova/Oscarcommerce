Feature: Login feature


  @deletesUserAccount
    @positive
  Scenario Outline: Login with valid credentials
    Given Login and Registration page is opened
    When User is registered without login with "<valid email>" and "<valid password>"
    And Login "<valid email>" and "<valid password>" are entered
    And Login button is clicked
    Then User is logged in
    Examples:
      | valid email                    | valid password  |
      | email@gmail.com                | validPassword1! |
      | email1@gmail.com               | validPassword1! |
      | testemail@gmail.com            | validPassword1! |
      | email@example.com              | validPassword1! |
      | firstname.lastname@example.com | validPassword1! |
      | email@subdomain.example.com    | validPassword1! |
      | firstname+lastname@example.com | validPassword1! |
      | email@123.123.123.123          | validPassword1! |
      | 1234567890@example.com         | validPassword1! |
      | email@example-one.com          | validPassword1! |
      | _______@example.com            | validPassword1! |
      | email@example.name             | validPassword1! |
      | email@example.museum           | validPassword1! |
      | email@example.co.jp            | validPassword1! |
      | firstname-lastname@example.com | validPassword1! |


  @requiresRegistrationWithoutLogIn
    @loginsAndDeletesUserAccount
    @negative
  Scenario Outline: Login with both invalid login and password  credentials
    Given Login and Registration page is opened
    When Login "<invalid email>" and "<invalid password>" are entered
    And Login button is clicked
    Then Login "<error message>" appears
    Examples:
      | invalid email        | invalid password | error message                                                                              |
      | testemail1@gmail.com | invalidPassword  | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | testemail@mail.com   | invalidPassword  | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | 1testemail@gmail.com | invalidPassword  | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | testemail@g-mail.com | invalidPassword  | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | test-email@gmail.com | invalidPassword  | Please enter a correct username and password. Note that both fields may be case-sensitive. |


  @requiresRegistrationWithoutLogIn
    @loginsAndDeletesUserAccount
    @negative
  Scenario Outline: Login with invalid email but valid password
    Given Login and Registration page is opened
    When Login "<invalid email>" and "<invalid password>" are entered
    And Login button is clicked
    Then Login "<error message>" appears
    Examples:
      | invalid email        | invalid password | error message                                                                              |
      | testemail1@gmail.com | validPassword1!  | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | testemail@mail.com   | validPassword1!  | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | 1testemail@gmail.com | validPassword1!  | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | testemail@g-mail.com | validPassword1!  | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | test-email@gmail.com | validPassword1!  | Please enter a correct username and password. Note that both fields may be case-sensitive. |


  @requiresRegistrationWithoutLogIn
    @loginsAndDeletesUserAccount
    @negative
  Scenario Outline: Login with valid email but invalid password
    Given Login and Registration page is opened
    When Login "<valid email>" and "<invalid password>" are entered
    And Login button is clicked
    Then Login "<error message>" appears
    Examples:
      | valid email         | invalid password | error message                                                                              |
      | testemail@gmail.com | VALIDPASSWORD1!  | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | testemail@gmail.com | Validpassword1!  | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | testemail@gmail.com | validPassword1   | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | testemail@gmail.com | validPassword!   | Please enter a correct username and password. Note that both fields may be case-sensitive. |
      | testemail@gmail.com | validPassword    | Please enter a correct username and password. Note that both fields may be case-sensitive. |


  @requiresRegistrationWithoutLogIn
    @loginsAndDeletesUserAccount
    @negative
  Scenario Outline: Login with blank credentials
    Given Login and Registration page is opened
    When Login "<email>" and "<password>" are entered
    And Login button is clicked
    Then Login alert that fields are blank appears
    Examples:
      | email               | password      |
      |                     | testpassword! |
      | testemail@gmail.com |               |
      |                     |               |


  @positive
  Scenario: Password reset
    Given Login and Registration page is opened
    When I've forgotten my password link is clicked
    And Password reset page is opened
    And Valid email for reset email is entered
    And Send reset email button is clicked
    Then Reset email is sent to a user
