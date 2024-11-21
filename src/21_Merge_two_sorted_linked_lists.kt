class Solution21 {
    fun mergeTwoLists(list1: MyLinkedList.ListNode?, list2: MyLinkedList.ListNode?): MyLinkedList.ListNode? {
        val res = MyLinkedList.ListNode(-1)
        var current = res
        var lst1 = list1
        var lst2 = list2
        while (lst1 != null && lst2 != null) {
            if (lst1.`val` <= lst2.`val`) {
                current.next = lst1
                current = current.next!!
                lst1 = lst1.next

            } else {
                current.next = lst2
                current = current.next!!
                lst2 = lst2.next
            }
        }
        lst1?.let { current.next = it }
        lst2?.let { current.next = it }
        return res.next
    }
}


fun main () {
    val t = Solution21()

    val ll1 = MyLinkedList()
    val ll2 = MyLinkedList()

    ll2.addAtHead(1)
    ll2.addAtTail(3)
    ll2.addAtTail(4)

    ll1.addAtTail(1)
    ll1.addAtTail(2)
    ll1.addAtTail(4)
    ll1.print()
    ll2.print()


    ll2.print(t.mergeTwoLists(ll1.getNode(0), ll2.getNode(0)))
    println(t.mergeTwoLists(ll1.getNode(0), ll2.getNode(0)))
}
