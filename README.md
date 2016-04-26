# Shopping-Cart
A Shopping Cart Service which calculates total value of items whilst applying promotional discounts
=======================================
Implementation
=======================================
I believe I have fulfilled the requirements of this test. I've kept the implementation as simple as possible as guideline says it should only take 30 - 40 minutes. If I had more time perhaps I would have designed it in a more OO way, perhaps I may have implemented a strategy pattern to apply the discount calculation, or used a DiscountCalculator functional interface and implemented using java 8 lambda statements. (I'm just thinking out loud here!)

Please be aware I have made the assumption Item information will first be retrieved from a datasource/repository after item is scanned, and based on this, new Item instances will be created, added to a list, and passed to the sumUpCartItems(List<Item> cartItems) operation.
