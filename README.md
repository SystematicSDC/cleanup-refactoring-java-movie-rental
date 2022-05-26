# Welcome to the Movie Rental refactoring exercise

### Starting up

We start by looking at code here in the src folder.
There are no tests! Whenever we want to touch some code that has no tests and need to improve it, what do we need to do?
We need
to write some tests! They provide a safeguard for further ensuring that it runs in the same way as before. Even if it
used to run
incorrectly, slowly or insecurely!

We will learn the following refactoring techniques:

- Renaming fields
- Extracting methods
- Moving things around (Pull-up/Push-down)
- Expressing behaviour
- Red-Green Refactor
- Generalize type

TODO:

1) Let's write some tests to see how the statement method works.
2) The MovieType would probably be suited as a separate type (maybe enum?)
3) Extract amount calculation and frequent renter calculation
4) Redundant casting (String.valueOf)
5) Introduce parameter
6) Price depends on type of movie so look for ways to generalize/pull-up
7) Magic numbers
