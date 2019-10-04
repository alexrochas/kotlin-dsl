package native.model

import java.math.BigDecimal

class Discount {
    lateinit var code: String
    lateinit var value: BigDecimal

    object discount {
        operator fun invoke(block: Discount.() -> Unit): Discount {
            val discount = Discount()
            discount.run(block)
            return discount
        }
    }
}