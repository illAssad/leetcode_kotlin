class DfsAdjList {
    class GraphNode(val value: Char) {
        var neighbors = mutableListOf<GraphNode>()
    }

    fun countNumberOfPaths(
        node: GraphNode,
        target: Char,
        visited: MutableSet<Char>
    ): Int {
        if (node.value == target) return 1
        if (node.neighbors.isEmpty() || visited.contains(node.value)) return 0

        var count = 0
        visited.add(node.value)
        for (neighbor in node.neighbors) {
            count += countNumberOfPaths(neighbor, target, visited)
        }
        visited.remove(node.value)



        return count
    }
}


fun main() {
    val solution = DfsAdjList()

    // Create test case 1: Simple graph A -> B -> C
    //                                 A -> C
    val nodeA = DfsAdjList.GraphNode('A')
    val nodeB = DfsAdjList.GraphNode('B')
    val nodeC = DfsAdjList.GraphNode('C')

    nodeA.neighbors.addAll(listOf(nodeB, nodeC))
    nodeB.neighbors.add(nodeC)

    println("Test 1: Should find 2 paths from A to C")
    println("Result: ${solution.countNumberOfPaths(nodeA, 'C', mutableSetOf())}")  // Expected: 2

    // Create test case 2: Cyclic graph A -> B -> C -> A
    val nodeA2 = DfsAdjList.GraphNode('A')
    val nodeB2 = DfsAdjList.GraphNode('B')
    val nodeC2 = DfsAdjList.GraphNode('C')

    nodeA2.neighbors.add(nodeB2)
    nodeB2.neighbors.add(nodeC2)
    nodeC2.neighbors.add(nodeA2)

    println("\nTest 2: Should find 0 paths from A to D (D doesn't exist)")
    println("Result: ${solution.countNumberOfPaths(nodeA2, 'D', mutableSetOf())}")  // Expected: 0

    // Create test case 3: Complex graph with multiple paths
    //      A -> B -> D
    //      |         ^
    //      -> C -----+
    val nodeA3 = DfsAdjList.GraphNode('A')
    val nodeB3 = DfsAdjList.GraphNode('B')
    val nodeC3 = DfsAdjList.GraphNode('C')
    val nodeD3 = DfsAdjList.GraphNode('D')

    nodeA3.neighbors.addAll(listOf(nodeB3, nodeC3))
    nodeB3.neighbors.add(nodeD3)
    nodeC3.neighbors.add(nodeD3)

    println("\nTest 3: Should find 2 paths from A to D")
    println("Result: ${solution.countNumberOfPaths(nodeA3, 'D', mutableSetOf())}")  // Expected: 2

    // Test case 4: Single node
    val singleNode = DfsAdjList.GraphNode('A')
    println("\nTest 4: Should find 1 path from A to A")
    println("Result: ${solution.countNumberOfPaths(singleNode, 'A', mutableSetOf())}")  // Expected: 1
}