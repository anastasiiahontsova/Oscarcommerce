Feature: Shopping basket feature


  @wip
  @positive
  Scenario: User adds The shellcoder's handbook to the shopping cart and proceeds to checkout. Order is placed.
    Given Item container page is opened
    When Scrolled down to "The shellcoder's handbook"
    And Add to basket button is clicked from item list container
   # And Item card "The shellcoder's handbook" is opened
   #And Add to basket button is clicked from item card
    And Checkout now quick button is clicked
    And Email address is entered
    And Continue button is clicked
    And Enter "TestName", "TestLastName", "TestFirstLineAddress", "Berlin", "10587" into checkout shipping address fields
    And Continue button is clicked
    And Enter payment details
    And Continue button is clicked
    And Preview order page is opened
    And Place order button is clicked
    Then Confirmation page appears


  @positive
  Scenario: User adds The shellcoder's handbook to the shopping cart. Shopping cart total shows the correct price.
    Given Item container page is opened
    When Scrolled down to "The shellcoder's handbook"
    And Add to basket button is clicked from item list container
    And View basket button is clicked
    Then "£9.99" price is shown in basket total

  @wip
  @positive
  Scenario: User increases the quantity of The shellcoder's handbook to 2 items in the shopping cart. Shopping cart total shows the correct price for 2 items.
    Given Item container page is opened
    When Scrolled down to "The shellcoder's handbook"
    And Add to basket button is clicked from item list container
    And View basket button is clicked
    And Item Quantity is increased to "2" items
    And Update button is clicked
    Then "£19.98" price is shown in basket total


  @wip
  @positive
  Scenario: User adds The shellcoder's handbook to the shopping cart. Item has been added to basket message is present.
    Given Item container page is opened
    When Scrolled down to "The shellcoder's handbook"
    And Add to basket button is clicked from item list container
    Then The pop-up message that item has been added to basket is displayed


  Scenario: User adds The shellcoder's handbook to the shopping cart. Basket total pop-up message is correct.
    Given Item container page is opened
    When Scrolled down to "The shellcoder's handbook"
    And Add to basket button is clicked from item list container
    Then The pop-up message that basket total has correct price is displayed


  Scenario: User adds The shellcoder's handbook to the shopping cart. View basket and Checkout now buttons are present.
    Given Item container page is opened
    When Scrolled down to "The shellcoder's handbook"
    And Add to basket button is clicked from item list container
    Then Quick Buttons View basket and Checkout now are displayed and clickable


  @wip
  @positive
  Scenario: Add the same item multiple times and verify.

  @wip
  @positive
  Scenario: Add multiple items of different types and verify.

  @wip
  @positive
  Scenario: Remove some items from the cart and verify.

  @wip
  @positive
  Scenario: Remove all items from the cart and then verify.

  @wip
  @positive
  Scenario: Click on an item in the cart and verify that the user is redirected to the product detail page.

  @wip
  @positive
  Scenario: Check that the price of the cart is discounted when we apply a valid coupon.

  @wip
  @positive
  Scenario: Check that the price of the cart is not discounted when we apply an invalid coupon.

  @wip
  @positive
  Scenario: Add item(s) to the cart, close the browser and reopen the same site.

  @wip
  @positive
  Scenario: Add item(s) to the cart, close the browser and reopen the same site.

  @wip
  @positive
  Scenario: Verify the product QTY field when the product is out of stock.

  @wip
  @positive
  Scenario: Verify that the user is able to add a text note for all products.

  @wip
  @positive
  Scenario: Verify that the user is able to add any or all products to his wishlist by clicking on the wishlist link.

  @wip
  @positive
  Scenario: Verify that the user is able to mark his order as a gift.

  @wip
  @positive
  Scenario: Verify that the user is able to add any message to the order.

  @wip
  @positive
  Scenario: Verify that the user is redirected to the checkout page after clicking on the checkout button.
