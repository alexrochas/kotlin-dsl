package native

import java.math.BigDecimal
import native.model.Order.order
import native.model.Item.item
import native.model.Discount.discount

class NativeDSL {

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            order {
                +item {
                    sku = "some sku"
                    +discount {
                        code = "code1"
                        value = BigDecimal.valueOf(10.0)
                    }
                }
                +item {
                    sku = "something"
                    +discount {
                        code = "code2"
                        value = BigDecimal.valueOf(10.0)
                    }
                }
                +item {
                    sku = "something"
                    +discount {
                        code = "code4"
                        value = BigDecimal.valueOf(10.0)
                    }
                    +discount {
                        code = "code3"
                        value = BigDecimal.valueOf(10.0)
                    }
                }
            }.also {
                print(it.toString())
                print(it containsItemWithSku "some sku")
            }
        }
    }
}
