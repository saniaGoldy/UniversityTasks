package example

import model.Animal
import model.Zoo

val testZoo = Zoo(
    listOf(
        Animal("Pig", "Oggie", 42f, "apple"),
        Animal("Giraffe", "John", 83.5f, "acacia leaves"),
        Animal("Pig", "Qucarachee", 32.3f, "beetroot"),
        Animal("Hippo", "Lumpien The First", 130.7f, "watermelon")
    ),
    "Bad Jokes Zoo"
)