package com.example.laboratorio1_

fun main() {
    val originalList: List<Any?> = mutableListOf("Hola", null, 1, 8, "Adiós", true, 7, false, 9, "PC", null)

    for (i in originalList) {
        var processedList = processList(i, originalList)

        if (i != null) {
            println("Posición Original: ${processedList[0].originalPos} | Valor Original: ${processedList[0].originalValue} | Tipo: ${processedList[0].type} | Información: ${processedList[0].info}")

        } else {
            println("Objeto 'null' no agregado.")
        }
    }
}

fun processList (item: Any?, myList: List<Any?>): List<ItemData> {

    var modifiedList: ArrayList<ItemData> = ArrayList()
    var module: Int = 10

    var position: Int
    var value: Any
    var type: String
    var info  = "null"

    if (item != null) {
        if (myList.contains(item)) {
            position = (myList.indexOf(item))                 // Cambiando la posición.
            value = (myList[position]!!)      // Cambiando el valor.

            // Determinando el tipo e información del objeto.
            if (item is Int) {
                type = ("Entero")

                while (info == "null") {
                    when (item % module) {
                        0 -> info = "M$module"
                        else -> module = (module * 0.5).toInt()
                    }
                }

            } else if(item is String) {
                type = ("Cadena")

                info = "L${item.length}"

            } else if(item is Boolean) {
                type = ("Booleano")

                info = when (item) {
                    true -> "Verdadero"
                    false -> "Falso"
                }

            } else {
                type = ("null")
            }

            var actualItem: ItemData = ItemData(position, value, type, info)
            modifiedList.add(actualItem)
        }

    }

    return modifiedList
}

class ItemData (originalPos: Int, originalValue: Any, type: String, info: String) {
    var originalPos = originalPos
    var originalValue = originalValue
    var type = type
    var info = info
}
