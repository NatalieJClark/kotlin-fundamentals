import kotlin.test.Test

class ReminderTest {
    @Test fun testAddedReminderReturnedAsString() {
        val reminder = Reminder("Leo")

        reminder.remindMeTo("Walk the dog")

        assert(reminder.remind() == "Walk the dog, Leo!")

        val reminder2 = Reminder("Ju")

        reminder2.remindMeTo("Buy popcorn")

        assert(reminder2.remind() == "Buy popcorn, Ju!")
    }
}