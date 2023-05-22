import java.util.*

class Animal(val name: String, val species: String) {
    override fun toString(): String {
        return "$name ($species)"
    }
}

class Zoo {
    private val animals: ArrayList<Animal> = ArrayList()

    fun addAnimal(animal: Animal) {
        animals.add(animal)
    }

    fun addAnimals(newAnimals: List<Animal>) {
        animals.addAll(newAnimals)
    }

    fun removeAnimal(animal: Animal) {
        animals.remove(animal)
    }

    fun removeAnimals(animalsToRemove: List<Animal>) {
        animals.removeAll(animalsToRemove)
    }

    fun searchAnimalByName(name: String): Animal? {
        for (animal in animals) {
            if (animal.name == name) {
                return animal
            }
        }
        return null
    }

    fun searchAnimalsBySpecies(species: String): List<Animal> {
        val foundAnimals: ArrayList<Animal> = ArrayList()
        for (animal in animals) {
            if (animal.species == species) {
                foundAnimals.add(animal)
            }
        }
        return foundAnimals
    }

    fun sortAnimalsByName() {
        animals.sortWith(compareBy { it.name })
    }

    fun sortAnimalsBySpecies() {
        animals.sortWith(compareBy { it.species })
    }

    fun printAnimals() {
        for (animal in animals) {
            println(animal)
        }
    }
}

fun main() {
    val zoo = Zoo()

    val lion = Animal("Leo", "Lion")
    val elephant = Animal("Ellie", "Elephant")
    val giraffe = Animal("Gerry", "Giraffe")

    zoo.addAnimal(lion)
    zoo.addAnimals(listOf(elephant, giraffe))

    zoo.printAnimals()

    val foundAnimal = zoo.searchAnimalByName("Leo")
    foundAnimal?.let {
        println("Found animal: $it")
    }

    val giraffes = zoo.searchAnimalsBySpecies("Giraffe")
    println("Giraffes:")
    for (giraffe in giraffes) {
        println(giraffe)
    }

    zoo.removeAnimal(lion)
    zoo.sortAnimalsByName()

    println("After removing and sorting:")
    zoo.printAnimals()
}