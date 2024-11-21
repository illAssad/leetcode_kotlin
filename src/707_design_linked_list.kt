class MyLinkedList() {
    var size = 0
    var head: ListNode? = null
    var tail: ListNode? = null

    class ListNode(
        var `val`: Int,
        var prev: ListNode? = null,
        var next: ListNode? = null
    )

    fun getNode(index: Int): ListNode? {
        if (index !in 0..<size) return null

        // Always traverse from head to avoid complexity
        var current = head
        for (i in 0..<index) {
            current = current?.next
        }
        return current ?: null
    }

    fun get(index: Int): Int {
        if (index !in 0..<size) return -1

        // Always traverse from head to avoid complexity
        var current = head
        for (i in 0..<index) {
            current = current?.next
        }
        return current?.`val` ?: -1
    }

    fun addAtHead(`val`: Int) {
        val newNode = ListNode(`val`)
        if (size == 0) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head?.prev = newNode
            head = newNode
        }
        size++
    }

    fun addAtTail(`val`: Int) {
        val newNode = ListNode(`val`)
        if (size == 0) {
            head = newNode
            tail = newNode
        } else {
            newNode.prev = tail
            tail?.next = newNode
            tail = newNode
        }
        size++
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index !in 0..size) return

        if (index == 0) {
            addAtHead(`val`)
            return
        }
        if (index == size) {
            addAtTail(`val`)
            return
        }

        var current = head
        for (i in 0..<index) {
            current = current?.next
        }

        val newNode = ListNode(`val`)
        newNode.prev = current?.prev
        newNode.next = current
        current?.prev?.next = newNode
        current?.prev = newNode
        size++
    }

    fun deleteAtIndex(index: Int) {
        if (index !in 0..<size) return

        if (size == 1) {
            head = null
            tail = null
            size--
            return
        }

        if (index == 0) {
            head = head?.next
            head?.prev = null
            size--
            return
        }

        if (index == size - 1) {
            tail = tail?.prev
            tail?.next = null
            size--
            return
        }

        var current = head
        for (i in 0..<index) {
            current = current?.next
        }

        current?.prev?.next = current?.next
        current?.next?.prev = current?.prev
        size--
    }

    fun print(start: ListNode? = null) {
        var current = start ?: head
        while (current != null) {
            print(current.`val`)
            current = current.next
        }
        println()
    }
}

fun main() {
//    var myLinkedList = MyLinkedList()
//
//    myLinkedList.addAtHead(1)
//    myLinkedList.print()
//    myLinkedList.addAtTail(3)
//    myLinkedList.print()
//    myLinkedList.addAtIndex(1,2)
//    myLinkedList.print()
//    myLinkedList.deleteAtIndex(1)
//    myLinkedList.print()
//    myLinkedList.get(1)
//    myLinkedList.print()
    var myLinkedList = MyLinkedList()

    // Operation: addAtHead(7)
    myLinkedList.addAtHead(7)
    myLinkedList.print()

    // Operation: addAtHead(2)
    myLinkedList.addAtHead(2)
    myLinkedList.print()

    // Operation: addAtHead(1)
    myLinkedList.addAtHead(1)
    myLinkedList.print()

    // Operation: addAtIndex(3,0)
    myLinkedList.addAtIndex(3, 0)
    myLinkedList.print()

    // Operation: deleteAtIndex(2)
    myLinkedList.deleteAtIndex(2)
    myLinkedList.print()

    // Operation: addAtHead(6)
    myLinkedList.addAtHead(6)
    myLinkedList.print()

    // Operation: addAtTail(4)
    myLinkedList.addAtTail(4)
    myLinkedList.print()

    // Operation: get(4)
    myLinkedList.get(4)
    myLinkedList.print()

    // Operation: addAtHead(4)
    myLinkedList.addAtHead(4)
    myLinkedList.print()

    // Operation: addAtIndex(5,0)
    myLinkedList.addAtIndex(5, 0)
    myLinkedList.print()

    // Operation: addAtHead(6)
    myLinkedList.addAtHead(6)
    myLinkedList.print()
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */