package ru.gb.himike.ui.home.recycler_classes

import ru.gb.himike.R
import ru.gb.himike.entity.Lesson
import ru.gb.himike.entity.Homework

val lessons = listOf<Lesson>(
    Lesson("History", "8.00-8.45", R.drawable.history),
    Lesson("Mathematics", "9.10-9.55", R.drawable.mathematics),
    Lesson("Literature", "10.30-11.15", R.drawable.literature),
    Lesson("Physics", "11.30-12.15", R.drawable.physics),
    Lesson("Geometry", "14.15-15.00", R.drawable.geometry),
    Lesson("Biology", "15.10-15.55", R.drawable.biology)
)

val homeworks = listOf<Homework>(
    Homework(
        "Mathematics",
        "Calculate the simplest probabilities, as well as permutations and combinations.",
        R.drawable.mathematics,
        2
    ),
    Homework(
        "Literature",
        "Read scenes 1.1-1.2 of Master and Margarita.",
        R.drawable.literature,
        7
    ),
    Homework(
        "Physics",
        "Learn Newton's law of gravity. pages 242-289.",
        R.drawable.physics,
        4
    ),
    Homework(
        "Geometry",
        "Pythagoras' theorem for right angles. The theorem of similar triangles.",
        R.drawable.geometry,
        1
    ),
    Homework(
        "Biology",
        "Learn the structure of the kidneys. Paragraph 3, chapter 4",
        R.drawable.biology,
        5
    ),
    Homework(
        "History",
        "History of ancient Pakistan. Read paragraphs 2.3-2.7.",
        R.drawable.history,
        6
    )
)