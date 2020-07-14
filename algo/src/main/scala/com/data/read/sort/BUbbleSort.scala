package com.data.read.sort

/**
  * @author wdh
  * cread by 2020.07.14
  * @define 冒泡排序
  *   1、拿第一个去和后面的n-1进行比较，每次都将最小的放在第一位
  *   2、拿第二个和后面的n-2进行比较，每次都将最小的放在第一位
  *   3、依此类推。。。。。。
  */
object BUbbleSort {
  def main(args: Array[String]): Unit = {
    val array = Array(10,9,8,7,6,5,4,3,2,1,0)
    bubbleSort(array)
  }
  //冒泡排序
  def  bubbleSort(arr:Array[Int])={
     for (i <- 0 to arr.length-1){
        for (j <- i to arr.length-1){
           var temp:Int = 0
           if (arr(i) > arr(j)){
             temp = arr(i)
             arr(i) = arr(j)
             arr(j) = temp
           }
          println(arr.mkString(" "))
        }
     }
    arr
  }
}
