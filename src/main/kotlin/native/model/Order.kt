package native.model

class Order {
    var items = mutableListOf<Item>()

    operator fun Item.unaryPlus() {
        items.add(this)
    }

    object order {
        operator fun invoke(block: Order.() -> Unit): Order {
            val order = Order()
            order.run(block)
            return order
        }
    }
}
