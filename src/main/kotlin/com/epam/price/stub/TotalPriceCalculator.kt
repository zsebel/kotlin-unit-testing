package com.epam.price.stub

import com.epam.price.domain.Product
import org.springframework.stereotype.Component

@Component
class TotalPriceCalculator {

    fun calculate(product: Product) = product.basePrice + product.taxes + product.fees

}
