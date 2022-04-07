
// stepik 6.5

fun main() {
    var str = readLine().toString()
    var n = str.substringBefore(" ").toInt()    // кол. отрезков
    var start = mutableListOf<Long>()           // начала отрезков
    val end = mutableListOf<Long>()             // концы отрезков
    var points = mutableListOf<Long>()          // координаты точек
    val pointsFreq = mutableListOf<Long>()      // количество отрезков, которым принадлежат точки

    for (i in 0 until n) {              // заполняем список начал и концов
        str = readLine().toString()
        start.add(str.substringBefore(" ").toLong())
        end.add(str.substringAfter(" ").toLong())
    }

    val str2 = readLine().toString().split(" ")
    for (item in 0..str2.lastIndex) {       // заполняем список координат точек
        points.add(str2[item].toLong())
    }

    val treeIndex = mutableListOf<Int>()    // Список для хранения границ списков для сортировки
    var x: Long     // элемент списка для сравнения
    var l = 0       // начало списка
    var r = 0       // конец списка
    var i = 0       // указатель сортируемого индекса
    var j = 0       // указатель последнего элемента меньшего Х
    var lx = 0      // указатель первого элемента, равного Х
    var rx = 0      // указатель последнего элемента, равного Х

    //////////////////////////////////////
    // быстрая сортировка
    fun listSort (list1: MutableList<Long>) {
        var xIndex = (l .. r).random()  // точка отсчета, относительно него сортируем

        var x = list1[xIndex]
        list1[xIndex] = list1[l]
        list1[l] = x

        for (i in l + 1 .. r) {
            if (list1[i] <= list1[l]) {
                j ++
                x = list1[i]
                list1[i] = list1[j]
                list1[j] = x
            }
        }
        x = list1[l]
        list1[l] = list1[j]
        list1[j] = x
    }

    ///////////////////////////////////////////////
    //сортировка старта по возрастанию


    println("start=$start")
    println("end=$end")

    /////////////////////////////////////
    // Просто подсчет
    for (item in points) {
        var l = 0
        var r = start.lastIndex
        var m: Int
        while (r >= l) {
            m = (r + l) / 2
            if (start[m] <= item) {
                l = m + 1
            }  else {
                r = m - 1
            }
        }
        i = l - 1
        l = 0
        r = end.lastIndex
        while (r >= l) {
            m = (r + l) / 2
            if (end[m] >= item) {
                r = m - 1
            }  else {
                l = m + 1
            }
        }
        pointsFreq.add(i.toLong() - r)
    }
    /////////////////////////////////////
    println("pointsFreq=$pointsFreq")

    for (i in pointsFreq) {
        print("$i ")
    }
}

/*
2 3
0 5
7 10
1 6 11
Sample Output:
1 0 0

5 0
1 12
3 4
5 6
2 5
9 10
1 2 7 11
---
1 2 1 1

5 0
1 2
3 4
5 6
2 5
9 10
1 2 7 11
---
1 2 0 0

6 9
0 0
-1 1
-2 2
-3 3
-4 4
-5 5
-5 -4 -3 -1 0 1 3 4 5
---
1 2 3 5 6 5 3 2 1

2 2
1 2
2 2
1 2
---
1 2

6 6
2 3
2 5
3 5
2 7
5 7
3 7
1 2 3 5 6 7
---
0 3 5 5 3 3

7 6
6 6
2 3
2 5
3 5
2 7
5 7
3 7
1 2 3 5 6 7
---
0 3 5 5 4 3

10 5
-2 3
0 3
-1 0
-1 3
0 1
-2 -1
1 3
2 3
1 2
2 3
-3 -1 0 2 3
----
0 4 5 7 6

6 6
0 3
1 3
2 3
3 4
3 5
3 6
1 2 3 4 5 6
---
2 3 6 3 2 1
*/

// stepik 6.4
/*
fun main() {
	var n: Int = readLine().toString().toInt()
        val str = readLine().toString().split(" ")
        val kk = mutableListOf<Long>()
        var nn = mutableListOf<Long>()
        var x: Int	// начало текущей пары массивов
        var i = 0	// текущий индекс 1го массива
        var j = 0	// текущий индекс 2го массива
        var d = 1	// шаг, длина сравниваемых массивов
        n = 0		// счетчик инверсий

        for (i in 0 .. str.lastIndex) {
            // Преобразуем стринг в массив Лонг
            nn.add(str[i].toLong())
        }
    if (nn.size < 2) {
        println("0")
        return
    }
    while (d < nn.size) {
        x = 0

        while (x + d <= nn.lastIndex) {
            i = x
            j = i + d
            while (i < x + d || j < x + d + 1) {
                if (i < x + d && j < x + (2 * d) && j <= nn.lastIndex) {
                    if (nn[i] <= nn[j]) {
                        kk.add(nn[i])
                        i += 1
                    } else {
//                        n += x + d - i
                        kk.add(nn[j])
                        n += j - kk.lastIndex
                        println("n=$n, j=$j, ind=${kk.lastIndex}, kk=$kk")
                        j += 1
                    }
                } else {
                    if (i >= x + d) {
                        kk.add(nn[j])
                        j += 1
                    } else {
                        kk.add(nn[i])
                        i += 1
                    }
                }
            }
            x += d * 2
        }
        println("nn=$nn kk=$kk")
        for (r in 0 .. kk.lastIndex) {
            nn[r] = kk[r]
        }
        kk.clear()
        d *= 2
    }
    println(n)
}*/
/*
1
1 2 3
1
3 2 1
5
2 3 9 2 9
2
6
10 8 6 2 4 5
12
11
1 2 3 4 5 6 7 8 3 4 3
15
*/



// stepik 6.1
/*fun main() {
    var str1 = readLine().toString()
    var str2 = readLine().toString()

    val nn = str1.split(" ")
    val kk = str2.split(" ")
    val result = mutableListOf<Int>()

    var x: Int
    var l: Int
    var r: Int

    for (i in 1..kk.size-1) {
        r = nn.size-1
        l = 1
        x = -1
        while (r >= l) {
            if (nn[(r+l)/2] == kk[i]) {
                x = (r + l) / 2
                break
            } else {
                if ((nn[(r + l)/2]).toLong() < kk[i].toLong()) {
                    l = ((r + l) / 2) + 1
                } else {
                    r = ((r + l) / 2) - 1
                }
            }
        }
        result.add(x)
    }
    for (i in result) print("$i ")
}
*/
/*
5 1 5 8 12 13
5 8 1 23 1 11
* */

// stepik 4.3
// Очередь с приоритетами

//fun main() {
//    val n = readLine()!!.toInt()     // количество операций
//    var str: String     // строка ввода (Insert x или  ExtractMax)
//    var listZn = mutableListOf<Long>()  // очередь
//    var index: Int
//    var indexMin:Int
//    var y: Long
//
//    for (i in 1..n) {
//        str = readLine().toString()
//
//        if (str == "ExtractMax") {
//            println(listZn[0])
//            listZn[0] = listZn[listZn.lastIndex]
//            listZn.removeAt(listZn.lastIndex)
//
//            if (listZn.size > 1) {
//                    index = 0
//                    while ( (listZn.lastIndex > (index * 2)) && (listZn[index] < listZn[(index * 2) + 1])
//                        || (listZn.lastIndex > (index * 2) + 1) && (listZn[index] < listZn[(index * 2) + 2]) )
//                        {
//                            y = listZn[index]
//
//                            if (listZn.lastIndex > (index * 2) + 1) {
//                                if (listZn[(index * 2) + 1] > listZn[(index * 2) + 2]) {
//                                    indexMin = (index * 2) + 1
//                                } else indexMin = (index * 2) + 2
//                            } else {
//                                indexMin = (index * 2) + 1
//                            }
//
//                            listZn[index] = listZn[indexMin]
//                            listZn[indexMin] = y
//                            index = indexMin
//                    }
//                }
//
//        } else {
//
//            listZn.add(str.substringAfter(" ").toLong())
//
//            if (listZn.size > 1) {
//                index = listZn.lastIndex
//                while (listZn[index] > listZn[(index - 1) / 2]) {
//                    y = listZn[index]
//                    listZn[index] = listZn[(index - 1) / 2]
//                    listZn[(index - 1) / 2] = y
//                    index = (index - 1) / 2
//                }
//            }
//        }
//    }
//}








/*
stepik 4.2

 */
/*
fun main() {
    var s = readLine()!!.toString()
    val k = s.substringBefore(' ').toInt()
    val l = s.substringAfter(' ').toInt()
    var let = mutableListOf<String>()
    var kod = mutableListOf<String>()

    for (i in 1 .. k) {
        s = readLine()!!.toString()
        let.add(s.substringBefore(':').toString())
        kod.add(s.substringAfter(' ').toString())
    }
    s = ""
    var strKod = readLine()!!.toString()
    var str = ""

    while (strKod.length > 0) {
        for (i in 1..strKod.length) {
            str = "$str${strKod[i-1]}"
            if (kod.contains(str)) {
                strKod = strKod.drop(str.length)
                s = "$s${let[kod.indexOf(str)]}"
                str = ""
            }
        }
    }
    print(s)
}
*/




/* 4.2
* По данной непустой строке s длины не более 10^4, состоящей из строчных букв латинского алфавита,
* постройте оптимальный беспрефиксный код. В первой строке выведите количество различных букв k,
* встречающихся в строке, и размер получившейся закодированной строки.
* В следующих kk строках запишите коды букв в формате "letter: code". В последней строке выведите закодированную строку.
* */
/*
fun main() {
    var s = readLine()!!.toString()     // Входная строка
    val k = mutableListOf<String>()     // Список уникальных символов в s
    val n = mutableListOf<Int>()        //Количество повторений символа из k в s
    val kod = mutableListOf<String>()   // коды для букв, упорядоченных по частоте использования
    var sym = mutableListOf<String>()   // массив букв, упорядоченных по частоте использования
    val tempSym = mutableListOf<String>()
    val tempFrq = mutableListOf<Int>()
    val tempKod = mutableListOf<String>()
    var str = ""                        // вспомогательная строка

    // Запоняем списки уникальных букв и их частоты
    for (i in s) {
        if (k.contains("$i")) {
            n[k.indexOf("$i")] += 1
        } else {
            k.add("$i")
            n.add(1)
        }
    }
    for (i in k) {
        sym.add(i)
        kod.add("")
    }

    while (k.size > 1) {
        for (i in 1..2) {
            tempSym.add(k[n.indexOf(n.minOrNull())])
            tempFrq.add(n[n.indexOf(n.minOrNull())])
            k.removeAt(n.indexOf(n.minOrNull()))
            n.removeAt(n.indexOf(n.minOrNull()))
            tempKod.add("${2 - i}")
        }
        k.add("${tempSym[tempSym.lastIndex]}${tempSym[tempSym.lastIndex - 1]}")
        n.add(tempFrq[tempFrq.lastIndex] + tempFrq[tempFrq.lastIndex - 1])
    }

    if (sym.size > 1) {
        for (i in 0..sym.size - 1) {
            for (j in 0..tempSym.size - 1) {
                if (tempSym[j].contains(sym[i])) {
                    kod[i] = "${tempKod[j]}${kod[i]}"
                }
            }
        }
    }

    if (sym.size == 1) {
        kod[0] = "0"
    }

    for (i in s.toString()) {
        str = "$str${kod[sym.indexOf(i.toString())]}"
    }

    print("${sym.size} ")
    println(str.length)
    for (j in sym) {
        println("$j: ${kod[sym.indexOf("$j")]}")
    }
    print(str)
}
*/

//if (sym.size % (count * 2) == 0) {
//        while (2.0.pow(count.toDouble()) <= sym.size) {
//            for (i in 1..count) {
//                if (i < sym.size) {
//                    kod[i-1] = "0${kod[i-1]}"
//                    kod[i] = "1${kod[i]}"
//                }
//            }
//            count *= 2
//        }
//    } else {
//        while (2.0.pow(count.toDouble()) <= sym.size) {
////            while (count+1 <= sym.size) {
//                for (i in count + 1..count * 2) {
//                if (i < sym.size) {
//                    kod[i-1] = "0${kod[i-1]}"
//                    kod[i] = "1${kod[i]}"
//                }
//            }
//            count *= 2
//        }
//    }

// str = "0"
//        if (sym.size != 0) {
//            for (i in 1..sym.size) {
//                str = "1$str"
//            }
//            if (sym.size > 1 && k.size == 1) {
//                str = str.dropLast(2)
//                str = "${str}1"
//            }
//        }




/*
* По данному числу n (от 1 до 10^9) найдите максимальное число k,
* для которого n можно представить как сумму k различных натуральных слагаемых.
* Выведите в первой строке число k, во второй — k слагаемых.
* */
/*
fun main() {
    val n: Int = readLine()!!.toInt() // Исходное число
    var k = mutableListOf<Int>()  // Слагаемые
    var x = 10
    var y = 5

    if (n<10) {
        k = when (n) {
            1 -> mutableListOf(1)
            2 -> mutableListOf(2)
            3 -> mutableListOf(1, 2)
            4 -> mutableListOf(1, 3)
            5 -> mutableListOf(2, 3)
            6 -> mutableListOf(1, 2, 3)
            7 -> mutableListOf(1, 2, 4)
            8 -> mutableListOf(1, 2, 5)
            9 -> mutableListOf(2, 3, 4)
            else -> {mutableListOf(1, 2, 3, 4)}
        }
    }
    println(k)
    while (x+y < n) {
        x += y
        y += 1
        k.add(y)
    }
    println("x = $x, y = $y")
    println("size = ${k.size}")
    println(k)
}
*/


// непрерывный рюкзак
/*fun main() {
    var str: String? = ""        // Строки из консоли
    var n: Int          // Количество данных предметов
    var w: Double         // вместимость рюкзака
    var cost: Double = 0.0     // стоимость рюкзака
    var x: Int
    var y: String

    val cc = mutableListOf<Long>()   // стоимости предметов
    val ww = mutableListOf<Double>()   // объемы предметов
    val cw = mutableListOf<Double>() // удельная стоимость предмета

//    val bpW = mutableListOf<Float>()    // вес предметов в рюкзаке
//    val bpC = mutableListOf<Float>()    // стоимость предметов в рюкзаке

    str = readLine()!!
    n = str.substringBefore(' ').toInt()
    w = str.substringAfter(' ').toDouble()

    for (i in 1..n) {
        str = readLine()
        y = str?.substringBefore(' ').toString()
        cc.add(y.toLong())
        y = str?.substringAfter(' ').toString()
        ww.add(y.toDouble())
        cw.add(cc[i-1].toDouble()/ww[i-1])
    }
    while (w > 0.000 && cw.size > 0) {
        x = cw.indexOf(cw.maxOrNull())
        if (ww[x] <= w) {
            cost += cc[x].toDouble()
            w -= ww[x]
            ww.removeAt(x)
            cc.removeAt(x)
            cw.removeAt(x)
        } else {
            cost += cc[x].toDouble() * (w/ww[x])
            w = 0.000
        }
    }
    println(cost)
}*/




/*По данным nn отрезкам необходимо найти множество точек минимального размера, для которого каждый из отрезков содержит хотя бы одну из точек*/
/*fun main() {
    var n: Int = readLine()!!.toInt()
    var z: String = ""
    var l = mutableListOf<Long>()
    var r = mutableListOf<Long>()
    var sm = mutableListOf<Int>()
    var dots = mutableListOf<Long>()
    var x: Int
    var y: Long

    for (i in 1..n) {
        z = readLine()!!
        l.add(z.substringBefore(' ').toLong())
        r.add(z.substringAfter(' ').toLong())
    }

    while (l.size > 0) {
        sm.clear()
        x = r.indexOf(r.minOrNull()!!)
        y = r[x]
        dots.add(y)

        for (i in 0 .. l.size-1) {
            if (l[i] < y || l[i] == y) {
                sm.add(i)
            }
        }
        for (i in sm.size-1 downTo 0) {
            x = sm[i]
            l.removeAt(x)
            r.removeAt(x)
        }
    }

    println(dots.size)
    for (i in 0 .. dots.size-1) {
        print(dots[i])
        if (i != dots.lastIndex) {
            print(" ")}
    }
}
*/



/* Найти остаток от деления Fn на m */
//fun  main() {
//    val str = readLine().toString()
//    var n = str.substringBefore(' ').toLong() // n-ное число F
//    var m = str.substringAfter(' ').toLong()  // делитель
//    var x:Long = 0      //Fn-2
//    var y:Long = 1    //Fn-1
//    var z:Long = 0    //Fn
//    if(n<=1) {
//        z = n
//    } else {
//        for (i in 2..n) {
//            z=(x+y)
//            print(z%m)
//            x = y
//            y = z
//            println("x=$x, y=$y, z=$z")
//        }
//    }
//    println (z%m)
//}

/* Найти наибольший общий делитель */
//fun  main() {
//    val str = readLine().toString()
//    var a = str.substringBefore(' ').toLong()
//    var b = str.substringAfter(' ').toLong()
//    while (a>0 && b>0) {
//        if (a>=b) {
//            a=a%b
//        } else {
//            b=b%a
//        }
//    }
//    println(max(a,b))
//}
