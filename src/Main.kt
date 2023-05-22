class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null)

fun countOccurrences(root: TreeNode?, x: Int): Int {
    if (root == null) {
        return 0
    }

    var count = 0

    if (root.value == x) {
        count++
    }

    count += countOccurrences(root.left, x)
    count += countOccurrences(root.right, x)

    return count
}

fun main() {
    // Створення бінарного дерева
    val root = TreeNode(4)
    root.left = TreeNode(2)
    root.right = TreeNode(5)
    root.left?.left = TreeNode(2)
    root.left?.right = TreeNode(3)
    root.right?.left = TreeNode(4)
    root.right?.right = TreeNode(6)

    val x = 2
    val occurrences = countOccurrences(root, x)
    println("Кількість входжень елемента $x у дерево: $occurrences")
}
