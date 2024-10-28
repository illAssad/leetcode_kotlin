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
class Solution230 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var seen = arrayListOf<Int>()

        fun dfs(root: TreeNode?) {
            if (root == null) return
            dfs(root.left)
            seen.add(root.`val`)
            if (seen.size > k) seen.removeLast()
            if (seen.size == k) return
            dfs(root.right)
        }
        dfs(root)
        return seen.last()
    }
}

fun main() {

}
