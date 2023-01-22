Feature: Login feature

  #waitForAler function does not work
  #as a result step Login alert that fields are blank appears can not pass green

  #I used to have the same steps in some features fies: Login.feature, Registration.feature, Account.feature.
  # So the step with the same name addressed to the method in the dif feature file
  #If I am not mistaken there is a problem with this option.
  #So I had to create and rename the same step and implementation in all 3 feature files mentioned. Although this step has the same function.
  #as a pre-step I would like to register a user.


  @positive
  Scenario Outline: Login with valid credentials
    Given Login page is opened
    When "<valid email>" and "<valid password>" for login are entered
    And Login button is clicked
    Then User is logged in
    Examples:
      | valid email     | valid password  |
      | email@gmail.com | validPassword1! |
      #| email1@gmail.com               | validPassword1! |
      #| testemail@gmail.com            | validPassword1! |
      #| email@example.com              | validPassword1! |
      #| firstname.lastname@example.com | validPassword1! |
      #| email@subdomain.example.com    | validPassword1! |
      #| firstname+lastname@example.com | validPassword1! |
      #| email@123.123.123.123          | validPassword1! |
      #| email@[123.123.123.123]        | validPassword1! |
      #| "email"@example.com            | validPassword1! |
      #| 1234567890@example.com         | validPassword1! |
      #| email@example-one.com          | validPassword1! |
      #| _______@example.com            | validPassword1! |
      #| email@example.name             | validPassword1! |
      #| email@example.museum           | validPassword1! |
      #| email@example.co.jp            | validPassword1! |
     # | firstname-lastname@example.com | validPassword1! |


  @negative
  Scenario Outline: Login with both login and password invalid credentials
    Given Login page is opened
    When "<invalid email>" and "<invalid password>" for login are entered
    And Login button is clicked
    Then Login error message appears
    Examples:
      | invalid email        | invalid password |
      | testemail1@gmail.com | invalidPassword  |
      | TESTEMAIL@GMAIL.COM  | invalidPassword  |
      | testemail@mail.com   | invalidPassword  |
      | Testemail@gmail.com  | invalidPassword  |
      | .testemail@gmail.com | invalidPassword  |
      | 1testemail@gmail.com | invalidPassword  |
      | testemail@g-mail.com | invalidPassword  |
      | test-email@gmail.com | invalidPassword  |
      | testemailgmail.com   | invalidPassword  |


  @negative
  Scenario Outline: Login with invalid email but valid password
    Given Login page is opened
    When "<invalid email>" and "<valid password>" for login are entered
    And Login button is clicked
    Then Login error message appears
    Examples:
      | invalid email        | valid password  |
      | testemail1@gmail.com | validPassword1! |
      | TESTEMAIL@GMAIL.COM  | validPassword1! |
      | testemail@mail.com   | validPassword1! |
      | Testemail@gmail.com  | validPassword1! |
      | .testemail@gmail.com | validPassword1! |
      | 1testemail@gmail.com | validPassword1! |
      | testemail@g-mail.com | validPassword1! |
      | test-email@gmail.com | validPassword1! |
      | testemailgmail.com   | validPassword1! |


  @negative
  Scenario Outline: Login with invalid password but valid email
    Given Login page is opened
    When "<valid email>" and "<invalid password>" for login are entered
    And Login button is clicked
    Then Login error message appears
    Examples:
      | valid email         | invalid password |
      | testemail@gmail.com | VALIDPASSWORD1!  |
      | testemail@gmail.com | Validpassword1!  |
      | testemail@gmail.com | validPassword1   |
      | testemail@gmail.com | validPassword!   |
      | testemail@gmail.com | validPassword    |


  @negative
  Scenario Outline: Login with blank credentials
    Given Login page is opened
    When "<email>" and "<password>" for login are entered
    And Login button is clicked
    Then Login alert that fields are blank appears
    Examples:
      | email               | password      |
      |                     | testpassword! |
      | testemail@gmail.com |               |
      |                     |               |


  @positive
  Scenario Outline: Password reset
    Given Login page is opened
    When I've forgotten my password link is clicked
    And Password reset page is opened
    And "<valid email>" for reset email is entered
    And Send reset email button is clicked
    Then Reset email is sent to a user
    Examples:
      | valid email     |
      | email@gmail.com |

