package com.epam.price.stub

import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class PriceFormatter {

    fun format(totalPrice: BigDecimal) = "$$totalPrice"

}
