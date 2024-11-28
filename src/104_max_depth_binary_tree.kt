import Solution700.*
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
class Solution104 {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        var maxDepth = 1
        fun dfs(current: TreeNode?, depth: Int = 1) {
            if (current == null) return
            maxDepth = max(maxDepth, depth)
            dfs(current.left, depth + 1)
            dfs(current.right, depth + 1)
        }
        dfs(root)
        return  maxDepth
    }
}