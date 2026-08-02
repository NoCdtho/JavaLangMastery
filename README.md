# JavaLangMastery
Not all topics are covered but trying to cover all the topics.


FirstGui is file used to create simple UI 

## Topics 1 (beginners:)
1. inheritence
2. abstaction 
3. super
4. toString()

## Topics 2 
1. Encapsulation (use of getter and setter functions):
    --> The attributes of the class are made private and can only be accessed via getter or setter func's
2. Copy objects in java:
    --> One we can do that by creating a copy method or new constructor of the same class that use the copy method.
3. Polymorphism:
    --> ability of an object to identify as more then one type
4. Dynamic polymorphism:
    --> same thing as above but polymorphism is done in runtime 

## Topics 3
1. file class

2. type checking:
    This is nothing just conversion of datatype for a value.

3. static keyword:
    assigning a variable, method, class makes them accessible by all the object of that class.

4. enums:
    are classes that are used to store multiple constants.

5. interface:
    they are like classes but they don't have any implementation of the methods, they only contain signatures and fields.
    
6. java records:
    this is special class that defines immutable data-only. The java records consists one or more fields which acts as member/instance 
    variables in a regular java class. And we don't have to write the boilerplate code to access them.

7. instance initializer block and static block:
    this is block is excuted at the time of object creation and will be executed evrytime a new object is created.
    and the static block will execute at the time class loading.

8. exception handling:
    3 types of error might occur one at compile time, runtime and other like (out of memory). There are many ways to handle using NullPointer Exception, IOException and many more

## Topics 4
1. lamda expression: 
This is used as functionl programming. It is used to implement in the place of unimplemented of a object 
(for interfaces). This can written in place of both constructor and refence variable.

2. annotation:
This are used to give the give meta data of the source code
mainly there are 4: @Deprecated, @override, @suppressWarnings, @Contended 
I can create my own annotations also I will code only that.

3. module:
This is way of creating packages in java.

4. optional:
This are container objects that may or may not contain non-null values.
This are used to represent the absence of value.
This provide methods to check if a value is present or not and to handle cases where value is not present in more 
controlled manner.

5. Dependency Injection:
When one class depends another then its known as depent and the values that are needed to create the dependent
class is known as injection. 

## Topics 5 
1. Java IO:
 Java IO is an api that is used to read and write data on streams, files, Pipes
 Network connections, in-memory buffers(array), System.in, System.out and System.error.

 2. Files and API:
 I specifically studied How to make http get and post request and read and write the data on the server.
 convered the how to read and write files and make API calls with a server used get and post function.

 3. Concurrency:
 This is the process where multiple task can be executed at same without waiting for one process to complete.

 4. High order function:
 When a func is passed as a argument or a function returns a function then it's considered 
 a higer order functions.

 5. Functional composition:
 Where multiple functions are used to and one functions uses those combined functions.

 6. Stream API:
 Stream API is allows us to apply functional style operations on elements.
 important part is execution: stream referencing, intermediate actions and terminate function 