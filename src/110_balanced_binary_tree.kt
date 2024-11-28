import Solution700.*
import com.sun.source.tree.Tree
import kotlin.math.abs
import kotlin.math.max

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
class Solution110 {
    fun isBalanced(root: TreeNode?): Boolean {
        var output = true
        fun dfs(node: TreeNode?) : Int {
            if (node == null) return 0
            val left = dfs(node.left)
            val right = dfs(node.right)

            if (abs(left-right) > 1) {
                output = false
                return -1
            }
            return 1 + max(left, right)

        }
        dfs(root)
        return output
    }
}