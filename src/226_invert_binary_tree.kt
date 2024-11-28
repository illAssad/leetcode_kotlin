import Solution700.*

class Solution226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        val head = root
        fun invert(current: TreeNode?) {
            if (current == null) return
            val cL = current.left
            val cR = current.right
            current.left = cR
            current.right = cL

            invert(current.left)
            invert(current.right)
        }
        invert(root)
        return head
    }
}