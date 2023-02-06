Feature: Account feature


  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: Account contains correct profile details
    Given Account page is opened
    And Profile page is visible
    Then Profile name is blank
    And Profile email coincides with the registered one


  @requiresRegistrationAndLogin
  @positive
  Scenario: Deletion of user's profile
    Given Account page is opened
    And Profile page is visible
    And Delete profile button is clicked
    Then Profile is deleted


  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: Edition and saving changes to user's profile
    Given Account page is opened
    And Profile page is visible
    And Edit profile button is clicked
    And First name field is entered
    And Last name field is entered
    And Email address is changed
    And Save button is clicked
    Then All changes are saved


  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: Edition and cancelling changes to user's profile
    Given Account page is opened
    And Profile page is visible
    And Edit profile button is clicked
    And First name field is entered
    And Last name field is entered
    And Email address is changed
    And Cancel button is clicked
    Then All changes are not saved


  @wip
  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: Ensure that all Account sections contain no information in case of a new registered user
    Given Account page is opened
    And Profile page is visible
    Then Profile name is blank
    When Order History is clicked
    Then You haven't placed any orders message is displayed
    When Address Book is clicked
    Then There are no addresses in your address book. message is displayed
    When Email History is clicked
    Then Thank you for registering. message is displayed
    When Product Alerts is clicked
    Then You do not have any active alerts for out-of-stock products. message is displayed
    When Notifications is clicked
    Then There are no notifications to display. message is displayed
    When Wish Lists is clicked
    Then You don't have any wish lists yet. message is displayed


  @wip
  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: Adding and saving a new address to user's account
    Given Account page is opened
    And Profile page is visible
    When Address Book is clicked
    And Add a new address button is clicked
    And All required user's info fields are filled
    And Save new address button is clicked
    Then New address is saved and displayed on user's profile


  @wip
  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: Adding and cancelling adding a new address to user's account
    Given Account page is opened
    And Profile page is visible
    When Address Book is clicked
    And Add a new address button is clicked
    And All required user's info fields are filled
    And Cancel adding new address button is clicked
    Then There are no addresses in your address book. message is displayed


  @wip
  @requiresRegistrationAndLogin
  @deletesUserAccount
  @negative
  Scenario: Adding and saving a new address with improper data to user's account
    Given Account page is opened
    And Profile page is visible
    When Address Book is clicked
    And Add a new address button is clicked
    And All user's info fields are filled with invalid data
    And Save button is clicked
    Then New address error message is displayed