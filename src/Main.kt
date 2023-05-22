class PhraseologicalDictionary {
    private val dictionary: HashMap<String, MutableList<String>> = HashMap()

    fun addPhrase(phrase: String, meaning: String) {
        val meanings = dictionary.getOrPut(phrase) { mutableListOf() }
        meanings.add(meaning)
    }

    fun removePhrase(phrase: String) {
        dictionary.remove(phrase)
    }

    fun searchPhrase(phrase: String): List<String>? {
        return dictionary[phrase]
    }

    fun replaceMeaning(phrase: String, oldMeaning: String, newMeaning: String): Boolean {
        val meanings = dictionary[phrase]
        if (meanings != null) {
            val index = meanings.indexOf(oldMeaning)
            if (index != -1) {
                meanings[index] = newMeaning
                return true
            }
        }
        return false
    }

    fun sortDictionaryByPhrase() {
        val sortedDictionary = dictionary.toSortedMap(compareBy { it })
        dictionary.clear()
        dictionary.putAll(sortedDictionary)
    }

    fun printDictionary() {
        for ((phrase, meanings) in dictionary) {
            println("$phrase:")
            for (meaning in meanings) {
                println("- $meaning")
            }
        }
    }
}

fun main() {
    val phraseologicalDictionary = PhraseologicalDictionary()

    phraseologicalDictionary.addPhrase("Break a leg", "Good luck")
    phraseologicalDictionary.addPhrase("Break a leg", "Do well")
    phraseologicalDictionary.addPhrase("Piece of cake", "Easy task")
    phraseologicalDictionary.addPhrase("Piece of cake", "Simple")

    phraseologicalDictionary.printDictionary()

    val phrase = "Break a leg"
    val meanings = phraseologicalDictionary.searchPhrase(phrase)
    if (meanings != null) {
        println("Meanings of '$phrase':")
        for (meaning in meanings) {
            println("- $meaning")
        }
    }

    val replaced = phraseologicalDictionary.replaceMeaning(phrase, "Good luck", "Best wishes")
    if (replaced) {
        println("Meaning replaced successfully.")
    } else {
        println("Failed to replace meaning.")
    }

    phraseologicalDictionary.sortDictionaryByPhrase()

    println("Sorted dictionary:")
    phraseologicalDictionary.printDictionary()
}
