package com.epam.price

import com.epam.price.domain.Product
import com.epam.price.stub.PriceFormatter
import com.epam.price.stub.TotalPriceCalculator
import io.mockk.every
import io.mockk.mockk
import io.mockk.verifySequence
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class PriceDisplayServiceTest {

    private lateinit var totalPriceCalculator: TotalPriceCalculator
    private lateinit var priceFormatter: PriceFormatter
    private lateinit var underTest: PriceDisplayService

    @BeforeEach
    fun setup() {
        totalPriceCalculator = mockk()
        priceFormatter = mockk()
        underTest = PriceDisplayService(totalPriceCalculator, priceFormatter)
    }

    @Test
    fun `test getDisplayPrice should return formatted total price`() {
        // GIVEN
        val product = Product(BASE_PRICE, TAXES, FEES)
        every { totalPriceCalculator.calculate(product) } returns TOTAL_PRICE
        every { priceFormatter.format(TOTAL_PRICE) } returns FORMATTED_TOTAL_PRICE

        // WHEN
        val actual = underTest.getDisplayPrice(product)

        // THEN
        verifySequence {
            totalPriceCalculator.calculate(product)
            priceFormatter.format(TOTAL_PRICE)
        }
        Assertions.assertEquals(FORMATTED_TOTAL_PRICE, actual)
    }

    companion object {
        private val BASE_PRICE = BigDecimal.valueOf(10)
        private val TAXES = BigDecimal.valueOf(10)
        private val FEES = BigDecimal.valueOf(10)
        private val TOTAL_PRICE = BigDecimal.valueOf(18)
        private const val FORMATTED_TOTAL_PRICE = "$18"
    }
}