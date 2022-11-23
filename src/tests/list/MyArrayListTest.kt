package tests.list

import domain.list.MyArrayList
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class MyArrayListTest {

    lateinit var list: MyArrayList<Int>

    @BeforeEach
    fun setup() {
        list = MyArrayList()
    }

    @Test
    fun isEmptyReturnsTrueWhenListIsEmpty() {
        assert(list.isEmpty())
    }

    @Test
    fun isEmptyReturnsFalseWhenListIsNotEmpty() {
        list.add(0)
        assert(!list.isEmpty())
    }

    @Test
    fun additionOfElement() {
        list.add(0)
        assert(list.asList[0] == 0)
    }

    @Test
    fun elementsReturnsEmptyListWhenNoElementsAdded() {
        assert(list.asList == listOf<Int>())
    }

    @Test
    fun addingCollectionOfElements() {
        list.addAll(listOf(1, 2, 3))

        assert(list.asList == listOf(1, 2, 3))
    }

    @Test
    fun addingVarArgOfElements() {
        list.addAll(1, 2, 3)

        assert(list.asList == listOf(1, 2, 3))
    }

    @Test
    fun clearingTheEmptyList() {
        list.clear()

        assert(list.asList == listOf<Int>())
        assert(list.isEmpty())
    }

    @Test
    fun clearingTheNonEmptyList() {
        list.add(0)
        list.clear()

        assert(list.asList == listOf<Int>())
        assert(list.isEmpty())
    }

    @Test
    fun addingThreeElementsThanSortingThem() {
        list.addAll(0, 3, 1)
        list.sort { v1: Int, v2: Int ->
            v1 > v2
        }

        assert(!list.isEmpty())
        assert(list.asList == listOf(0, 1, 3))
    }

    @Test
    fun deletingByIdFromEmptyList() {
        list.delete(position = 0)

        assert(list.asList == listOf<Int>())
        assert(list.isEmpty())
    }

    @Test
    fun deletingByElementFromEmptyList() {
        list.delete(element = 0)

        assert(list.asList == listOf<Int>())
        assert(list.isEmpty())
    }

    @Test
    fun deletingByIdFromStart() {
        list.add(0)
        list.delete(position = 0)

        assert(list.asList == listOf<Int>())
        assert(list.isEmpty())
    }

    @Test
    fun deletingByElementFromStart() {
        list.add(0)
        list.delete(element = 0)

        assert(list.asList == listOf<Int>())
        assert(list.isEmpty())
    }

    @Test
    fun deletingByNotExistingId() {
        list.add(0)
        list.delete(position = 1)

        assert(list.asList == listOf<Int>(0))
        assert(!list.isEmpty())
    }

    @Test
    fun deletingByNotExistingElement() {
        list.add(0)
        list.delete(element = 1)

        assert(list.asList == listOf<Int>(0))
        assert(!list.isEmpty())
    }

    @Test
    fun deletingByIdFromEnd() {
        list.add(0)
        list.add(4)
        list.add(3)
        list.delete(position = 2)

        assert(list.asList == listOf(0, 4))
    }

    @Test
    fun deletingByElementFromEnd() {
        list.add(0)
        list.add(4)
        list.add(3)
        list.delete(element = 3)

        assert(list.asList == listOf(0, 4))
    }

    @Test
    fun deletingByElementFromMiddle() {
        list.add(0)
        list.add(4)
        list.add(3)
        list.delete(element = 4)

        assert(list.asList == listOf(0, 3))
    }

    @Test
    fun deletingByIdFromMiddle() {
        list.add(0)
        list.add(4)
        list.add(3)
        list.delete(position = 1)

        assert(list.asList == listOf(0, 3))
    }

    @Test
    fun insertingElementInMiddle() {
        list.addAll(2, 4, 5)
        list.insert(3, 1)

        assert(list.asList == listOf(2, 3, 4, 5))
    }

    @Test
    fun insertingElementInEmptyList() {
        list.insert(3, 0)

        assert(list.asList == listOf<Int>())
    }

    @Test
    fun insertingElementInNotExistingId() {
        list.addAll(1, 2)
        list.insert(3, 3)

        assert(list.asList == listOf(1, 2))
    }

    @Test
    fun insertingElementEndOfList() {
        list.addAll(1, 2, 3)
        list.insert(4, 2)

        assert(list.asList == listOf(1, 2, 4, 3))
    }

    @Test
    fun mergeCollectionsWithUnspecifiedComparator() {
        list.addAll(1, 2, 3)
        val secondList = MyArrayList(listOf(0, 9, 8))

        list.mergeSorting(secondList)

        assert(list.asList == listOf(1, 2, 3, 0, 9, 8))
    }

    @Test
    fun mergeInSortedListComparator() {
        list.addAll(3, 2, 1)
        list.sort { v1, v2 ->
            v1 > v2
        }
        val secondList = MyArrayList(listOf(0, 9, 8))

        list.mergeSorting(secondList)

        assert(list.asList == listOf(0, 1, 2, 3, 8, 9))
    }

    @Test
    fun mergeInSortedListResettingComparator() {
        list.addAll(3, 2, 1)
        list.sort { v1, v2 ->
            v1 > v2
        }
        val secondList = MyArrayList(listOf(0, 9, 8))

        list.mergeSorting(secondList) { v1, v2 ->
            v1 < v2
        }

        assert(list.asList == listOf(9, 8, 3, 2, 1, 0))
    }

    @Test
    fun mergeInUnsortedListSettingComparator() {
        list.addAll(3, 2, 1)

        val secondList = MyArrayList(listOf(0, 9, 8))

        list.mergeSorting(secondList) { v1, v2 ->
            v1 < v2
        }

        assert(list.asList == listOf(9, 8, 3, 2, 1, 0))
    }
}