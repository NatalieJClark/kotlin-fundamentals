package com.makers.person

class Person(
    val firstName: String,
    val lastName: String,
    val age: Int,
    // This property will have a default value
    // so we don't need to pass the constructor argument.
    val address: Address,
    val hobbies: List<String> = listOf()
) {

    // The property fullName
    // is set from the two other properties
    // firstName and lastName.
    // It's a "val", so it cannot be changed later.
    val fullName = "$firstName $lastName"

    fun getIntroduction(): String {
        return "Hi there, I'm $fullName - nice to meet you"
    }

    fun getAddress(): String {
        return "${address.houseNumber}, ${address.streetName}, ${address.postcode}"
    }
}