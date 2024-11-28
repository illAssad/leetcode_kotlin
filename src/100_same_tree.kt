import Solution700.*

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
class Solution100 {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        var result = true
        fun dfs(n1: TreeNode?, n2: TreeNode?) {
            if (n1 == null && n2 == null) return
            if (n1?.`val` == n2?.`val`) {
                dfs(n1?.left, n2?.left)
                dfs(n1?.right, n2?.right)
            } else {
                result = false
                return
            }
        }
        dfs(p,q)
        return result
    }
}