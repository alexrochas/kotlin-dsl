package native

import native.model.Order

infix fun Order.containsItemWithSku(sku: String): Boolean {
    return this.items.any { it.sku == sku }
}