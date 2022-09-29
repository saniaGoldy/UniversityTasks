package domain

import domain.dataStructures.BinaryTree

class BinaryTreeSorter : Sorter {
    private val binaryTree = BinaryTree()

    override fun sort(list: List<Int>): List<Int> {
        list.forEach { binaryTree.insert(it) }
        return binaryTree.getAsList()
    }
}