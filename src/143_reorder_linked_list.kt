class Solution143 {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return
        val lst = mutableListOf<ListNode>()
        var current = head
        val seen = mutableSetOf<Int>()
        while (current != null) {
            lst.add(current)
            val tmp = current
            current = current.next
            tmp.next = null
        }
        for (i in 0.. lst.size.div(2)) {
            if (seen.contains(lst.size - 1 - i)) break
            lst[i].next = lst[lst.size - 1 - i]
            seen.add(i)
            seen.add(lst.size - 1 - i)
            if (seen.contains(i+1)) break
            lst[i].next?.next = lst[i+1]
            seen.add(i+1)

        }
    }
}