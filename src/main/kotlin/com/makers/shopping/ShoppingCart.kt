package com.makers.shopping

class ShoppingCart (
    val contents: ArrayList<Item> = arrayListOf()
){
    // Add Item object to cart
    fun addItem(item: Item): ArrayList<Item> {
        contents.add(item)
        return contents
    }

    // Loop through Item objects in cart and sum their prices
    fun getTotalPrice(): Double {
        var total: Double = 0.0
        contents.forEach{
            total += it.price
        }
        return total
    }
}