Feature: Registration feature

  @positive
  Scenario Outline: Registration with valid credentials
    Given Registration page is opened
    When <valid email> is entered
    And <valid password> is entered
    And 'Register' button is clicked
    Then User is registered
    And User is logged in
    Examples:
      | valid email            | valid password |
      | testemail000@gmail.com | testpassword!  |
      | testemail000@ukr.net   | testpassword!  |
      | TESTEMAIL000@gmail.com | testpassword!  |

  @negative
  Scenario: Registration with both invalid email and password credentials
    Given Registration page is opened
    When Invalid email credential is entered
    And Invalid password is entered
    And 'Register' button is clicked
    Then Error message appears

  @negative
  Scenario Outline: Registration with invalid email
    Given Registration page is opened
    When <improper email> is entered
    And <valid password> is entered
    And 'Register' button is clicked
    Then Invalid email error message appears
    Examples:
      | improper email | valid password |
      | @gmail.com     | testpassword!  |
      | testemail@     | testpassword!
      | 1              | testpassword!  |


  @negative
  Scenario Outline: Registration with invalid password
    Given Registration page is opened
    When <valid email> is entered
    And <improper password> is entered
    And 'Register' button is clicked
    Then Invalid password error message appears
    Examples:
      | valid email            | improper password |
      | testemail111@gmail.com | 1                 |
      | testemail111@gmail.com | 11111111          |
      | testemail111@gmail.com | 111111111         |
      | testemail111@gmail.com | aaaaaaaaa         |


  @negative
  Scenario Outline: Registration with blank email and/or blank password credentials
    Given Registration page is opened
    When Blank <email> is entered
    And Blank <password> is entered
    And 'Register' button is clicked
    Then Blank field error message appears
    Examples:
      | email                  | password         |
      |                        |                  |
      | testemail222@gmail.com |                  |
      |                        | testpassword!000 |

  @negative
  Scenario: Existing user registration
    Given Registration page is opened
    When Existing user's credentials are entered
    And 'Register' button is clicked
    Then 'A user with that email address already exists' error message appears
