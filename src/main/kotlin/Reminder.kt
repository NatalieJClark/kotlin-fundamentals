class Reminder(
    val personToRemind: String,
    var reminder: String = ""
) {

    fun remindMeTo(task: String): String {
        reminder = task
        return reminder
    }

    fun remind(): String {
        return "$reminder, $personToRemind!"
    }
}