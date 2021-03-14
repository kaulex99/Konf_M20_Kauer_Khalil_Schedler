# Konf_M20_Kauer_Khalil_Schedler
Repository for exercise UE02 of configuration management course.

**Group N:**
- Kauer Alexander
- Khalil Adam
- Schedler Fabian

# Main
Different liquids and drinks are created and printed on the console.


# AdamsDrink
# FabiDrink
Represents a wild mix of Liquids. Can be used to create a cocktail.  
For creation a name and a main liquid is needed.
- `toSting` creates a String with the recipe of the drink
- `addLiquid` adds a new Liquid to the drink
- `isAlcoholic` returns true if any of the liquids contains more than 0% alcohol
- `getAlcoholPercent` returns the alcohol volume percentage of the mixture
  - sums up the quantity of pure alcohol of each liquid (`pure alcohol = volume * alcohol percentage [/ 100]`)
  - this sum then gets divided by the volume of the mixture (`alcohol percentage = pure alcohol / volume [* 100]`)
- `getVolume` returns the volume of the mixture

# AlexDrink
Represents a special `FabiDrink` which has minimum 40% of alcohol
- `getAlcoholPercent` returns the alcohol volume percentage of the mixture. If lower than 40%, level will be increased automatically 
