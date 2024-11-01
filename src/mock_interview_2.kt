class mock_interview_2 {
    fun rotateMatrix(image: Array<IntArray>): Array<IntArray> {
        // 1 2 3 A | X 7 4 1
        // 4 5 6 B | Y 8 5 2
        // 7 8 9 C | Z 9 6 3
        // X Y Z W | W C B A

        var done = mutableSetOf<Pair<Int, Int>>()
        for (i in image.indices) {
            for (j in image.indices) {
                if (done.contains(Pair(i,j)) || done.contains(Pair(j,i))) continue
                done.add(Pair(i,j))
                done.add(Pair(j,i))
                var tmp = image[i][j]
                image[i][j] = image[j][i]
                image [j][i] = tmp
            }
        }
        for (i in image.indices) {
            image[i] = image[i].reversedArray()
        }
        image.forEach {
            println(it.contentToString())
        }
        return image

    }


    tailrec fun rotateMatrixRecursive(image: Array<IntArray>, radius: Int) {
        // do something here


    }

}



fun main() {
var input1 = arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6),
    intArrayOf(7,8,9)
)



    println(mock_interview_2().rotateMatrix(input1).contentToString())
}