package com.bernard.data.profile

import org.apache.flink.api.scala.ExecutionEnvironment

object BatchCountJob {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val input = "D:\\file\\test\\input.txt"
    val inputFile = env.readTextFile(input)
    import org.apache.flink.api.scala._
    val file = inputFile.flatMap(m => {
      val strings = m.split("\\{")(1).split("\\}")(0).split(",")
      val tuples = strings.map(p => {
        val strings = p.split("\\:")
        (strings(0), strings(1))
      })
      tuples
    })
    file.groupBy(0).sum("m").print()

  }
}
