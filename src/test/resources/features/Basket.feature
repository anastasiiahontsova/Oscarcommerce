Feature: Shopping basket feature


  @wip
  @positive
  Scenario: User adds The shellcoder's handbook to the shopping cart and proceeds to checkout. Order is placed.
    Given Item container page is opened
    When The shellcoder's handbook item card is opened
    And Add The shellcoder's handbook to basket button is clicked
    And Checkout now quick button is clicked
    And Enter email address page is opened
    And Email address is entered
    And Enter shipping address page is opened
    And Enter "TestName", "TestLastName", "TestFirstLineAddress", "Berlin", "10587" into shipping address fields
    And Continue to Payment details page button is clicked
    And Enter payment details page is opened
    And Continue to Preview order button is clicked
    And Preview order page is opened
    And Place order button is clicked
    Then Confirmation page is opened


  @wip
  @positive
  Scenario: User adds The shellcoder's handbook to the shopping cart. Shopping cart total shows the correct price.
    Given Item container page is opened
    When Add The shellcoder's handbook to basket qiuck button is clicked
    Then  The correct price is shown in basket total


  @wip
  @positive
  Scenario: User adds The shellcoder's handbook to the shopping cart. The pop-up messages displayed are correct.
    Given Item container page is opened
    When Add The shellcoder's handbook to basket quick button is clicked
    Then The pop-up message that item has been added to basket is displayed
    And The pop-up message that basket qualifies for the Deferred benefit offer is displayed
    And The pop-up message that basket total has correct price is displayed
    And Quick Buttons View basket and Checkout now are displayed and clickable

  @wip
  Scenario: Increase the quantity of the item from the cart and verify.

  @wip
  Scenario: Add the same item multiple times and verify.

  @wip
  Scenario: Add multiple items of different types and verify.

  @wip
  Scenario: Remove some items from the cart and verify.

  @wip
  Scenario: Remove all items from the cart and then verify.

  @wip
  Scenario: Click on an item in the cart and verify that the user is redirected to the product detail page.

  @wip
  Scenario: Check that the price of the cart is discounted when we apply a valid coupon.

  @wip
  Scenario: Check that the price of the cart is not discounted when we apply an invalid coupon.

  @wip
  Scenario: Add item(s) to the cart, close the browser and reopen the same site.

  @wip
  Scenario: Add item(s) to the cart, close the browser and reopen the same site.

  @wip
  Scenario: Verify the product QTY field when the product is out of stock.

  @wip
  Scenario: Verify that the user is able to add a text note for all products.

  @wip
  Scenario: Verify that the user is able to add any or all products to his wishlist by clicking on the wishlist link.

  @wip
  Scenario: Verify that the user is able to mark his order as a gift.

  @wip
  Scenario: Verify that the user is able to add any a gift message.

  @wip
  Scenario: Verify that the user is redirected to the checkout page after clicking on the checkout button.
