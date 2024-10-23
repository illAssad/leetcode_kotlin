class MyStack() {
    class ListNode(
        var `val`: Int, var next: ListNode? = null
    )
    var head : ListNode? = null
    fun push(x: Int) {
        val node = ListNode(x, head)
        head = node
    }

    fun pop(): Int {
        head?.let {
            val result = it
            head = head?.next
            return result.`val`
        } ?: throw Exception("Nothing to pop")
    }

    fun top(): Int {
        head?.let { return it.`val` } ?: throw Exception("Empty")
    }

    fun empty(): Boolean {
        return head == null
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */