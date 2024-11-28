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
class Solution {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0
        var maxDiameter = 0

        fun dfs(current : TreeNode?): Int {
            if (current == null) return 0
            val left =  dfs(current.left)
            val right = dfs(current.right)
            val diameter = left + right
            maxDiameter = max(diameter, maxDiameter)

            return 1 + max(left, right)
        }
        dfs(root)

        return maxDiameter
    }
}