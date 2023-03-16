package model

data class Animal(val specie: String,val name: String, val weight: Float, val preferredFood: String){

    override fun toString(): String {
        return "\nAnimal info:\nspecie: $specie\nname: $name\nweight: $weight\npreferredFood: $preferredFood\n"
    }
}