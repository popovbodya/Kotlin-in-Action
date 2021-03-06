package ru.popov.bodya.keywords.operator

import java.time.LocalDate

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
        object : Iterator<LocalDate> {
            var current = start

            override fun hasNext() = current <= endInclusive

            override fun next() = current.apply { current = plusDays(1) }

        }

fun main(args: Array<String>) {
    val newYear: LocalDate = LocalDate.ofYearDay(2019, 1)
    val daysOff: ClosedRange<LocalDate> = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) {
        println(dayOff)
    }
}