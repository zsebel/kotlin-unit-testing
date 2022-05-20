package com.epam.price.domain

import java.math.BigDecimal

data class Product(
    val basePrice: BigDecimal,
    val taxes: BigDecimal,
    val fees: BigDecimal
)