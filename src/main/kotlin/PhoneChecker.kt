class PhoneChecker {
    fun isPhoneValid(phone: String): Boolean {
        val regex = """^\s*(?:\+?(\d{1,3}))?[-. (]*(\d{3})[-. )]*(\d{3})[-. ]*(\d{4})(?: *x(\d+))?\s*$""".toRegex()
        return regex.matches(phone)
    }
}