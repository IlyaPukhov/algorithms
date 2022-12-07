import RedBlackColor.*

class RedBlackTree<T : Comparable<T>> {
    private var root: RedBlackNode<T>? = null

    override fun toString(): String = root?.toString() ?: "empty tree"

    private fun rotateRight(node: RedBlackNode<T>) {
        if (node == root) {
            root = node.rotateRight()
        } else {
            node.rotateRight()
        }
    }

    private fun rotateLeft(node: RedBlackNode<T>) {
        if (node == root) {
            root = node.rotateLeft()
        } else {
            node.rotateLeft()
        }
    }

    fun insert(value: T) {
        if (root == null) {
            root = RedBlackNode(value, BLACK)
        } else {
            insert(root!!, value)
        }
    }

    private fun insert(node: RedBlackNode<T>, value: T) {
        if (value < node.value) {
            if (node.left == null) {
                val newNode = RedBlackNode(value, RED)
                newNode.parent = node
                node.left = newNode
                balance(newNode)
            } else {
                insert(node.left!!, value)
            }
        } else {
            if (node.right == null) {
                val newNode = RedBlackNode(value, RED)
                newNode.parent = node
                node.right = newNode
                balance(newNode)
            } else {
                insert(node.right!!, value)
            }
        }
    }

    private fun balance(x: RedBlackNode<T>) {
        val p = x.parent
        if (p == null) {
            x.color = BLACK
            return
        }
        if (p.color == BLACK) {
            return
        }
        val g = p.parent
        if (g == null) {
            balance(p)
            return
        }
        val u = if (p == g.left) {
            g.right
        } else {
            g.left
        }
        // 1 сл.
        if (u?.color == RED) {
            println("1 сл.")
            g.color = RED
            p.color = BLACK
            u.color = BLACK
            balance(g)
            return
        }
        // 2 сл.
        if (u == g.right && x == p.left) {
            println("2 сл.")
            rotateRight(g)
            g.color = RED
            g.parent?.color = BLACK
            return
        }
        // 3 сл.
        if (u == g.right && x == p.right) {
            println("3 сл.")
            rotateLeft(p)
            rotateRight(g)
            g.color = RED
            g.parent?.color = BLACK
            return
        }
        // 4 сл.
        if (u == g.left && x == p.right) {
            println("4 сл.")
            rotateLeft(g)
            g.color = RED
            g.parent?.color = BLACK
            return
        }
        // 5 сл.
        if (u == g.left && x == p.left) {
            println("5 сл.")
            rotateRight(p)
            rotateLeft(g)
            g.color = RED
            g.parent?.color = BLACK
            return
        }
    }
}