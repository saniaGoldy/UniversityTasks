package tests.list

import domain.list.MyArrayList
import domain.list.MyLinkedList
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class MyLinkedListTest {

    lateinit var list: MyLinkedList<Int>

    @BeforeEach
    fun setup() {
        list = MyLinkedList()
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
    fun additionOfOneElementSetsUpTheHeadAndTail() {
        list.add(0)
        assert(list.head == list.tail && list.head != null && list.tail != null)
    }

    @Test
    fun additionOfTwoElementsMovesTheTail() {
        list.add(0)
        list.add(1)
        assert(list.head != list.tail && list.head != null && list.tail != null)
    }

    @Test
    fun additionOfElement() {
        list.add(0)
        assert(list.tail != null)
        assert(list.tail!!.value == 0)
    }

    @Test
    fun afterAddingTwoElementsHeadPointsOnNextNode() {
        list.add(0)
        list.add(1)
        assert(list.head!!.hasNext())
        assert(list.head!!.nextNode!!.value == 1)
    }

    @Test
    fun elementsReturnsEmptyListWhenNoElementsAdded() {
        assert(list.toList == listOf<Int>())
    }

    @Test
    fun addingCollectionOfElements() {
        list.addAll(listOf(1, 2, 3))

        assert(list.toList == listOf(1, 2, 3))
    }

    @Test
    fun addingVarArgOfElements() {
        list.addAll(1, 2, 3)

        assert(list.toList == listOf(1, 2, 3))
    }

    @Test
    fun clearingTheEmptyList() {
        list.clear()

        assert(list.toList == listOf<Int>())
        assert(list.isEmpty())
        assert(list.head == null && list.tail == null)
    }

    @Test
    fun clearingTheNonEmptyList() {
        list.add(0)
        list.clear()

        assert(list.toList == listOf<Int>())
        assert(list.isEmpty())
        assert(list.head == null && list.tail == null)
    }

    @Test
    fun addOnStartOneElementToEmptyList() {
        list.addOnStart(0)

        assert(!list.isEmpty())
        assert(list.toList == listOf(0))
        assert(list.head != null && list.tail != null && list.head == list.tail)
        assert(!list.head!!.hasNext())
    }

    @Test
    fun addOnStartTwoElementsToEmptyList() {
        list.addOnStart(0)
        list.addOnStart(1)

        assert(!list.isEmpty())
        assert(list.toList == listOf(1, 0))
        assert(list.head != null && list.tail != null && list.head != list.tail)
        assert(list.head!!.hasNext())
    }

    @Test
    fun addingThreeElementsThanSortingThem() {
        list.addAll(1, 0, 3)

        list.sort { v1: Int, v2: Int ->
            v1 > v2
        }

        assert(!list.isEmpty())
        assert(list.toList == listOf(0, 1, 3))
        assert(list.head != null && list.tail != null && list.head != list.tail)
        assert(list.head!!.hasNext())
    }

    @Test
    fun mergeCollectionsWithUnspecifiedComparator() {
        list.addAll(1, 2, 3)
        val secondList = MyArrayList(listOf(0, 9, 8))

        list.mergeSorting(secondList)

        assert(list.toList == listOf(1, 2, 3, 0, 9, 8))
    }

    @Test
    fun mergeInSortedListComparator() {
        list.addAll(3, 2, 1)
        list.sort { v1, v2 ->
            v1 > v2
        }
        val secondList = MyArrayList(listOf(0, 9, 8))

        list.mergeSorting(secondList)

        assert(list.toList == listOf(0, 1, 2, 3, 8, 9))
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

        assert(list.toList == listOf(9, 8, 3, 2, 1, 0))
    }

    @Test
    fun mergeInUnsortedListSettingComparator() {
        list.addAll(3, 2, 1)

        val secondList = MyArrayList(listOf(0, 9, 8))

        list.mergeSorting(secondList) { v1, v2 ->
            v1 < v2
        }

        assert(list.toList == listOf(9, 8, 3, 2, 1, 0))
    }

}