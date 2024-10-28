class Solution94 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var output = mutableListOf<Int>()
    fun inorderTraversal(root: TreeNode?): List<Int> {
        output.clear() // Clear previous results

        fun traverse(root: TreeNode?) {
            if (root == null) return
            root.left?.let { traverse(it) }
            output.add(root.`val`)
            root.right?.let { traverse(it) }
        }

        traverse(root)
        return output
    }
}

// Test function to create tree from array
fun createTree(values: Array<Int?>): Solution94.TreeNode? {
    if (values.isEmpty() || values[0] == null) return null

    val root = Solution94.TreeNode(values[0]!!)
    val queue = ArrayDeque<Solution94.TreeNode>()
    queue.add(root)
    var i = 1

    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.removeFirst()

        if (i < values.size && values[i] != null) {
            node.left = Solution94.TreeNode(values[i]!!)
            queue.add(node.left!!)
        }
        i++

        if (i < values.size && values[i] != null) {
            node.right = Solution94.TreeNode(values[i]!!)
            queue.add(node.right!!)
        }
        i++
    }
    return root
}

fun main() {
    val solution = Solution94()

    // Test Case 1: [1,null,2,3]
    //      1
    //       \
    //        2
    //       /
    //      3
    val test1 = createTree(arrayOf(1, null, 2, 3))
    println("Test 1: ${solution.inorderTraversal(test1)}") // Expected: [1,3,2]

    // Test Case 2: Empty tree
    println("Test 2: ${solution.inorderTraversal(null)}") // Expected: []

    // Test Case 3: Single node
    val test3 = createTree(arrayOf(1))
    println("Test 3: ${solution.inorderTraversal(test3)}") // Expected: [1]

    // Test Case 4: Complete binary tree
    //      1
    //     / \
    //    2   3
    //   / \ / \
    //  4  5 6  7
    val test4 = createTree(arrayOf(1, 2, 3, 4, 5, 6, 7))
    println("Test 4: ${solution.inorderTraversal(test4)}") // Expected: [4,2,5,1,6,3,7]

    // Test Case 5: Left-heavy tree
    //      1
    //     /
    //    2
    //   /
    //  3
    val test5 = createTree(arrayOf(1, 2, null, 3))
    println("Test 5: ${solution.inorderTraversal(test5)}") // Expected: [3,2,1]

    // Test Case 6: Right-heavy tree
    //   1
    //    \
    //     2
    //      \
    //       3
    val test6 = createTree(arrayOf(1, null, 2, null, null, null, 3))
    println("Test 6: ${solution.inorderTraversal(test6)}") // Expected: [1,2,3]
}