import java.util.LinkedList

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        // reference current node -> this is needed when we move over.
        // init a variable (prev) init to null
        // point .next to prev
        // move pointer to current.next
        var current = head
        var prev: ListNode? = null
        while (current?.next != null) {
            val next = current.next
            current.next = prev
            prev = current
            current = next
        }
        current?.next = prev
        return current
    }

    fun reverseListRecursive(head: ListNode?) : ListNode? {
        fun reverse(head: ListNode?, prev: ListNode? = null): ListNode? {
            if (head?.next == null) {
                head?.next = prev
                return head
            }

            var next = head.next
            head.next = prev
            return reverse(next, head)
        }
        return reverse(head)
    }
}



class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    var head: ListNode? = null
    for (i in 0..<5) {
        var node = ListNode(i)
        node.next = head
        head = node
    }
    head = Solution().reverseListRecursive(head)
    while (head != null) {
        println(head.`val`)
        head = head.next
    }


}