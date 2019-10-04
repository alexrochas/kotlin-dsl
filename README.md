# Kotlin DSL
> Minor Kotlin DSL show case

## Why?

Showcase of how it work today to create an small DSL. Besides the "why", here is the result:

```kotlin
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
}
```

## Meta

Alex Rocha - [about.me](http://about.me/alex.rochas) -
