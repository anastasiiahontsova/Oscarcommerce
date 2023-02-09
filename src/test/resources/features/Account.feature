Feature: Account feature


  @requiresRegistrationAndLogin
  @positive
  Scenario: User deletes profile. Profile is deleted.
    Given Account page is opened
    And Profile page is visible
    And Delete profile button is clicked
    Then Profile is deleted


  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: User edits profile and saves all changes. Changes are saved to profile
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
  Scenario: User starts to edit profile but cancels all changes. Changes are not saved to profile
    Given Account page is opened
    And Profile page is visible
    And Edit profile button is clicked
    And First name field is entered
    And Last name field is entered
    And Email address is changed
    And Cancel button is clicked
    Then All changes are not saved


  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: New user is registered. Empty name displayed on Profile page
    Given Account page is opened
    And Profile page is visible
    Then Profile name is blank

  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: New user is registered. Profile email matches the registered one
    Given Account page is opened
    And Profile page is visible
    Then Profile email matches the registered one


  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: New user is registered. You haven't placed any orders message displayed on Order History page
    Given Account page is opened
    And Profile page is visible
    When Order History is clicked
    Then You haven't placed any orders message is displayed

  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: New user is registered. There are no addresses in your Address Book message displayed on Address Book page
    Given Account page is opened
    And Profile page is visible
    When Address Book is clicked
    Then There are no addresses in your address book message is displayed

  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: New user is registered. Thank you for registering message displayed on Email History page
    Given Account page is opened
    And Profile page is visible
    When Email History is clicked
    Then Thank you for registering message is displayed

  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: New user is registered. You do not have any active alerts for out-of-stock products message displayed on Product Alerts page
    Given Account page is opened
    And Profile page is visible
    When Product Alerts is clicked
    Then You do not have any active alerts for out-of-stock products message is displayed

  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: New user is registered. There are no notifications to display message displayed on Notifications page
    Given Account page is opened
    And Profile page is visible
    When Notifications is clicked
    Then There are no notifications to display message is displayed

  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: New user is registered. You don't have any wish lists yet message displayed on Wish Lists page
    Given Account page is opened
    And Profile page is visible
    When Wish Lists is clicked
    Then You don't have any wish lists yet message is displayed


  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: User creates a new address in Address Book. New address is displayed in Address Book.
    Given Account page is opened
    And Profile page is visible
    When Address Book is clicked
    And Add a new address button is clicked
    And Enter "TestName", "TestLastName", "TestFirstLineAddress", "Berlin", "10587" into shipping address fields
    And Save new address button is clicked
    Then New address is saved and displayed on user's profile


  @requiresRegistrationAndLogin
  @deletesUserAccount
  @positive
  Scenario: User cancels creating a new address in Address Book. No changes are saved.
    Given Account page is opened
    And Profile page is visible
    When Address Book is clicked
    And Add a new address button is clicked
    And Enter "TestName", "TestLastName", "TestFirstLineAddress", "Berlin", "10587" into shipping address fields
    And Cancel adding new address button is clicked
    Then There are no addresses in your address book message is displayed


  @requiresRegistrationAndLogin
  @deletesUserAccount
  @negative
  Scenario: User enters invalid postcode when creating a new address in Address Book. Postcode error is displayed.
    Given Account page is opened
    And Profile page is visible
    When Address Book is clicked
    And Add a new address button is clicked
    And Enter "TestName", "TestLastName", "TestFirstLineAddress", "Berlin", "111" into shipping address fields
    And Save button is clicked
    Then Postcode error message is displayed