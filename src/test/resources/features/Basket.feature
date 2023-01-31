Feature: Shopping basket feature

  @wip
  @positive
  Scenario: Add one item to the cart and verify
    Given Shopping page is opened
    When Item is added to shopping cart
    Then  The correct price is shown in basket total
  And

  @wip
  @positive
  Scenario: Check the pop-up messages when item is added to shopping cart
    Given Shopping page is opened
    When Item is added to shopping cart
    Then The pop-up message that item has been added to basket is displayed
    And The pop-up message that basket qualifies for the Deferred benefit offer is displayed
    And The pop-up message that basket total has correct price is displayed
    And Quick Buttons View basket and Checkout now are displayed and clickable

  Scenario: Increase the quantity of the item from the cart and verify.

  Scenario: Add the same item multiple times and verify.

  Scenario: Add multiple items of different types and verify.

  Scenario: Remove some items from the cart and verify.

  Scenario: Remove all items from the cart and then verify.

  Scenario: Click on an item in the cart and verify that the user is redirected to the product detail page.

  Scenario: Check that the price of the cart is discounted when we apply a valid coupon.

  Scenario: Check that the price of the cart is not discounted when we apply an invalid coupon.

  Scenario: Add item(s) to the cart, close the browser and reopen the same site.

  Scenario: Add item(s) to the cart, close the browser and reopen the same site.

  Scenario: Verify the product QTY field when the product is out of stock.

  Scenario: Verify that the user is able to add a text note for all products.

  Scenario: Verify that the user is able to add any or all products to his wishlist by clicking on the wishlist link.

  Scenario: Verify that the user is able to mark his order as a gift.

  Scenario: Verify that the user is able to add any a gift message.

  Scenario: Verify that the user is redirected to the checkout page after clicking on the checkout button.
