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

Disadvantages:

- For each modification, we need a new instance.

- Requires special attention in design.

- There are many mutable objects out of our reach so we must generate some way so that these objects do not mutate.Example. **Java lists are mutable. We can generate immutability by returning a copy this prevents add malicious emails to an email list**

## 1. PAQUET JAVA.UTIL.FUNCTION

### FUNCTION

Using the Function interface of the java.util.function package, it is possible to define functions as if they were just another variable. This is done by instantiating an anonymous class that implements the Function<T, R> interface, where T is the type of data that will be received as a parameter, and R is the type of data returned. In addition, you must @Override the **apply method** by writing in it the code that corresponds to the function you want to define. ⠀


### PREDICATE

Using the Predicate interface, it is possible to define functions just as with Function, but in this case the result type will always be Boolean, and you must @Override the **test method**. ⠀

For example, you can define the predicate isEven that receives an Integer.

### CONSUMER AND SUPPLIER

- Consumer: It is a lambda expression that accepts a single value and does not return any value. Example: A function that receives a list of files and deletes each of them, without returning anything.

- Supplier: It is an expression that has no parameters but returns a result. Example: A supplier of type CLIArguments called generator is created that does not receive a parameter but creates a new CLIArguments object and returns generator. Files can be created on demand.

### OPERATORS AND BIFUNCTION
These functions extend Function. It means that they have the apply method.

- **UnaryOPerator** --> Only a single data type is specified. It will result in the same type.

- **BinaryOperator** --> Only one data type is specified. It will have **2 input parameters and one return** parameter of the same data type.

- **Bifunction** --> 2 input parameters, the data type must be specified. It can have different types of inputs as well as different types of output.

## 2. SAM Y FUNCTIONAL INTERFACE

- **SAM** is the abbreviation of ++Single Abstract Method++.

- A functional interface is an interface that contains only one **abstract method**. They can have only one functionality to exhibit. From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface. A functional interface can have any number of default methods. Runnable, ActionListener, Comparable are some of the examples of functional interfaces.Before Java 8, we had to create anonymous inner class objects or implement these interfaces.

- @FunctionalInterface annotation is used to ensure that the functional interface can’t have more than one abstract method. In case more than one abstract methods are present, the compiler flags an ‘Unexpected @FunctionalInterface annotation’ message. However, it is not mandatory to use this annotation.

## 3. REFERENCE OPERATOR

The double colon ( :: ) operator, also known as method reference operator in Java, is used to call a method by referring to it with the help of its class directly. They behave exactly as the lambda expressions. The only difference it has from lambda expressions is that this uses direct reference to the method by name instead of providing a delegate to the method.

Method reference or double colon operator can be used to refer:

A static method: (ClassName::methodName)

An instance method: (objectOfClass::methodName)

A constructor: (super::methodName)

## 4. TYPE INFERENCE

Type inference automatically assigns a data type to a function without requiring the programmer to write it.

## 5. SYNTAX OF LAMBDAS FUNCTIONS

Lambda that receives a parameter and performs a simple operation:

```bash
(text -> System.out.println(text))
```
Lambda that takes no parameters and performs a simple return operation:

```bash
(() -> "Hello world")
```
Lambda that receives a single parameter and performs a simple return operation:

```bash
x -> x % 2 == 0
```
Lambda that receives several parameters (BiFunction):

```bash
(x, y) -> x * y
```
Lambda that performs several operations:

```bash
(x, y) -> {
  System.out.println("Suma de x: " + x + ", y: " + y);
  System.out.println(x + y);
}
```
Lambda that performs various operations and returns:

```bash
(x, y) -> {
  System.out.println("Suma de x: " + x + ", y: " + y);
  return x + y;
}
```

**When performing operations with keys, return must be indicated explicitly.**

Lambda with parameter typing:

```bash
(String text) -> System.out.println(text);
```

Lambda that returns a data that occupies several lines:

```bash
() -> (
  "<div class='movieSearch'>" +
  " <div class='movie-close'>" +
  "   <button class='movie-close-button'>" +
  "     <figure>" +
  "       <img src='src/images/close.png'>" +
  "     </figure>" +
  "   </button>" +
  " </div>" +
  "</div>"
)
```

Lambda that does not receive anything by parameters and does not return anything either.
Example: When we need to make a connection. We may not need to receive anything as a parameter and it does not return anything.
```bash
(() -> {})

(() -> ¨{System.out.println("Nothing");
});

(() -> {
  System.out.println("Nothing");
  System.out.println("Nothing");
});
```


## 6. DEFAULT METHOD

Default gives us the possibility of defining a base behavior for the interface and thus defining what parameters will be necessary.

## 7. CHAINING

Chaining consists of making consecutive calls to different methods of the same object. ⠀ 
A clear example is when using the StringBuilder class, it allows you to chain calls to the initially created object to manipulate the creation of a String.

## 8. COMPOSITION OF FUNCTIONS

Higher order functions take a function as a parameter and generate a function as a result.

Difference between **compose** and **andThen** is the order they execute the functions. While the compose function executes the caller last and the parameter first, the andThen executes the caller first and the parameter last. Let's first define two simple functions - times2 and squared.

## 9. CLASS OPTIONAL

The Optional class allows you to encapsulate data whose value is not certain, avoiding the use of null values, NullPointerException exceptions and the repetition of data type checks != null. ⠀ This class also provides methods that can be used to manage the data within the Optional, or to consider cases when the data is not present. Depending on the case, these methods can receive a Function, Consumer, Supplier, etc. ⠀ For example, the getPerson function loads a Person from the database and returns it within an Optional<Person>.

## 10. STREAM
Stream: It is a data stream, the stream class is a list that contains self-iterable elements. When you create a list, you decide what operations to do for each item in the list.

Streams are used to process collections of objects. A stream is a sequence of objects that supports multiple methods that can be piped to produce the desired result.

The features of Java stream are:

- A stream is not a data structure, but rather takes information from collections.

- Streams do not change the original data structure, they only provide the result based on the piped methods.

- Each intermediate operation is executed lazily and returns a stream as a result, so multiple intermediate operations can be pipelined. Terminal operations mark the end of the sequence and return the result.

## 11. STREAM LISTENER

Streams have two types of operations:

**Intermediate Operations**: Generate a new Stream

- **map**: The map method is used to returns a stream consisting of the results of applying the given function to the elements of this stream. List number = Arrays.asList(2,3,4,5);  List square = number.stream().map(x-&gt;x*x).collect(Collectors.toList());

- **filter**: The filter method is used to select elements as per the Predicate passed as argument.     List names = Arrays.asList(&quot;Reflection&quot;,&quot;Collection&quot;,&quot;Stream&quot;);  List result = names.stream().filter(s-&gt;s.startsWith(&quot;S&quot;)).collect(Collectors.toList());

- **sorted**: The sorted method is used to sort the stream.     List names = Arrays.asList(&quot;Reflection&quot;,&quot;Collection&quot;,&quot;Stream&quot;); List result = names.stream().sorted().collect(Collectors.toList());

**Terminal Operations**: Generate final data

- **collect**: The collect method is used to return the result of the intermediate operations performed on the stream.     List number = Arrays.asList(2,3,4,5,3);  Set square = number.stream().map(x-&gt;x*x).collect(Collectors.toSet());

- **forEach**: The forEach method is used to iterate through every element of the stream.     List number = Arrays.asList(2,3,4,5);  number.stream().map(x-&gt;x*x).forEach(y-&gt;System.out.println(y));

- **reduce**: The reduce method is used to reduce the elements of a stream to a single value. The reduce method takes a BinaryOperator as a parameter.     List number = Arrays.asList(2,3,4,5);  int even = number.stream().filter(x-&gt;x%2==0).reduce(0,(ans,i)-&gt; ans+i);

## 12. OPERATIONS AND COLLECTORS

These functions that receive lambdas and are responsible for working (operating) on ​​the data of a Stream are generally known as **Operations.**

There are two types of operations: intermediate and final.

Each operation applied to a Stream makes the original Stream no longer usable for further operations. It is important to remember this, because trying to add operations to a Stream that is already being processed is a very common mistake.

Once you have added operations to your data Stream, you will most often reach a point where you can no longer work with a Stream and need to send your data in another format, for example, JSON or a List to the database.

There is a single interface that combines all the aforementioned interfaces and whose sole purpose is to provide an operation to obtain all the elements of a Stream: **Collector.**

Collector<T, A, R> is an interface that will take data of type T from the Stream, a mutable data type A, where the elements will be added (mutable implies that we can change its content, like a LinkedList), and will generate a type R result.

For this reason, to facilitate operations , Java 8 includes a series of Collectors already defined so as not to puzzle over how to convert our data.

```bash
public List<String> getJavaCourses(Stream<String> coursesStream) {
    List<String> javaCourses =
        coursesStream.filter(course -> course.contains("Java"))
            .collect(Collectors.toList());

    return javaCourses;
}
```

Using java.util.stream.Collectors we can very easily convert a Stream into a Set, Map, List, Collection, etc. The Collectors class already has methods to generate a Collector that corresponds to the data type that your Stream is using. It is even worth noting that Collectors can generate a ConcurrentMap that can be useful if you require multiple threads.

Using Collectors.toXXX is the reverse process of using Collection.stream(). This makes it easy to generate public APIs that work with common structures/collections and internally use Stream to streamline operations on our end.

The only way to obtain data that is no longer a Stream is by using Collectors, since most Stream operations focus on operating the data from the Stream and generating a new Stream with the results of the operation.

However, some operations do not have a return. For example, forEach, which is an operation that does not generate any data. In order to understand what each operation does, it is enough to consider what the operation does in order to understand what may or may not return.

For example:

The findAny operation tries to find any element that meets the condition of the Predicate that we pass as a parameter. However, the operation says that an Optional is returned. What happens when you don't find any items? Of course, that's why it returns an Optional! Because there could be cases where no element in the Stream meets the condition.

## 13. TYPE-SPECIFIC STREAM AND PARALLELISM
When to use Parallel Streams?

- They should be used when the output of the operation is not needed to be dependent on the order of elements present in source collection (i.e. on which the stream is created)

- Parallel Streams can be used in case of aggregate functions

- Parallel Streams quickly iterate over the large-sized collections

- Parallel Streams can be used if developers have performance implications with the Sequential Streams

- If the environment is not multi-threaded, then Parallel Stream creates thread and can affect the new requests coming in

## 14. TERMINAL OPERATIONS

## 15. INTERMEDIATE OPERATIONS

## 16. COLLECTORS

# PROYECT JOB-SEARCH

