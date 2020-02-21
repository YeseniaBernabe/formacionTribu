class cancion {

}

import java.text.Normalizer

object Lyrics extends App {
  val letra = io.Source.fromFile("..\\formacionTribu\\resources_yess\\if i lose myself")
    .getLines()
    .map(_.split(" "))
    .toArray

  val palabraMasRepetida =
    letra.flatMap(
      row => row.map(
        cell => {
          Normalizer.normalize(cell, Normalizer.Form.NFD)
            .replaceAll("[^A-Za-zé|ó|á|í\\s]", "")
            .toLowerCase
        }
      )
    )
      .groupBy(w => {
        w
      })
      .map(
        tupla => {
          (tupla._1, tupla._2.length)
        }
      )
      .maxBy(_._2)

  println(palabraMasRepetida)

}



