Feature: Registration feature

  @wip
    @deletesUserAccount
    @positive
  Scenario Outline: Registration with valid credentials
    Given Login and Registration page is opened
    When "<valid email>" and "<valid password>" for registration are entered
    And Register button is clicked
    Then User is registered
    Examples:
      | valid email         | valid password  |
      #| email3@gmail.com | validPassword1! |
      | testemail@gmail.com | validPassword1! |
      #| firstname-lastname@example.com | validPassword1! |
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
      #| testemail@example.com          | validPassword1! |


  @wip
    @negative
  Scenario Outline: Registration with invalid credentials if error message appears
    Given Login and Registration page is opened
    When "<invalid email>" and "<invalid password>" for registration are entered
    And Register button is clicked
    Then Registration "<error message>" appears
    Examples:
      | invalid email            | invalid password | error message                                                                                    |
      | email@example            | 111              | Enter a valid email address.                                                                     |
      | .email@example.com       | 111              | Enter a valid email address.                                                                     |
      | email.@example.com       | 111              | Enter a valid email address.                                                                     |
      | email..email@example.com | 111              | Enter a valid email address.                                                                     |
      | email@example.web        | 111              | This password is too short. It must contain at least 9 characters.  This password is too common. |
      | email@111.222.333.44444  | 111              | This password is too short. It must contain at least 9 characters.  This password is too common. |
      | Abc..123@example.com     | 111              | Enter a valid email address.                                                                     |

  @wip
    @negative
  Scenario Outline: Registration with invalid credentials if alert appears
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
  Scenario Outline: Registration with only invalid email
    Given Login and Registration page is opened
    When "<invalid email>" and "<valid password>" for registration are entered
    And Register button is clicked
    Then Registration "<error message>" appears
    Examples:
      | invalid email | valid password  |
      | @gmail.com    | validPassword1! |
      | test email@   | validPassword1! |
      | 1             | validPassword1! |


  @negative
  Scenario Outline: Registration with only invalid password
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
  Scenario Outline: Registration with blank email and/or blank password credentials
    Given Login and Registration page is opened
    When "<blank email>" and "<blank password>" for registration are entered
    And Register button is clicked
    Then Registration alert appears
    Examples:
      | blank email            | blank password |
      |                        |                |
      | testemail123@gmail.com |                |
      |                        | Password!123   |


  @negative
  Scenario Outline: Existing user registration
    Given Login and Registration page is opened
    When Existing user's "<valid email>" and "<valid password>" for registration are entered
    And Register button is clicked
    Then Registration "<error message>" appears
    Examples:
      | valid email                    | valid password  |
      | email@gmail.com                | validPassword1! |
      | firstname-lastname@example.com | validPassword1! |
      | firstname.lastname@example.com | validPassword1! |
