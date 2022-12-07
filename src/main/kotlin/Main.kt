fun main() {
    val tree = RedBlackTree<Int>()
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    for (x in list) {
        tree.insert(x)
    }
    println(tree)
}