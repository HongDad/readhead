package com.data.read.sort

/**
  * @author wdh
  *         created  by  2020.7.14
  * @define  fastsort(快速排序)
  *          1、找一个基准key
  *          2、拿该key开始从后往前遍历，判断该key是否大于arr(j)，如果key<=arr(j),则j往前移，反之则交换，然后i往后移,如果key>=arr(i)，则i往后移，反之则交换，同理，一直到i==j
  */
object FastSort {
  def main(args: Array[String]): Unit = {
    val array = Array(10,9,8,7,6,5,4,3,2,1,0)
    fastSort(array, 0, array.length-1).foreach(println)
  }

  def fastSort(arr1: Array[Int], low: Int, high: Int): Array[Int] = {
    //定义一个基准key
    var arr = arr1
    var key = arr(low)
    //拿到排序的下限
    var i = low
    //拿到排序的上限
    var j = high
    //判断是否进入循环
    while (i < j) {
      //判断i<j并且基准key是否大于当前值，从右往左遍历拿到比他小的值
      while (i < j && key <= arr(j)) {
        j = j - 1
      }
      if (arr(i) == arr(j) && i < j) {
        i = i + 1
      } else {
        var temp = arr(j)
        arr(j) = arr(i)
        arr(i) = temp
      }
//      println(key, i, j)
      println(arr.mkString("    "))
      //判断i<j并且基准key是否小于于当前值，从左往右遍历拿到比它大的值
      while (i < j && key >= arr(i)) {
        i = i + 1
      }
      if (arr(i) == arr(j) && i < j) {
        i = i + 1
      } else {
        var temp = arr(j)
        arr(j) = arr(i)
        arr(i) = temp
      }
//      println(key, i, j)
      println(arr.mkString("    "))
    }
    arr = if ((i - 1) > low) fastSort(arr, 0, i - 1) else arr
    arr = if ((j + 1) < high) fastSort(arr, i + 1, high) else arr
    arr
  }
}
