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

Terminal operations are those operations that do not generate a new Stream as a result. Your result may vary depending on the operation. The usefulness of these is to be able to generate a final value for all our operations or consume the final data. The main reason for wanting this is that the data will need to exit at some point in our control and it is with terminal operations that we do this.

Let's think, for example, of a web server. Receives a data request, converts the request into a Stream<JSON>, processes the data using filter or map, converts JSON to local data that can be manipulated by Java code and consumes a database. All this through streams of different types. But eventually it has to return a response to the person who made the request.

What happens if the person who made the request is not using Java? We cannot send a Stream type object to code made in Python or JavaScript... that is where a final operation helps us convert our Java Stream into some type of data that is more understandable.

Another clear example is if we are creating a library or creating code that more people on our team will use. When creating our methods and classes we use streams here and lambdas there, but by exposing these methods for use by other developers we cannot force them to use Stream.

The reasons are varied. We do not want to force and limit those who use our code to work with a single data type. We don't know what version of Java anyone using our code is using. We don't know if Stream is available in your part of the code (e.g. on Android it wasn't available at all), etc.

That is why we would like to provide something simpler: lists, primitives or even provide some mechanism to be able to use external code on our side.

The most common terminal operations found in Stream are:

**Terminal matching operations**
anyMatch, allMatch, noneMatch
The anyMatch, allMatch and noneMatch operations are used to determine if there are elements in a Stream that satisfy a certain Predicate.
All three return a boolean:

//Tells us if a stream contains an element according to the Predicate that we pass to it:
```bash
Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 11);
boolean biggerThanTen = numbersStream.anyMatch(i -> i > 10); //true because we have 11
```
//allMatch
//Tells us if all the elements of a Stream comply with a certain Predicate:
```bash
Stream<Integer> agesStream = Stream.of(19, 21, 35, 45, 12);
boolean allLegalDrinkingAge = agesStream.allMatch(age -> age > 18); //false, we have a minor
```
//noneMatch
//Tells us if all the elements of a Stream DO NOT MEET a certain Predicate:
```bash
Stream<Integer> oddNumbers = Stream.of(1, 3, 5, 7, 9, 11);
boolean allAreOdd = oddNumbers.noneMatch(i -> i % 2 == 0);
```

**Search terminal operations**
findAny, findFirst
These operations return an Optional<T> as a result of searching for an element within the Stream.

The difference between the two is that findFirst will return an Optional containing the first element in the Stream if the Stream has previously defined a sorting operation or to find elements. Otherwise, it will work the same as findAny, trying to return any element present in the Stream in a non-deterministic (random) way.

If the found element is null, you'll have to deal with an annoying NullPointerException. If the Stream is empty, the return is equivalent to Optional.empty().

The main reason for using these operations is to be able to use the elements of a Stream after having filtered and converted data types. With Optional we ensure that, even if there are no results, we can continue working without exceptions or writing conditionals to validate the data.

**Terminal reduction operations**
**min, max**
They are two operations whose purpose is to obtain the smallest element (min) or the largest element (max) of a Stream using a Comparator. There may be cases of empty Streams, which is why the two operations return an Optional so that in those cases we can use Optional.empty.

The Comparator interface is a @FunctionalInterface, so it's easy to use min and max with lambdas:

```bash
Stream<Long> bigNumbers = Stream.of(100L, 200L, 1000L, 5L);
Optional<Long> minimumOptional = bigNumbers.min((numberX, numberY) -> (int) Math.min(numberX, numberY));
```
**Reduces**
This operation exists in three forms:

- reduce(initialValue, BinaryOperator)
- reduce(BinaryAccumulator)
- reduce(initialValue, BinaryFunction, BinaryOperator)
The difference between the 3 types of invocation:

1. Reduce(BinaryAccumulator)
Returns an Optional of the same type as the Stream, with a single value resulting from applying the BinaryAccumulator on each element or Optional.empty() if the stream was empty. You can throw a NullPointerException in cases where the result of the BinaryAccumulator is null.

```bash
Stream<String> aLongStoryStream = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
Optional<String> longStoryOptional = aLongStoryStream.reduce((previousStory, nextPart) -> previousStory + " " + nextPart);
longStoryOptional.ifPresent(System.out::println); //"Cuando despertó, el dinosaurio todavía estaba allí."
```

2. Reduce(valorInicial, BinaryOperator)
Retorna un valor del mismo tipo que el Stream después de aplicar BinaryOperator sobre cada elemento del Stream. En caso de un Stream vacío, el valorInicial es retornado.


```bash
Stream<Integer> firstTenNumbersStream = Stream.iterate(0, i -> i + 1).limit(10);
int sumOfFirstTen = firstTenNumbersStream.reduce(0, Integer::sum); //45 -> 0 + 1 + … + 9
```

And the most interesting case...

3. reduce(initialValue, BinaryFunction<V, T, V>, BinaryOperator<V>)
Generates a value of type V after applying BinaryFunction on each element of type T in the Stream and obtaining a result V.

This version of reduce uses the BinaryFunction like map + reduce. That is, for each element in the Stream a value V is generated based on the InitialValue and the previous result of the BinaryFunction. BinaryOperator is used in parallel streams (stream.parallel()) to determine the value to hold in each iteration.

```bash
Stream<String> aLongStoryStreamAgain = Stream.of("Cuando", "despertó,", "el", "dinosaurio", "todavía", "estaba", "allí.");
int charCount = aLongStoryStreamAgain.reduce(0, (count, word) -> count + word.length(), Integer::sum);
```

**count**
A simple operation: it is used to obtain how many elements there are in the Stream.

```bash
Stream<Integer> yearsStream = Stream.of(1990, 1991, 1994, 2000, 2010, 2019, 2020);
long yearsCount = yearsStream.count(); //7, it only tells us how much data the stream had.
```
The main reason for using this operation is that, by applying filter or flatMap, our Stream can grow or decrease in size and, perhaps, for many operations we are only interested in knowing how many elements were present in the Stream. For example, how many files were deleted or how many were created, for example.

**toArray**
Adds all the elements of the Stream to an array and returns said array. The operation generates an Object[], but it is possible to cast to the Stream data type.

**collect**
We mentioned the collect operation in the reading about operations and collectors, where we mentioned that:


Collector<T, A, R> is an interface that will take data of type T from the Stream, a mutable data type A, where the elements will be added (mutable implies that we can change its content, like a LinkedList) and will generate a result type R.
Using java.util.stream.Collectors we can simply convert a Stream into a Set, Map, List, Collection, etc. The Collectors class already has methods to generate a Collector that corresponds to the type of data that your Stream is using. It is even worth noting that Collectors can generate a ConcurrentMap that can be useful if you require multiple threads.

```bash
public List<String> getJavaCourses(Stream<String> coursesStream) {
     List<String> javaCourses =
         coursesStream.filter(course -> course.contains("Java"))
             .collect(Collectors.toList());

     return javaCourses;
}
```

**Terminal iteration operations**
**forEach**
As simple and as cute as a classic for. forEach is an operation that receives a Consumer<T> and does not have a return value (void). The main use of this operation is to give a final use to the elements of the Stream.

```bash
Stream<List<String>> courses = getCourses();
courses.forEach(courseList -> System.out.println("Available courses: " + courseList));
```
**Conclusions**
Terminal operations are responsible for giving an end and freeing the space used by a Stream. They are also the way to break method chains between streams and return our code to a linear execution point. As their name implies, they are usually the last operation present when you write chaining:

```bash
Stream<Integer> infiniteStream = Stream.iterate(0, x -> x + 1);
List<Integer> numbersList = infiniteStream.limit(1000)
     .filter(x -> x % 2 == 0) // Intermediate operation
     .map(x -> x * 3) //Intermediate operation
     .collect(Collectors.toList()); //Final operation
```
Finally, remember that once you have added an operation to a Stream, the original Stream can no longer be used. And even more so when adding a terminal operation, since this no longer creates a new Stream. Internally, upon receiving an operation, the Stream at some point calls its close method, which is responsible for freeing the data and memory of the Stream.

## 15. INTERMEDIATE OPERATIONS

Any operation within a Stream that returns a new Stream as a result is called an intermediate operation. That is, after invoking an intermediate operation with a certain type of data, we will obtain a new Stream containing the already modified data as a result.

The Stream that receives the intermediate operation becomes “consumed” after the invocation of the operation, making it unusable for subsequent operations. If we decide to use the Stream for some other type of operations we will have an IllegalStateException.

Seeing it in code with an example should be clearer:

```bash
Stream<String> initialCourses = Stream.of("Java", "Spring", "Node.js");

Stream<Integer> lettersOnCourses = initialCourses.map(course -> course.length());
//From this point on, initialCourses cannot add any more operations.

Stream<Integer> evenLengthCourses = lettersOnCourses.filter(courseLength -> courseLength % 2 == 0);
//lettersOnCourses is consumed at this point and cannot add any more operations. It is not possible to use the Stream other than as a reference.

```

The previous example can be rewritten using chaining. However, the usefulness of this example is to demonstrate that the intermediate operations generate a new Stream.

**Available operations**

The Stream interface has a group of intermediate operations. Throughout this reading we will explain each of them and try to approximate their functionality. Each operation has different implementations depending on the Stream implementation. In our case, we will only make approximations of the logic that the operation follows.

The operations that are already defined are:

filter(…)
map(…)
flatMap(…)
distinct(…)
limit(…)
peek(…)
skip(…)
sorted(…)

Let's analyze what each of them does and make code that is close to what they do internally.

**filter**

Stream's filtering operation has the following form:

```bash
Stream<T> filter(Predicate<? super T> predicate)
```

Some things that we can deduce only by seeing the elements of the operation are:

- The operation works on a Stream and returns a new Stream of the same type (T)
- However, the Predicate that receives as a parameter works with elements of type T and any element as long as it is a subtype of T. This means that if we have the class PlatziStudent extends Student and we have a Stream<Student> where we also have elements of type PlatziStudent, we can filter them without having to review or clarify the type
- Predicate is a @FunctionalInterface (as you saw in class 11), which allows us to pass as a parameter objects that implement this interface or lambdas

The use of this operation is simple:

```bash
public Stream<String> getJavaCourses(List<String> courses){
     return courses.stream()
         .filter(course -> course.contains("Java"));
}
```
The interesting thing resides in the condition that we use in our lambda, with it we determine whether or not an element should remain in the resulting Stream. In the previous reading we made an approximation of the filter operation:

```bash
public Stream<T> filter(Predicate<T> predicate) {
     List<T> filteredData = new LinkedList<>();
     for(T t : this.data){
         if(predicate.test(t)){
             filteredData.add(t);
         }
     }

     return filteredData.stream();
}
```

filter is responsible for iterating each element of the Stream and evaluating with the Predicate whether or not the element should be in the resulting Stream. If our Predicate is simple and does not include any loops or calls to other functions that may have loops, the time complexity is O(n), which makes filtering quite fast.

Common uses of filter is to clean a Stream of data that does not meet a certain criteria. As an example, you could think of a Stream of banking transactions, keep the Stream only those that exceed a certain amount to send them to audit, from a group of student grades, filter only those who passed with a grade higher than 6, from a group of JSON objects keep those that have a specific property, etc.

The simpler the filter condition, the more readable the code will be. I recommend that, if you have more than one filter condition, don't be afraid to use filter several times:

```bash
courses.filter(course -> course.getName().contains("Java"))
     .filter(course -> course.getDuration() > 2.5)
     .filter(course -> course.getInstructor().getName() == Instructors.SINUHE_JAIME)
```
Your code will be more readable and the reasons why you are applying each filter will make more sense. As something additional, you could move this logic to individual functions in case you want to make the code more readable, have an easier time writing tests, or use the same logic in more than one place for some lambdas:

```bash
courses.filter(Predicates::isAJavaCourse)
     .filter(Predicates::hasEnoughDuration)
     .filter(Predicates::hasSinuheAsInstructor);

// The logic is the same:
public final class Predicates {
     public static final boolean isAJavaCourse(Course course){
         return course.getName().contains("Java");
     }
}

```

**map**

The map operation may seem complicated at first and even confusing if you are used to using Map<K,V>, but it should be noted that there is no relationship between the structure and the operation. The operation is merely a transformation from one type to another.

```bash
Stream<R> map(Function<? super T, ? extends R> mapper)
```
The details to highlight are very similar to those of filter, but the key difference is in T and R. These generics tell us that map is going to take a data type T, whatever it is, it will apply the mapper function and generate an R .

It is something similar to what you did in high school when converting data into a table, for each x you applied an operation and obtained a y (some call this tabular). map will operate on each element in the initial Stream applying the Function that you pass to it as a lambda to generate a new element and make it part of the resulting Stream:

```bash

Stream<DatabaseID> ids = DatabaseUtils.getIds().stream();

Stream<User> users = ids.map(id -> db.getUserWithId(id));
```
Or, put another way, for each DatabaseID in the initial Stream, applying map generates a User:

- DatabaseID(1234) -> map(…) -> User(Sinuhe Jaime, @Sierisimo)
- DatabaseID(4321) -> map(…) -> User(Diego de Granda, @degranda10)
- DatabaseID(007) -> map(…) ->User(Oscar Barajas, @gndx)

This is quite practical when we want to do some data conversion and we are not really interested in the complete data (only parts of it) or if we want to convert to complex data based on a base data.

If we wanted to replicate what map does internally it would be relatively simple:

```bash
public Stream<R> map(Function<T, R> mapper) {
     List<R> mappedData = new LinkedList<>();
     for(T t : this.data) {
         R r = mapper.apply(t);
         mappedData.add(r);
     }

     return mappedData.stream();
}

```
The map operation seems simple already seen this way. However, within the different implementations of Stream it makes several validations and optimizations so that the operation can be invoked in parallel, to prevent some type conversion errors and make it faster than our version with a for.

**flatMap**

Sometimes we cannot avoid encountering streams of the type Stream<List<Courses>>, where we have data with a lot of data...

This type of stream is quite common and can happen to you for multiple reasons. It can become difficult to operate the initial Stream if we want to apply some operation to each of the elements in each of the lists.

If maintaining the structure of the lists (or collections) is not important for the processing of the data they contain, then we can use flatMap to simplify the structure of the Stream, changing it from Stream<List<Courses>> to Stream<Courses>.

Seen in a more “visual” example:
```bash
Stream<List<Courses>> coursesLists; // Stream{List["Java", "Java 8 Functional", "Spring"], List["React", "Angular", "Vue.js"], List["Big Data", "Pandas"]}
Stream<Courses> allCourses; // Stream{ ["Java", "Java 8 Functional", "Spring", "React", "Angular", "Vue.js", "Big Data", "Pandas"]}
```

flatMap has the following form:
```bash
<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
```

The interesting thing is that the result of the mapper function must be a Stream<R>. Stream will use the result of mapper to “roll up” elements into one Stream from another Stream. It may sound confusing, so exemplifying it will help us understand it better:

```bash
//We have this class:
public class PlatziStudent {
     private boolean emailSubscribed;
     private List<Email> emails;

     public boolean isEmailSubscribed() {
         return emailSubscribed;
     }

     public List<Email> getEmails(){
         return new LinkedList<>(emails); //We create a copy of the list to keep the class immutable for safety
     }
}

//First we obtain user type objects registered in Platzi:
Stream<PlatziStudent> platziStudents = getPlatziUsers().stream();

// Afterwards, we want to send an email to all users but... we are only interested in obtaining their email to notify them:
Stream<Email> allEmailsToNotify =
                         platziStudents.filter(PlatziStudent::isEmailSubscribed) //First we avoid sending emails to those who are not subscribed
                                     .flatMap(student -> student.getEmails().stream()); // The lambda generates a new Stream of each student's email list.

sendMonthlyEmails(allEmailsToNotify);
//The final Stream is only a Stream of emails, without more details or additional information.

```

flatMap is a way we can purge data of additional information that is not needed.

**distinct**

This operation is simple:

```bash
Stream<T> distinct()
```

What it does is compare each element of the Stream against the rest using the equals method. This way, you prevent the Stream from containing duplicate elements. The operation, being intermediate, returns a new Stream where the elements are unique. Remember that to guarantee this it is recommended that you override the equals method in your classes that represent data.

**limit**

The limit operation receives a long that determines how many elements of the original Stream will be preserved. If the number is greater than the initial number of elements in the Stream, basically all elements will remain in the Stream. An interesting detail is that some Stream implementations can be sorted (sorted()) or explicitly unordered (unordered()), which can drastically change the result of the operation and performance.

```bash
Stream<T> limit(long maxSize)
```

The operation ensures that the elements in the resulting Stream will be the first to appear in the Stream. That is why the operation is lightweight when the Stream is sequential or the unordered() operation was used (not available in all Streams, since the operation belongs to another class).

As an additional challenge, create the code to represent.

**peek**

peek works like a magnifying glass, like a moment of observation of what is happening in the Stream. What this operation does is take a Consumer, pass the data as it is present in the Stream and generate a new identical Stream to continue operating.

The structure of peek is simple:

```bash
Stream look<T>(Consumer<? super T> consumer)
```

Using it can help us generate logs or records of the Stream data, for example:

```bash
Stream<Connection> serverConnections =
    server.getConnectionsStream()
        .peek(connection -> logConnection(connection, new Date()))
        .filter(…)
        .map(…)
    //Other operations…
```

**skip**

This operation is contrary to limit(). While limit() reduces the elements present in the Stream to a specific number, skip discards the first n elements and generates a Stream with the remaining elements in the Stream.

This is:

```bash
Stream<Integer> first10Numbers = Stream.of(0,1,2,3,4,5,6,7,8,9);
Stream<Integer> last7Numbers = first10Numbers.skip(3); // 3,4,5,6,7,8,9
```

This can be useful if we know what part of the information can be discarded. For example, discarding the first line of an XML (<? xml…>), discarding metadata from a photo, testing users at the start of a database, introducing a video, etc.

**sorted**

The sorted() operation requires that the elements present in the Stream implement the Comparable interface in order to be able to sort naturally within the Stream. The resulting Stream contains all the elements but already ordered. Sorting has many advantages. I recommend Platzi's algorithms courses to learn more about these advantages.

**Conclusions**

Intermediate operations allow us to have control over the streams and manipulate their contents in a simple way without really worrying about how the changes are made.

Remember that intermediate operations have the functionality of generating new streams that we can output so that other parts of the code can use them.

Although there are other intermediate operations in different Stream implementations, the ones we list here are present in the base interface, so understanding these operations will make your life easier in most uses of Stream.

## 16. COLLECTORS

Collectors are used to convert a Stream to a data structure that contains the elements of the stream (such as List or Map), therefore, it is a terminal operation.

Boxed() is an IntStream method that converts the IntStream into a Stream of integers, i.e. Stream<Integer>


# PROYECT JOB-SEARCH

