package com.data.read.queue

import scala.collection.mutable.ArrayBuffer

class MyCircularQueueS(_k:Int) {
  /** Initialize your data structure here. Set the size of the queue to be k. */
  private    var  data= ArrayBuffer[Int](_k)
  private    var  p_start = 0
  private   var  p_end = 0
  /** Insert an element into the circular queue. Return true if the operation is successful. */
  def enQueue(value: Int): Boolean = {
    if (isFull()){
      return  false
    }else{
      data += value
      p_end  += p_end
      return true
    }
  }

  /** Delete an element from the circular queue. Return true if the operation is successful. */
  def deQueue(): Boolean = {
    if (isEmpty()){
      return false
    }else{
      data.drop(p_start)
      p_start += p_start
      return true
    }
  }

  /** Get the front item from the queue. */
  def Front(): Int = {
    data(p_start)
  }

  /** Get the last item from the queue. */
  def Rear(): Int = {
    data(p_end)
  }

  /** Checks whether the circular queue is empty or not. */
  def isEmpty(): Boolean = {
    return  p_end - p_start == 0
  }

  /** Checks whether the circular queue is full or not. */
  def isFull(): Boolean = {
    return p_end - p_start == -1 || p_start - p_end == 6
  }

}
