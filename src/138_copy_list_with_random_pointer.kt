/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution138 {
    class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }

    fun copyRandomList(node: Node?): Node? {
        // 1. Init a map<node,node> -> this is going to contain a mapping
        // of original nodes to their copies.
        // 2. This problem can be done as dfs or bfs. I  will try dfs (recursion)
        // The algo should be something like this ->
        // a. Make a copy of currentNode (original) -> Place the pair in map
        // b. Handle the pointers -> If it exists in the map -> Point to the value -> return
        // ELSE -> DFS that pointer
        // ^ This is done for each of the pointers
        // So in theory by the time we get an almost complete copy, the termination should occur
        // because the pointer nodes are already in the graph.'
        // return the map[node]

        val map = mutableMapOf<Node, Node>()
        fun dfs(current: Node?) {
            // do we even need a clever base case here? No -> we aren't calling dfs on things in the map
            if (current == null) return
            val copy = Node(current.`val`)
            map[current] = copy
            if (map.contains(current.next)) {
                copy.next = map[current.next]
            } else {
                dfs(current.next)
                map[current]?.next = map[current.next]
            }
            if (map.contains(current.random)) {
                copy.random = map[current.random]
            } else {
                dfs(current.random)
                map[current.random]?.random = map[current.random]
            }
        }

        dfs(node)
        return map[node]
    }

    fun createTestInput(): Node {
        // Create nodes
        val node1 = Node(1)
        val node2 = Node(2)
        val node3 = Node(3)
        val node4 = Node(4)

        // Link next pointers
        node1.next = node2
        node2.next = node3
        node3.next = node4

        // Link random pointers
        node1.random = node3  // Random pointer from node1 to node3
        node2.random = node1  // Random pointer from node2 to node1
        node3.random = node4  // Random pointer from node3 to node4
        node4.random = node2  // Random pointer from node4 to node2

        // Return the head of the list
        return node1
    }
}


fun main() {
    val t = Solution138()
    println(t.copyRandomList(t.createTestInput()))
}