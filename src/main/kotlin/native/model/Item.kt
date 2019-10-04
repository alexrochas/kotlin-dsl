package native.model

class Item {
    lateinit var sku: String
    var discount = mutableListOf<Discount>()

    operator fun Discount.unaryPlus() {
        discount.add(this)
    }

    object item {
        operator fun invoke(block: Item.() -> Unit): Item {
            val item = Item()
            item.run(block)
            return item
        }
    }
}