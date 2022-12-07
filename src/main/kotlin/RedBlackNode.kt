class RedBlackNode<T>(var value: T, var color: RedBlackColor) : TreePrinter.PrintableNode {
    var left: RedBlackNode<T>? = null
    var right: RedBlackNode<T>? = null
    var parent: RedBlackNode<T>? = null

    fun rotateRight(): RedBlackNode<T>? {
        val y = this
        val p = y.parent
        val x = y.left
        val b = x?.right
        if (y == p?.left) {
            p.left = x
        }
        if (y == p?.right) {
            p.right = x
        }
        x?.parent = p
        x?.right = y
        y.parent = x
        y.left = b
        b?.parent = y
        return x
    }

    fun rotateLeft(): RedBlackNode<T>? {
        val x = this
        val p = x.parent
        val y = x.right
        val b = y?.left
        if (x == p?.left) {
            p.left = y
        }
        if (x == p?.right) {
            p.right = y
        }
        y?.parent = p
        y?.left = x
        x.parent = y
        x.right = b
        b?.parent = x
        return y
    }

    override fun toString(): String = TreePrinter.print(this)

    override fun getLeft(): TreePrinter.PrintableNode? {
        return left
    }

    override fun getRight(): TreePrinter.PrintableNode? {
        return right
    }

    override fun getText(): String {
        return when (color) {
            RedBlackColor.RED -> "($value)"
            RedBlackColor.BLACK -> "$value"
        }
    }
}