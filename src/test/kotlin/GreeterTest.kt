import kotlin.test.Test

class GreeterTest {

    // Test examples are defined as
    // Kotlin functions, prefixed by the
    // @Test annotation.
    @Test fun testGreetsWithName() {
        val greeter = Greeter()

        assert(greeter.greet("Leo") == "Hi Leo!")
        assert(greeter.greet("Mary") == "Hi Mary!")
    }
}