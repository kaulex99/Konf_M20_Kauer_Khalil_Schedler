# Konf_M20_Kauer_Khalil_Schedler
Repository for exercise UE02 of configuration management course.

**Group N:**
- Kauer Alexander
- Khalil Adam
- Schedler Fabian

## Main
Different liquids and drinks are created and printed on the console.


## AdamsDrink
Represents a beverage and extends -`AlexDrink` class AdamsDrink class  
- `getVolume()` adds a liter of  liquid
- `isAlcoholic` checks if the drink is alcoholic or not so if the drink has more than = 0% alcohol it returns true
- `getAlcoholPercent` takes the return values of the parent class and divides it by ten since I can not bypass the class parents behaviour



## FabiDrink
Represents a wild mix of Liquids. Can be used to create a cocktail.  
For creation a name and a main liquid is needed.
- `toSting` creates a String with the recipe of the drink
- `addLiquid` adds a new Liquid to the drink
- `isAlcoholic` returns true if any of the liquids contains more than 0% alcohol
- `getAlcoholPercent` returns the alcohol volume percentage of the mixture
  - sums up the quantity of pure alcohol of each liquid (`pure alcohol = volume * alcohol percentage [/ 100]`)
  - this sum then gets divided by the volume of the mixture (`alcohol percentage = pure alcohol / volume [* 100]`)
- `getVolume` returns the volume of the mixture

## AlexDrink
Represents a special `FabiDrink` which has minimum 40% of alcohol
- `getAlcoholPercent` returns the alcohol volume percentage of the mixture. If lower than 40%, level will be increased automatically 	

# Tests

## AdamsTest
The goal was to reach 100% tests coverage. So we had to test every method of the class. Generally, to tell Java that we want to create a test method, we have to add `@Test` above. In the `@BeforeEach` annotated method, we create an instance of the Drink, so we have an instance ready to test. 

## FabiTest
With the tests 2 errors in the class could be detected:
- `getAlcoholPercent` Error when no Liquid was added (Division by zero)
- `toString` Wrong format of alcohol percentage (too many decimal places)

## TestCoverage result by IntelliJ
| Classname  | Class [%]  | Method [%]  | Line [%]  | 
|:-:|:-:|:-:|:-:|
| AdamsDrinkTest  | 100%  | 100%  | 100%  |
| FabiDrink  | 100  | 100  | 100  |
|   |   |   |   |
