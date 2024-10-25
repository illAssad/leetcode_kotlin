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
class Solution112 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false

        if (root.`val` == targetSum && (root.left == null && root.right == null)) return true
        if (hasPathSum(root.left, targetSum - root.`val`)) return true
        if (hasPathSum(root.right, targetSum - root.`val`)) return true
        return false

    }
}