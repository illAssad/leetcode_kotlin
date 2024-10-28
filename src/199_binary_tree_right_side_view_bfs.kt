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
class Solution199 {
    fun rightSideView(root: Solution102.TreeNode?): List<Int> {
        var output = mutableListOf<Int>()
        var bfs = Solution102().levelOrder(root)
        for (level in bfs) {
           output.add(level.last())
        }

        return output
    }
}