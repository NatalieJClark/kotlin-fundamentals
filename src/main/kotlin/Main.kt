import com.makers.person.Address
import com.makers.person.Person
import com.makers.shopping.Item
import com.makers.shopping.ShoppingCart
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.server.Undertow
import org.http4k.server.asServer

fun main(args: Array<String>) {
//  ________________________________ 1. VARIABLES ___________________________________

//  ............................ 1.1 VARIABLES PRACTISE .............................

    println("1.1 VARIABLES PRACTISE:")
    println("Hello World!")

    val myName: String = "Natalie"

    //  You can't reassign val e.g.
    //  name = "Andy"
    println(myName)
    println(myName.length)
    println(myName.uppercase())
    println(myName.reversed())

    //  You can reassign a var, but immutable variables reduce bugs!
    var newName = "Stephen"
    newName = "Matthew"
    println(newName)

    //  Kotlin in statically typed, however ...
    //  You don't have to explicitly declare type, as the Kotlin compiler is smart enough to infer it
    val count = 10
    println("There are $count apples in my kitchen")

    val isValid: Boolean = true

    //  Generic types
    val myNumbers: List<Double> = listOf(3.4, 5.2, 8.5)
    println(myNumbers)

    //  Generic nullable types
    val names: List<String?> = listOf("Natalie", "Matthew", null)
    println(names)

    //  Define a String message and assign the reversed version of it to a new value.
    val newMessage: String = "Hello world!"
    println(newMessage)

    val reversedMessage: String = newMessage.reversed()
    println(reversedMessage)


//  ............................ 1.2 VARIABLES EXERCISES .............................

    println("1.2 VARIABLES EXERCISES:")

    //    Q. The following code doesn't work - why? Modify it so it runs
    //    A. changed val to var
    var aNumber = 2
    aNumber = 4
    println(aNumber)

    //    Q. The following code doesn't work - why? Modify it so it runs.
    //    A. I made the generic type nullable
    val numbers: List<Number?> = listOf(3, 4, null)
    println(numbers)

    //    Q. The following code doesn't work - why? Modify it so it runs.
    //    A. I used the .length member function on the list item not the whole list
    //       I also included a null check
    val otherNames: List<String?> = listOf("Kat", "Marc", null)
    for (name in otherNames) {
    //        Print the length
    //        if (name != null) {
    //            println(name.length)
    //        }
    //        Or print the length and null
        println(name?.length)
    }

    //    Q. The following code doesn't work - why? How would you fix it?
    //    A. use ? to make cast safe even if not Number
    val number = "3" as? Number
    println(number)

    //    Q. This might require a bit of research from you.
    //       Fix the following code, so we can create a list of both strings and numbers
    //    A. Use Any keyword as type
    val listOfThings: List<Any> = listOf(3, "Hello", 4)
    println(listOfThings)

//  ________________________________ 2. FUNCTIONS ___________________________________

//  ............................ 2.1 FUNCTIONS PRACTISE .............................

    println("2.1 FUNCTIONS PRACTISE:")
    //  getHelloMessage takes one String argument,
    //  and returns a String
    fun getHelloMessage(name: String): String {
        return "Hello $name"
    }

    //  Calling a function and getting its
    //  return value into a new value.
    val helloMessage = getHelloMessage("Leo")
    println(helloMessage)

    //  We can use a shorter syntax
    //  without the body between brackets
    fun addition(a: Int, b: Int): Int = a + b
    println(addition(4, 6))

    // When using the shorter syntax, the return type
    // can be "guessed" by the compiler (here, String)
    fun simpleGetHelloMessage(name: String) = "Hello $name"

    val message = simpleGetHelloMessage("James")
    println(message)

    //  If a function doesn't need to return anything, its return type is Unit.
    fun printList(list: List<Any>): Unit {
        list.forEach {
            print(it)
        }
        // No return statement
        // (this function only has side effects)
    }

//  ............................ 2.2 FUNCTIONS QUESTIONS .............................

    println("2.2 FUNCTIONS QUESTIONS:")
    //  Q. Write a method called superify
    //     which takes a string and adds the word "super" to the start.
    //     So given 'woman' it returns 'superwoman', given 'dog' it returns 'superdog'.

    fun superify(name: String) = "super$name"

    println(
        superify(
            superify(
                superify(
                    superify("cat")
                )
            )
        )
    )

    //  Q. Define a function revealSecret which takes a passcode in argument,
    //  and returns a secret string "The cookies are in the desk drawer"
    //  only if the given passcode is the string "HUNGRY".
    //  If the given passcode is something else, the function should return null.

    fun revealSecret(passcode: String): String? {
        if (passcode == "HUNGRY") {
            return "The cookies are in the desk drawer"
        } else {
            return null
        }
    }

    val secret = revealSecret("HUNGRY")
    println(secret) // "The cookies are in the desk drawer"

    val anotherSecret = revealSecret("Hi")
    println(anotherSecret) // null

//  ________________________________ 3. CONTROL FLOW ___________________________________

//  ............................ 3.1 CONTROL FLOW PRACTISE .............................

    println("3.1 CONTROL FLOW PRACTISE:")
    val a = 6
    val b = 3

    var max = a

    // Simple `if`
    if (a < b) {
        max = b
    }

    // `if` with `else`
    if (a > b) {
        max = a
    } else {
        max = b
    }

    // As an expression
    // (`max` will be assigned to either a or b)
    max = if (a > b) a else b

    // `when` expressions allows us to handle more complex conditional branching.
    // We use the type `Any`, so the argument could be any type.
    fun whatIsThis(something: Any): String {

        // We can use a `when` statement
        // to return a different value depending
        // on the type and value.
        val result =
            when(something) {
                1 -> "One"
                "Hello" -> "Greeting"
                is Number -> "A number"
                is String -> "A string"
                else -> "Something else"
            }

        return result
    }

    println(whatIsThis(2))          // "A number"
    println(whatIsThis(1))          // "One"
    println(whatIsThis("Hello"))    // "Greeting"
    println(whatIsThis(listOf(1)))            // "Something else"

//    ............................ 3.2 CONTROL FLOW EXERCISES .............................

    // Q. Define a function `getNumberSign` that takes a number and returns a String
    //    which is either "zero", "positive" or "negative" depending on its sign.
    //    If the argument is not a number, the function should return null.

    println("3.2 CONTROL FLOW EXERCISES:")
    fun getNumberSign(number: Any): String? {
        if (number is Int) {
            if (number < 0) {
                return "negative"
            } else if (number > 0) {
                return "positive"
            } else {
                return "zero"
            }
        } else {
            return null
        }
    }

    println(getNumberSign(3)) // "positive"

    println(getNumberSign(0)) // "zero"

    println(getNumberSign(-5)) // "negative"

    println(getNumberSign("not a number")) // null

    // Q: Rewrite the revealSecret function with a when statement

    fun newRevealSecret(password: String): String? {
        return when (password) {
            "HUNGRY" -> "The cookies are in the desk drawer"
            else -> null
        }
    }

    println(newRevealSecret("HUNGRY"))

//  ________________________________ 4. COLLECTIONS AND LOOPS ___________________________________

//  ............................ 4.1 COLLECTIONS AND LOOPS PRACTISE .............................

    println("4.1 COLLECTIONS AND LOOPS PRACTISE:")
    // Declaring an immutable list
    // (we cannot modify it, e.g adding new elements)
    val listNames = listOf("Andy", "Barbara", "Cat")

    println(listNames)

    // Declaring a mutable list
    // (elements can be added or removed)
    val arrayListNames = arrayListOf("Andy", "Barbara", "Cat")
    arrayListNames.add("Danny")
    arrayListNames.add("Erica")

    println(arrayListNames)

    // Sometimes we need to specify the type
    // of the list elements. Here using the arrayListOf<TYPE> syntax.
    val uppercaseNames = arrayListOf<String>()

    // Looping through `arrayListNames`:
    arrayListNames.forEach {
        // Below, `it` is a special variable
        // referring to the current name
        // in the loop.
        uppercaseNames.add(it.uppercase())
    }

    println(uppercaseNames)

    // Declaring a map
    val info = mapOf(
        "name" to "John Doe",
        "email" to "contact@mywebsite.com",
        "postcode" to "EC1 AAA",
        "phones" to listOf("0700000000", "071000000")
    )

    println(info)

    // Accessing values
    val name = info["name"]
    println(name)
    val email = info["email"]
    println(email)
    val phones = info["phones"]
    println(phones)

    // Iterating over a map
    info.forEach { key, value ->
        println("$key = $value")
    }

    // map function
    val words = listOf("music", "cheese", "house")

    // .map takes a "lambda" function
    // which is called for each element of the list.
    val uppercaseWords = words.map {
        it.uppercase()
    }

    println(uppercaseWords)

//  ............................ 4.2 COLLECTIONS AND LOOPS EXERCISES .............................

    println("4.2 COLLECTIONS AND LOOPS EXERCISES:")
    // Q. Define a function printHelloMessages which,
    //    for each name in the list given in argument, prints a hello message.

    fun printHelloMessages(names: List<String>) {
        names.forEach() {
            println("Hello $it")
        }
    }

    printHelloMessages(listOf("Jake", "Olga", "Pat"))

    // Q. Use the function getNumberSign written in the previous section.
    //    Write a new function getAllNumberSigns which takes an array of numbers (Int),
    //    and returns an array of the corresponding number signs.

    fun getAllNumberSigns(numbers: List<Int>): List<String?> {
        return numbers.map {
            getNumberSign(it)
        }
    }

    val allNumbers = listOf(2, -3, 5, 0)

    val signs = getAllNumberSigns(allNumbers)

    println(signs) // ["positive", "negative", "positive", "zero"]

//  ________________________________ 5. HIGHER-ORDER AND LAMBDA FUNCTIONS ___________________________________

//  ............................ 5.1 HIGHER-ORDER AND LAMBDA FUNCTIONS PRACTISE .............................

    println("5.1 HIGHER-ORDER AND LAMBDA FUNCTIONS PRACTISE:")
    // A function can take other functions as arguments.
    fun calculate(a: Int, b: Int, calculateFunction: (Int, Int) -> Int): Int {
        return calculateFunction(a, b)
    }

    // (Int, Int) -> Int
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    // (Int, Int) -> Int
    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    // (Int, Int) -> Int
    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    // We're not calling the function
    // but referencing it, so we need to use
    // `::` in front of their name.
    println(calculate(2, 3, ::add)) // 2 + 3 = 5
    println(calculate(2, 4, ::multiply)) // 2 * 4 = 8
    println(calculate(7, 3, ::subtract)) // 7 - 3 = 4

    // In this case the higher order function deals with strings
    fun decorateString(
        inputString: String,
        decorateFunction: (String) -> String
    ): String {
        return decorateFunction(inputString)
    }

    fun addGreeting(inputString: String): String {
        return "Hello $inputString"
    }

    fun addGoodbye(inputString: String): String {
        return "Goodbye $inputString"
    }

    println(decorateString("James", ::addGreeting))
    println(decorateString("James", ::addGoodbye))

    // Passing a trailing lambda function for calculate()
    println(calculate(10, 2) { c, d ->
        c / d
    })

//  ............................ 5.2 HIGHER-ORDER AND LAMBDA FUNCTIONS EXERCISES .............................

    println("5.2 HIGHER-ORDER AND LAMBDA FUNCTIONS EXERCISES:")
    // Q. a) Implement a function convertToCaps which takes a string and returns the string converted to capital letters.

    fun convertToCaps(message: String): String {
        return message.uppercase()
    }

    //    b) Implement a function exclaim which takes a string and returns the given string with an exclamation mark at the end.

    fun exclaim(message: String): String {
        return "$message!"
    }

    //    c) Implement a function greetWith which we can call this way:
    //       greetWith("Marco", convertToCaps) // "MARCO"
    //       greetWith("Marco", exclaim) // "Marco!"

    fun greetWith(greetName: String, greetingFunction: (String) -> String): String {
        return greetingFunction(greetName)
    }

    println(greetWith("Marco", ::convertToCaps))
    println(greetWith("Marco", ::exclaim))

    // Q. Call the previous function greetWith using a lambda instead of a named function.

    val result = greetWith("Jamie") {"$it!!".uppercase()}

    println(result)

//  ________________________________ 6. CLASSES ___________________________________

//  ............................ 6.1 CLASSES PRACTISE .............................

    println("6.1 CLASSES PRACTISE:")
    // 1. Defining an "empty" class
    class AnotherPerson

    // Kotlin automatically creates a default constructor
    // with no arguments, so we can instantiate the class
    val someone = AnotherPerson()


    // 2. Defining a class and its properties.
    // The constructor now takes two (required) arguments
    class DifferentPerson(val firstName: String, val lastName: String)

    val someoneElse = DifferentPerson("John", "Doe")


    // 3. Defining a class, its constructor, properties and member functions

    // See Person class in Person.kt file
    // and Address data class in Address.kt file

    // Creating objects from these classes
    val address = Address("10", "London Road", "PO25 9UH")
    val person: Person = Person("John", "Doe", 40, address)

    // Accessing properties
    println(person.fullName)
    println(person.hobbies)
    println(person.address.houseNumber)
    println(person.address.streetName)
    println(person.address.postcode)

    // Calling member functions
    println(person.getIntroduction())
    println(person.getAddress())

//  ............................ 6.2 CLASSES EXERCISES .............................

    println("6.2 CLASSES EXERCISES:")
    // Q. Write two classes Item and ShoppingCart (in their separate files)
    // so the following code works:

    val item = Item("Mars", 4.99)

    println(item.name) // 'Mars'
    println(item.price) // 4.99

    val cart = ShoppingCart()
    println(cart.getTotalPrice()) // 0.0

    cart.addItem(item)

    println(cart.getTotalPrice()) // 4.99

    cart.addItem(Item("Skittle", 3.99))
    cart.addItem(Item("Skittle", 3.99))
    println(cart.getTotalPrice()) // 12.97

//   ________________________________ 7. TESTING ___________________________________

//  ............................ 7.1 TESTING PRACTISE .............................

    // See GreeterTest.kt and Greeter.kt

//  ............................ 7.2 TESTING EXERCISE .............................

    // Q. Write some tests for the class PhoneChecker
    // A. See PhoneCheckerTest

    // Q. Test drive a class with the following behaviour:
    //    val reminder = Reminder("Leo")
    //
    //    reminder.remindMeTo("Walk the dog")
    //
    //    reminder.remind() // "Walk the dog, Leo!"
    //
    //    val reminder2 = Reminder("Ju")
    //
    //    reminder2.remindMeTo("Buy popcorn")
    //
    //    reminder2.remind() // "Buy popcorn, Ju!"
    // A. See Reminder.kt and ReminderTest.kt

//   ________________________________ 8. GRADLE ___________________________________

//  ............................ 8.1 GRADLE PRACTISE .............................

    println("8.1 GRADLE PRACTISE:")
    // Adding these lines to the build script dependencies will install the http4k library
    //    implementation platform("org.http4k:http4k-bom:4.42.1.0")
    //    implementation "org.http4k:http4k-core"
    //    implementation "org.http4k:http4k-server-undertow"

    // You can then launch a web server at http://localhost:9000 with this program
    val app = { request: Request ->
        Response(Status.OK)
            .body("Hello, ${request.query("name")}!")
    }

    app.asServer(Undertow(9000)).start()

}