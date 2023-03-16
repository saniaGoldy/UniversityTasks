package model

class Zoo(animals: List<Animal>, val zooName: String) {

    private val _animals: MutableList<Animal> = mutableListOf()
    val animals:List<Animal> get() = _animals

    init {
        this._animals.addAll(animals)
    }

    fun addAnimals(vararg animal: Animal) = animal.forEach { _animals.add(it) }

    fun removeAnimals(vararg animalName: String) = animalName.forEach {name-> _animals.removeIf { it.name == name } }

    fun getAnimalsByName(name: String) = _animals.filter { it.name == name }

    fun getAnimalsBySpecie(specie: String) = _animals.filter { it.specie == specie }

    fun getAnimalsByPreferredFood(preferredFood: String) = _animals.filter { it.preferredFood == preferredFood }

    fun getAnimalsByWeight(weight: Float, getGreater: Boolean) = _animals.filter {
        if (getGreater)
            it.weight >= weight
        else
            it.weight <= weight
    }

    fun getAnimalsSortedByName() = _animals.sortedBy { it.name }

    fun getAnimalsSortedBySpecie() = _animals.sortedBy { it.specie }

    fun getAnimalsSortedByPreferredFood() = _animals.sortedBy { it.preferredFood }

    fun getAnimalsSortedByWeight(isAscending: Boolean): List<Animal> = _animals.sortedBy { it.weight }.let {
        return@let if (isAscending)
            it
        else
            it.reversed()
    }

    override fun toString(): String {
        val builder = StringBuilder("$zooName info:\n")
        _animals.forEach { builder.append(it) }
        return builder.toString()
    }
}