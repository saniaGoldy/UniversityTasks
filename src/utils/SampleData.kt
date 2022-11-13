package utils

import domain.model.MyDate
import domain.model.Student
import domain.model.Subject
import java.util.*

val sampleStudents = listOf(
    Student(
        1,
        "Vasya",
        MyDate(Date(2000, 2, 2)),
        mutableMapOf(
            Subject.IT to 4,
            Subject.Math to 3,
            Subject.Physics to 5
        )
    ),
    Student(
        2,
        "Sania",
        MyDate(
            Date(2003, 9, 10)
        ),
        mutableMapOf(
            Subject.IT to 1,
            Subject.Math to 1,
            Subject.Physics to 1
        )
    ),
    Student(
        3,
        "Kolya",
        MyDate(
            Date(2001, 7, 23)
        ),
        mutableMapOf(
            Subject.IT to 2,
            Subject.Math to 2,
            Subject.Physics to 2
        )
    )
)