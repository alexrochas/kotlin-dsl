package library

import java.math.BigDecimal

class DSL {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            order {
                items {
                    +item {
                        sku = "some crazy sku"
                        discounts {
                            +discount {
                                code = "code1"
                                value = BigDecimal.valueOf(10.0)
                            }
                            +discount {
                                code = "code4"
                                value = BigDecimal.valueOf(10.0)
                            }
                        }
                    }
                    +item {
                        sku = "some more crazy sku"
                        discounts {
                            +discount {
                                code = "code2"
                                value = BigDecimal.valueOf(10.0)
                            }
                            +discount {
                                code = "code3"
                                value = BigDecimal.valueOf(10.0)
                            }
                        }
                    }
                }
            }.also { print(it) }
        }
    }
}
