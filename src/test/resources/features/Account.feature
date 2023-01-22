Feature: Account feature

  #table xpaths and links are not good

  #it looks like I always use scenario outline. Is it ok? If I only need credentials to log in as a beforestep for each scenario



  @wip
    @positive
  Scenario Outline: Account contains correct profile details
    Given Login and Registration page is opened
    When User is registered and logged in with "<valid email>" and "<valid password>"
    And  Account button is clicked
    And Profile page is visible
    Then Profile name is blank
    And Profile email coincides with the registered one
    #And Date registered is correct
    Examples:
      | valid email     | valid password  |
      | email@gmail.com | validPassword1! |


  @wip
    @positive
  Scenario Outline: Deletion of user's profile
    Given Login page is opened
    When User is registered and logged in with "<valid email>" and "<valid password>"
    And  Account button is clicked
    And Profile page is visible
    And Delete profile button is clicked
    Then Profile is deleted
    Examples:
      | valid email     | valid password  |
      | email@gmail.com | validPassword1! |

  @wip
    @positive
  Scenario Outline: Edition and saving changes to user's profile
    Given Login page is opened
    When User is registered and logged in with "<valid email>" and "<valid password>"
    And  Account button is clicked
    And Profile page is visible
    And Edit profile button is clicked
    And First name field is entered
    And Last name field is entered
    And Email address is changed
    And Save button is clicked
    Then All changes are saved
    Examples:
      | valid email     | valid password  |
      | email@gmail.com | validPassword1! |

  @wip
    @positive
  Scenario Outline: Edition and cancelling changes to user's profile
    Given Login page is opened
    When User is registered and logged in with "<valid email>" and "<valid password>"
    And  Account button is clicked
    And Profile page is visible
    And Edit profile button is clicked
    And First name field is entered
    And Last name field is entered
    And Email address is changed
    And Cancel button is clicked
    Then All changes are not saved
    Examples:
      | valid email     | valid password  |
      | email@gmail.com | validPassword1! |

  @wip
    @positive
  Scenario Outline: Ensure that all Account sections contain no information in ase of a new registered user
    Given Login page is opened
    When User is registered and logged in with "<valid email>" and "<valid password>"
    And  Account button is clicked
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
    Examples:
      | valid email     | valid password  |
      | email@gmail.com | validPassword1! |

  @wip
    @positive
  Scenario Outline: Adding and saving a new address to user's account
    Given Login page is opened
    When User is registered and logged in with "<valid email>" and "<valid password>"
    And  Account button is clicked
    And Profile page is visible
    When Address Book section is clicked
    And Add a new address button is clicked
    And All user's info fields are filled
    And Save button is clicked
    Then New address is saved and displayed on user's account
    Examples:
      | valid email     | valid password  |
      | email@gmail.com | validPassword1! |

  @wip
    @positive
  Scenario Outline: Adding and cancelling adding a new address to user's account
    Given Login page is opened
    When User is registered and logged in with "<valid email>" and "<valid password>"
    And  Account button is clicked
    And Profile page is visible
    When Address Book section is clicked
    And Add a new address button is clicked
    And All user's info fields are filled
    And Cancel button is clicked
    Then New address is not saved and not displayed on user's account
    Examples:
      | valid email     | valid password  |
      | email@gmail.com | validPassword1! |

  @wip
    @negative
  Scenario Outline: Adding and saving a new address with improper data to user's account
    Given Login page is opened
    When User is registered and logged in with "<valid email>" and "<valid password>"
    And  Account button is clicked
    And Profile page is visible
    When Address Book section is clicked
    And Add a new address button is clicked
    And All user's info fields are filled with improper data
    And Save button is clicked
    Then Error message is displayed
    Examples:
      | valid email     | valid password  |
      | email@gmail.com | validPassword1! |





