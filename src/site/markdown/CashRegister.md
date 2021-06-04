# CashRegister feature

This feature will implement a cash register which allows selling drinks and generating following revenue reports:

- revenue from none alcoholic drinks
- revenue from low alcoholic drinks (0 < % <= 16)
- revenue from high alcoholic drinks (% > 16)
- revenue at a specific day
- revenue from a specific seller
- revenue from a specific seller at a specific day

## Branching strategy

First we will create a feature branch ("cash-register") which we will use for the feature implementation. At first, we
will do the setup (creation of classes and methods) on that branch.  
Then everyone will create a branch for the reports he will implement. When the implementation of the reports are
finished this branches will then get merged back into the "cash-register" branch. If necessary then on that branch some
general corrections are made and then the branch gets merged back into main.

This is done so that everyone in the team can work on his part for himself without getting bigger merging conflicts.

We also decided to use the pull request feature and review the changes a person made before they get merged. So that the
possibility of forgetting something is lowered.

## Implementation concept

- An interface (Buyable) with a getter for the price, the isAlcoholic and the alcohol percentage is created. The abstract Drink class implements this. In every
  drink the return value will be overridden
    - So that not the whole project must be refactored, the price is statically "calculated" for each type of drink
      (price can't be set or passed from outside)
- A class (Transaction) with a Buyable, a seller name and buy date is created
    - For simplicity the seller gets only represented by a string (name)
- The CashRegister class has a list of transactions and a sell method which is used to add transactions
    - For every report there is an own method, calculating the requested revenue report from the transaction list

### Responsibility
- Alexander will implement the day and person related reports and do the setup
- Adam will implement the alcoholic drinks related reports
- Fabian will implement the base functions and the non-alcoholic drink report