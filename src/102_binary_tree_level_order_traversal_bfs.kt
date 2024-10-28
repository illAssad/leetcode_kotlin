/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution102 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        var q = ArrayDeque<TreeNode>()
        var result = mutableListOf<MutableList<Int>>()
        if (root != null) q.add(root)
        while (q.isNotEmpty()) {
            for (i in 0..<q.size) {
                if (i == 0) result.add(mutableListOf<Int>())
                val current = q.removeFirst()
                result[result.size - 1].add(current.`val`)
                if (current.left != null) q.add(current.left!!)
                if (current.right != null) q.add(current.right!!)

            }
        }

        return result
    }
}
