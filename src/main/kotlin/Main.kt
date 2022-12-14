fun main() {
    print("Введите строку для проверки: ")
    val s: String = readlnOrNull().toString()
    println(check(s))
}

fun check(s: String): String {
    val br = "(){}[]"
    val st = mutableListOf<Char>() // Создаём стек открытых скобок
    for (i in s.indices) {
        val ind = br.indexOf(s[i])
        // Проверяем, является ли текущий символ скобкой
        if (ind >= 0) {
            // Проверяем вид скобки (открывающая или закрывающая)
            if (ind % 2 == 1) { // Если скобка закрывающая
                // Проверяем наличие открытых скобок в стеке
                if (st.size == 0) return "Данная строка не является правильной расстановкой скобок"
                // Иначе извлекаем последнюю открытую скобку из стека
                val lastBr = st.removeLastOrNull()
                // Проверяем соответствие открывающей скобки в стеке и данной закрывающей
                if (lastBr != br[ind - 1]) return "Данная строка не является правильной расстановкой скобок"
            } else {
                // Открывающую скобку кладём в стек
                st.add(s[i])
            }
        } else return "Данная строка содержит не только скобки!"
    }
    // Если после обхода всей строки стек пуст — строка является правильной расстановкой скобок
    return "Данная строка является правильной расстановкой скобок"
}

//fun check(s:String):String {
//    val st = mutableListOf<Char>() // Создаём стек открытых скобок
//    for (i in s.indices) {
//        if (s[i] == ')') { // Если скобка закрывающая
//            // Проверяем наличие открытых скобок в стеке
//            if (st.size == 0) return "Данная строка не является правильной расстановкой скобок"
//            // Удаляем последнюю открытую скобку из стека
//            st.removeLastOrNull()
//            // Проверяем соответствие открывающей скобки в стеке и данной закрывающей
//        } else if (s[i] == '(') {
//            // Открывающую скобку кладём в стек
//            st.add(s[i])
//        } else return "Данная строка содержит не только круглые скобки!"
//    }
//    // Если после обхода всей строки стек пуст — строка является правильной расстановкой скобок
//    return "Данная строка является правильной расстановкой скобок"
//}