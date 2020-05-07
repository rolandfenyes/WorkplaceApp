package aut.bme.hu.workplaceapp.data

object DataManager {

    private const val HOLIDAY_MAX_VALUE = 20
    private const val HOLIDAY_DEFAULT_VALUE = 15

    var holidays = HOLIDAY_DEFAULT_VALUE

    private const val CURRENT_PAYMENT = 500000
    private const val CURRENT_NET_PAYMENT = CURRENT_PAYMENT * 0.665
    private const val SZJA = 0.15
    private const val NYA = 0.1
    private const val EBTH = 0.04
    private const val EBHK = 0.03
    private const val MNAH = 0.015

    val person: Person = Person(
        "Test User",
        "testuser@domain.com",
        "1234 Test, Random Street 1.",
        " 123456AB",
        "123456789",
        "1234567890",
        "012345678"
    )

    fun getRemainingHolidays(): Int = HOLIDAY_MAX_VALUE - holidays
    fun getCurrentPayment() : Float = CURRENT_PAYMENT.toFloat()
    fun getCurrentNetPayment() : Float = CURRENT_NET_PAYMENT.toFloat()
    fun getSZJA() : Float = (CURRENT_PAYMENT * SZJA).toFloat()
    fun getNYA() : Float = (CURRENT_PAYMENT * NYA).toFloat()
    fun getEBTH() : Float = (CURRENT_PAYMENT * EBTH).toFloat()
    fun getEBHK() : Float = (CURRENT_PAYMENT * EBHK).toFloat()
    fun getMNAJ() : Float = (CURRENT_PAYMENT * MNAH).toFloat()
}