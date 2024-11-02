class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()

    fun shallowCopy(): Node {
        return Node(`val`)

    }
}

class Solution133 {
    fun cloneGraph(node: Node?): Node? {
        // init a stack
        // reserve a pointer to the head
        // init a map of old to new Nodes

        // dfs
        // pop from the stack
        // if this already exists in the map -> We can continue.
        // create a shallow Copy and add it to map
        // add neighbors for processing to the top of the stack

        val stack = ArrayDeque<Node>()
        val oldToNew = hashMapOf<Node, Node>()
        node?.let { stack.add(it) }

        while (stack.isNotEmpty()) {
            var current = stack.removeLast()
            if (oldToNew.contains(current)) continue
            oldToNew[current] = current.shallowCopy()

            for(neighbor in current.neighbors) {
                if (neighbor != null) {
                    stack.add(neighbor)
                }
            }
        }
        oldToNew.forEach {
            it.key.neighbors.forEach { neighbor ->
                it.value.neighbors.add(neighbor)
            }
        }
        return oldToNew[node]
    }

}