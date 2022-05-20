package com.epam.price

import com.epam.price.domain.Product
import com.epam.price.stub.PriceFormatter
import com.epam.price.stub.TotalPriceCalculator
import org.springframework.stereotype.Component

@Component
class PriceDisplayService(
    val totalPriceCalculator: TotalPriceCalculator,
    val priceFormatter: PriceFormatter
) {

    fun getDisplayPrice(product: Product): String {
        val totalPrice = totalPriceCalculator.calculate(product)
        return priceFormatter.format(totalPrice)
    }
}