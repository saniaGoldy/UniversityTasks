package tests.list

import domain.list.MyDoublyLinkedList
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MyDoublyLinkedListTest {

    lateinit var list: MyDoublyLinkedList<Int>

    @BeforeEach
    fun setup() {
        list = MyDoublyLinkedList()
    }

    @Test
    fun clearTheEmptyList() {
        list.clear()

        assert(list.asList == listOf<Int>())
    }

    @Test
    fun clearNonEmptyList() {
        list.addAll(1, 2, 3)
        list.clear()

        assert(list.asList == listOf<Int>())
    }

    @Test
    fun clearThenAdd() {
        list.addAll(1, 2, 3)
        list.clear()
        list.add(1)

        assert(list.contains(1))
    }

    @Test
    fun addElement() {
        list.add(1)

        assert(list.asList == listOf(1))
    }

    @Test
    fun removeElementFromEmptyList() {
        assert(!list.remove(element = 1))
    }

    @Test
    fun removeElementByIdFromEmptyList() {
        assertThrows<IndexOutOfBoundsException> { list.remove(index = 1) }
    }

    @Test
    fun removeNotExistingElement() {
        list.add(2)

        assert(!list.remove(element = 1))
        assert(list.asList == listOf(2))
    }

    @Test
    fun removeNotExistingElementById() {
        list.add(2)

        assertThrows<IndexOutOfBoundsException> { list.remove(index = 1) }
    }

    @Test
    fun removeExistingElement() {
        list.add(2)

        assert(list.remove(element = 2))
    }

    @Test
    fun removeExistingElementById() {
        list.add(2)

        assert(list.remove(index = 0) == 2)
    }

    @Test
    fun removeElementFromStart() {
        list.addAll(1, 2, 3)

        assert(list.remove(element = 1))
        assert(list.asList == listOf(2, 3))
    }

    @Test
    fun removeElementByIdFromStart() {
        list.addAll(1, 2, 3)

        assert(list.remove(index = 0) == 1)
        assert(list.asList == listOf(2, 3))
    }

    @Test
    fun removeElementFromMiddle() {
        list.addAll(1, 2, 3)

        assert(list.remove(element = 2))
        assert(list.asList == listOf(1, 3))
    }

    @Test
    fun removeElementByIdFromMiddle() {
        list.addAll(1, 2, 3)

        assert(list.remove(index = 1) == 2)
        assert(list.asList == listOf(1, 3))
    }

    @Test
    fun removeElementFromEnd() {
        list.addAll(1, 2, 3)

        assert(list.remove(element = 3))
        assert(list.asList == listOf(1, 2))
    }

    @Test
    fun removeElementByIdFromEnd() {
        list.addAll(1, 2, 3)

        assert(list.remove(index = 2) == 3)
        assert(list.asList == listOf(1, 2))
    }

    @Test
    fun sizeOfEmptyListIsZero() {
        assert(list.size == 0)
    }

    @Test
    fun addingElementChangesSize() {
        assert(list.size == 0)
        list.add(2)
        assert(list.size == 1)
    }

    @Test
    fun swapElementsByNonExistingIdThrowsException() {
        list.addAll(1, 2, 3)
        assertThrows<IndexOutOfBoundsException> { list.swapAfterId(3) }
    }

    @Test
    fun swapElements() {
        list.addAll(1, 2, 3)
        list.swapAfterId(0)
        assert(list.asList == listOf(2, 1, 3))
    }

    @Test
    fun addList() {
        val data = MyDoublyLinkedList<Int>()
        data.addAll(4, 5, 6)
        list.addAll(1, 2, 3)
        list.addAll(data)

        assert(list.asList == listOf(1, 2, 3, 4, 5, 6))
    }
}