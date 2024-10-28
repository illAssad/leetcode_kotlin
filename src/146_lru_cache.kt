class LRUCache(private val capacity: Int) {
    class CacheNode(
        var `val`: Int,
        var key: Int,
        var next: CacheNode? = null,
        var prev: CacheNode? = null,
    )

    private var head: CacheNode? = null // most recently used
    private var tail: CacheNode? = null // least recently used
    private var size = 0
    private val myMap = HashMap<Int, CacheNode>()

    fun get(key: Int): Int {
        return if (myMap.containsKey(key)) {
            val node = myMap[key]!!
            moveToFront(node)
            node.`val`
        } else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        if (myMap.containsKey(key)) {
            val node = myMap[key]!!
            node.`val` = value
            moveToFront(node)
        } else {
            val newNode = CacheNode(value, key)
            myMap[key] = newNode
            addToFront(newNode)
            size++

            if (size > capacity) {
                // Remove least recently used
                myMap.remove(tail!!.key)
                removeTail()
                size--
            }
        }
    }

    private fun moveToFront(node: CacheNode) {
        if (node === head) return // Already at front

        val prev = node.prev
        val next = node.next

        // Remove node from its current position
        if (node === tail) {
            tail = prev
            tail?.next = null
        } else {
            prev?.next = next
            next?.prev = prev
        }

        // Move to front
        node.prev = null
        node.next = head
        head?.prev = node
        head = node
    }

    private fun addToFront(node: CacheNode) {
        if (head == null) {
            head = node
            tail = node
        } else {
            node.next = head
            head?.prev = node
            head = node
        }
    }

    private fun removeTail() {
        if (tail === head) {
            head = null
            tail = null
        } else {
            tail = tail?.prev
            tail?.next = null
        }
    }
}