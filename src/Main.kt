import example.testZoo
import model.Animal

enum class MenuOptions(val optionId: Int){
    ZooInfo(1),
    AddAnAnimal(2),
    DeleteAnimal(3),
    SortAnimalsByName(4),
    SortAnimalsByWeight(5),
    SortBySpecie(6),
    SortByPreferredFood(7),
    Exit(0)
}

fun main() {

    while (true) {

        MenuOptions.values().forEach {
            println("print ${it.optionId} to $it")
        }

        var input: Int
        try {
            input = readLine()!!.toInt()

            val selectedOption = MenuOptions.values().first { it.optionId == input }

            when(selectedOption){
                MenuOptions.ZooInfo -> {
                    print(testZoo)
                }
                MenuOptions.AddAnAnimal -> {
                    testZoo.addAnimals(readAnimal())
                }
                MenuOptions.DeleteAnimal -> {
                    print("input animal name")
                    testZoo.removeAnimals(readln())
                }
                MenuOptions.SortAnimalsByName -> {
                    print(testZoo.getAnimalsSortedByName())
                }
                MenuOptions.SortByPreferredFood -> {
                    print(testZoo.getAnimalsSortedByPreferredFood())
                }
                MenuOptions.SortBySpecie ->{
                    print(testZoo.getAnimalsSortedBySpecie())
                }
                MenuOptions.SortAnimalsByWeight -> {
                    println("input 1 to sort in ascending order, otherwise any key")
                    val choise = readLine()
                    print(if (choise == "1")
                        testZoo.getAnimalsSortedByWeight(true)
                    else
                        testZoo.getAnimalsSortedByWeight(false)
                    )
                }
                MenuOptions.Exit -> break
            }

            println()
        } catch (e: Exception) {
            print("Invalid input, please enter option number")
            continue
        }
    }
}

private fun readAnimal(): Animal {
    print("input animal specie:")
    val specie = readln()
    print("input animal name")
    val name = readln()
    print("input animal weight")
    val weight = readln().toFloat()
    print("input animal preferredFood")
    val preferredFood = readln()

    return Animal(specie, name, weight, preferredFood)
}