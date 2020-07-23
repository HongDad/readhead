package com.bernard.data.basic_grammer

object Gather {
  def main(args: Array[String]): Unit = {
     var array = List("1","2")
     val list = 3 :: 6 :: 7 :: "5" :: array
     list.foreach(println)
  }
}
