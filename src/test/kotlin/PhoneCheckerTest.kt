import kotlin.test.Test

class PhoneCheckerTest {

    @Test fun testValidNumberReturnsTrue() {
        val phoneChecker = PhoneChecker()

        assert(phoneChecker.isPhoneValid("01483546545") == true)
        assert(phoneChecker.isPhoneValid("07564600748") == true)
    }

    @Test fun testInvalidNumberReturnsFalse() {
        val phoneChecker = PhoneChecker()

        assert(phoneChecker.isPhoneValid("756432160074832") == false)
    }
}