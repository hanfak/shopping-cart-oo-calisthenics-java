 # Rules

 See

 http://codekata.com/kata/kata09-back-to-the-checkout/

  Item   Unit      Special
         Price     Price
  --------------------------
    A     50       3 for 130
    B     30       2 for 45
    C     20
    D     15

# Interface

    co = CheckOut.new(pricing_rules)
    co.scan(item)
    co.scan(item)
        :    :
    price = co.total


# Code rules

    The app must be created using the "Object Calisthenics" methodology by Jeff Bay

    One level of indentation per method
    Don’t use the ELSE keyword
    Wrap all primitives and Strings
    First class collections
    One dot per line
    Don’t abbreviate
    Keep all entities small (50 lines)
    No classes with more than two instance variables
    No getters/setters/properties


# Process

    Apply TDD

    1 - Write test
    2 - Make it compile
    3 - Watch it fail
    4 - Make all test pass with minimum amount of code
    5 - Refactor
        a - Use above code rules