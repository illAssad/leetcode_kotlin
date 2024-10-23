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
}



class ListNode(var `val`: Int) {
    var next: ListNode? = null
}