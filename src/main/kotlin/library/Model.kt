package library

import com.autodsl.annotation.AutoDsl
import java.math.BigDecimal

@AutoDsl
data class Discount(val code: String, val value: BigDecimal)

@AutoDsl
data class Item(val sku: String, val discounts: List<Discount>)

@AutoDsl
data class Order(val items: List<Item>?)

