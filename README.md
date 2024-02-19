# JavaSE-Functional

## Introduction

Concepts to understand the project

Functional programming is a programming paradigm. It is another way of working just like Object Oriented Programming. There are languages ​​that make it easier to work with functional programming and other languages ​​that make OOP easier. Java has always been an OOP-oriented language but the arrival of Java 8 favors the implementation of functional programming.
Functional programming focuses on what to solve and OOP on what elements are involved

In this project we will understand **data and functions.**

Benefits of functional programming:

- Readability
- Testing
- Concurrence
- More defined behavior
- Less state management
- You don't have to install anything additional

**What is a function?**
Parameterized steps, may or may not return result, we can store this data. A function is a type of data that operates on x and generates y.

- Functions can be defined with respect to other functions isEven(x) = !isNon(x).
- Functions can be defined with respect to themselves (Recursion).
- There can be functions that take other functions as parameters: f(x, g(x)) = x2 * (gx)

Starting with Java 8, functions become first-class cities due to the capacity conferred on them. We started treating functions as Data Types, 
which can be declared, received as parameters, or sent (returned) as results.


**Types Function**
- Pure function: deterministic (predictable result). Easy to test. Its result will always be the same as it always receives the same parameters. They do not depend on the context, it will always generate the same result and will not generate side effects, that is, it will not affect input data or other data related to other data flows. They do not depend on the state of the system.

- Impure function: non-deterministic. They depend on the state of the system. They depend on your context. They can generate side effects, that is, they can affect other data flows or be affected by other underlying data flows. They are not predictable.

A pure function can call a pure function, but not an impure one. If a pure function invokes an impure one, it will then become an impure function since the nature of the impure function will make the result of the pure function unpredictable, either by result or by the side effects and context that imply the pure function.

**Side effect**

A side effect is any change observable from outside the system is a side effect. Side effects are inevitable (because they end up being necessary), some examples are:

CRUD on files
CRUD on a database
Send/Receive a network call
Alter an object/variable used by other functions.

However, side effects should be reduced, because it helps to have a better code structure (favoring the generation of pure functions, modularity and testability).

**HIGHER ORDER FUNCTIONS**
- Take another works as a parameter.
- Returns a function after its execution.

ADVANTAGES

- Pass behaviors.
- Share a means of communication.
- Share logic/rules.

**Lambdas or anonymous function**

Lambda = Function that does not have a name.

Why use lambdas? 
- It is a unique behavior.
- It is a rule that is only required in one place.
- It is a very simple function (1 line).

**Immutability**

The data with which we are going to operate in our functions can be mutable and immutable.

We prefer immutable data.

Advantages:

- Once a data is defined it can no longer be altered. Ej id of a citizen.

- Facilitates the creation of pure functions and does not generate side effects

- Facilitates the creation of threads

Disadvantages
- For each modification, we need a new instance.

- Requires special attention in design.

- There are many mutable objects out of our reach so we must generate some way so that these objects do not mutate.Example. Java lists are mutable. We can generate immutability by returning a copy this prevents add malicious emails to an email list
