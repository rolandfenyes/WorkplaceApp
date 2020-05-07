package aut.bme.hu.workplaceapp.data

object DataManager {

    private const val HOLIDAY_MAX_VALUE = 20
    private const val HOLIDAY_DEFAULT_VALUE = 15

    val holidays = HOLIDAY_DEFAULT_VALUE

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
}