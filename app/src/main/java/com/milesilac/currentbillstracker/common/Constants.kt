package com.milesilac.currentbillstracker.common

const val BILL_JAN = "January"
const val BILL_FEB = "February"
const val BILL_MAR = "March"
const val BILL_APR = "April"
const val BILL_MAY = "May"
const val BILL_JUN = "June"
const val BILL_JUL = "July"
const val BILL_AUG = "August"
const val BILL_SEPT = "September"
const val BILL_OCT = "October"
const val BILL_NOV = "November"
const val BILL_DEC = "December"

const val DEFAULT_BILLING_COMPANY = "Water Bill"
const val DEFAULT_COVERAGE = BILL_JAN

val MONTHS = listOf(
    BILL_JAN, BILL_FEB, BILL_MAR, BILL_APR, BILL_MAY, BILL_JUN,
    BILL_JUL, BILL_AUG, BILL_SEPT, BILL_OCT, BILL_NOV, BILL_DEC
)

val MONTHS_COVERAGE = listOf(
    "$BILL_DEC - $BILL_JAN", "$BILL_JAN - $BILL_FEB", "$BILL_FEB - $BILL_MAR",
    "$BILL_MAR - $BILL_APR", "$BILL_APR - $BILL_MAY", "$BILL_MAY - $BILL_JUN",
    "$BILL_JUN - $BILL_JUL", "$BILL_JUL - $BILL_AUG", "$BILL_AUG - $BILL_SEPT",
    "$BILL_SEPT - $BILL_OCT", "$BILL_OCT - $BILL_NOV", "$BILL_NOV - $BILL_DEC"
)