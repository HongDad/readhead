package com.bernard.data.profile

import org.apache.flink.api.scala.ExecutionEnvironment

object BatchCountJob {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val input = "D:\\file\\test\\input.txt"
    val inputFile = env.readTextFile(input)
    import org.apache.flink.api.scala._
    val file = inputFile.flatMap(m => {
      val strings = m.split(",")
      strings
    })
    file.print()

  }
}
