Feature: Registration feature


  @positive
  Scenario Outline: Registration with valid credentials
    Given Registration page is opened
    When "<valid email>" and "<valid password>" for registration are entered
    And Register button is clicked
    Then User is registered
   # And User profile is deleted
    Examples:
      | valid email      | valid password  |
      | email3@gmail.com | validPassword1! |
      #| testemail@gmail.com            | validPassword1! |
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

  @negative
  Scenario Outline: Registration with both invalid email and password credentials
    Given Registration page is opened
    When "<invalid email>" and "<invalid password>" for registration are entered
    And Register button is clicked
    Then Registration error message appears
    Examples:
      | invalid email                 | invalid password |
      | plainaddress                  | 111              |
      | email@example                 | 111              |
      | @example.com                  | 111              |
      | Joe Smith <email@example.com> | 111              |
      | email.example.com             | 111              |
      | email@example@example.com     | 111              |
      | .email@example.com            | 111              |
      | email.@example.com            | 111              |
      | email..email@example.com      | 111              |
      | email@example.com (Joe Smith) | 111              |
      | #@%^%#$@#$@#.com              | 111              |
     # | email@-example.com                      | 111              |
      | email@example.web             | 111              |
      | email@111.222.333.44444       | 111              |
      | email@example..com            | 111              |
      | Abc..123@example.com          | 111              |
     # | this\ is"really"not\allowed@example.com | 111              |


  @negative
  Scenario Outline: Registration with only invalid email
    Given Registration page is opened
    When "<improper email>" and "<valid password>" for registration are entered
    And Register button is clicked
    Then Registration error message appears
    Examples:
      | improper email | valid password  |
      | @gmail.com     | validPassword1! |
      | test email@    | validPassword1! |
      | 1              | validPassword1! |


  @negative
  Scenario Outline: Registration with only invalid password
    Given Registration page is opened
    When "<valid email>" and "<improper password>" for registration are entered
    And Register button is clicked
    Then Registration error message appears
    Examples:
      | valid email            | improper password |
      | testemail111@gmail.com | 1                 |
      | testemail111@gmail.com | password          |
      | testemail111@gmail.com | PASSWORD          |
      | testemail111@gmail.com | pass              |
      | testemail111@gmail.com | Pass              |
      | testemail111@gmail.com | passs1234         |
      | testemail111@gmail.com | 12345678          |
      | testemail111@gmail.com | password1!        |
      | testemail111@gmail.com | PASSWORD1!        |
      | testemail111@gmail.com | Passsword1234!    |


  @negative
  Scenario Outline: Registration with blank email and/or blank password credentials
    Given Registration page is opened
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
    Given Registration page is opened
    When Existing user's "<valid email>" and "<valid password>" for registration are entered
    And Register button is clicked
    Then Registration error message appears
    Examples:
      | valid email                    | valid password  |
      | email@gmail.com                | validPassword1! |
      | firstname-lastname@example.com | validPassword1! |
      | firstname.lastname@example.com | validPassword1! |
