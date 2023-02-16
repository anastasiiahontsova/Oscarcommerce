Feature: Registration feature


  @deletesUserAccount
    @positive
  Scenario Outline: User registers with valid credentials. User is registered and logged in
    Given Login and Registration page is opened
    When "<valid email>" and "<valid password>" for registration are entered
    And Register button is clicked
    Then User is registered
    Examples:
      | valid email                    | valid password  |
      | email3@gmail.com               | validPassword1! |
      | testemail@gmail.com            | validPassword1! |
      | firstname-lastname@example.com | validPassword1! |
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
      | testemail@example.com          | validPassword1! |


  @wip
    @negative
  Scenario Outline: User registers with invalid credentials. Error message appears
    Given Login and Registration page is opened
    When "<invalid email>" and "<invalid password>" for registration are entered
    And Register button is clicked
    Then Registration "<error message>" appears
    Examples:
      | invalid email            | invalid password | error message                                                      |
      | email@example            | 111              | Enter a valid email address.                                       |
      | .email@example.com       | 111              | Enter a valid email address.                                       |
      | email.@example.com       | 111              | Enter a valid email address.                                       |
      | email..email@example.com | 111              | Enter a valid email address.                                       |
      | email@example.web        | 111              | This password is too short. It must contain at least 9 characters. |
      | email@111.222.333.44444  | 111              | This password is too short. It must contain at least 9 characters. |
      | Abc..123@example.com     | 111              | Enter a valid email address.                                       |

  @wip
    @negative
  Scenario Outline: User registers with invalid credentials. Registration alert appears
    Given Login and Registration page is opened
    When "<invalid email>" and "<invalid password>" for registration are entered
    And Register button is clicked
    Then Registration "<error message>" appears
    Examples:
      | invalid email                 | invalid password | error message |
      | plainaddress                  | 111              | alert         |
      | @example.com                  | 111              | alert         |
      | Joe Smith <email@example.com> | 111              | alert         |
      | email.example.com             | 111              | alert         |
      | email@example@example.com     | 111              | alert         |
      | email@example.com (Joe Smith) | 111              | alert         |
      | #@%^%#$@#$@#.com              | 111              | alert         |
      | email@example..com            | 111              | alert         |


  @negative
  Scenario Outline: User registers with only invalid email. Registration error message appears
    Given Login and Registration page is opened
    When "<invalid email>" and "<valid password>" for registration are entered
    And Register button is clicked
    Then Registration "<error message>" appears
    Examples:
      | invalid email | valid password  | error message |
      | @gmail.com    | validPassword1! | alert         |
      | test email@   | validPassword1! | alert         |
      | 1             | validPassword1! | alert         |


  @negative
  Scenario Outline: User registers with only invalid password. Registration error message appears
    Given Login and Registration page is opened
    When "<valid email>" and "<invalid password>" for registration are entered
    And Register button is clicked
    Then Registration "<error message>" appears
    Examples:
      | valid email            | invalid password | error message                                                      |
      | testemail111@gmail.com | 1                | This password is too short. It must contain at least 9 characters. |
      | testemail111@gmail.com | password         | This password is too short. It must contain at least 9 characters. |
      | testemail111@gmail.com | PASSWORD         | This password is too short. It must contain at least 9 characters. |
      | testemail111@gmail.com | pass             | This password is too short. It must contain at least 9 characters. |
      | testemail111@gmail.com | Pass             | This password is too short. It must contain at least 9 characters. |
      | testemail111@gmail.com | 123456789        | This password is too common.                                       |
      | testemail111@gmail.com | password1!       | This password is too common.                                       |
      | testemail111@gmail.com | PASSWORD1!       | This password is too common.                                       |


  @negative
  Scenario Outline: User registers with blank email and/or blank password credentials. Registration alert appears
    Given Login and Registration page is opened
    When "<blank email>" and "<blank password>" for registration are entered
    And Register button is clicked
    Then Registration "<error message>" appears
    Examples:
      | blank email            | blank password | error message |
      |                        |                | alert         |
      | testemail123@gmail.com |                | alert         |
      |                        | Password!123   | alert         |

  @deletesExistingUserAccount
  @negative
  Scenario: User registers with existing user credentials. Existing user registration error message appears
    Given Login and Registration page is opened
    When "<valid email>" and "<valid password>" for existing user registration are entered
    And Register button is clicked
    And User is logged out
    And Login and Registration page is opened
    And Existing user's credentials for registration are entered
    And Register button is clicked
    Then "A user with that email address already exists" error message appears

