package com.milesilac.currentbillstracker.domain.model

import com.milesilac.currentbillstracker.common.DEFAULT_BILLING_COMPANY
import com.milesilac.currentbillstracker.common.DEFAULT_COVERAGE

data class Bill(
    val billingCompanyOrSector: String = DEFAULT_BILLING_COMPANY,
    val billAmount: Float = 0.00F,
    val billCoverage: String = DEFAULT_COVERAGE
)
