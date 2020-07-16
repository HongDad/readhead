package com.bernard.data.profile

import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.table.api.scala.BatchTableEnvironment
import org.apache.flink.api.scala._

object StreamCountSqlJob {
  def main(args: Array[String]): Unit = {
    //获取运行环境
    val env = ExecutionEnvironment.getExecutionEnvironment
    //创建一个表的运行环境
    val tableEnv = BatchTableEnvironment.create(env)
    //读文件
    val input = env.readTextFile("D:\\file\\test\\input.txt")
    val inputFile = input.map(m => {
      val arr = m.split(",")
      StartBean(arr(0), arr(1), arr(2), arr(3).asInstanceOf[Integer], arr(4).asInstanceOf[Double], arr(5).asInstanceOf[Double], arr(6).asInstanceOf[Double], arr(7).asInstanceOf[Double], arr(8).asInstanceOf[Double])
    })
    tableEnv.createTemporaryView("score", inputFile)
    val tableSql = tableEnv.sqlQuery(
      """
        |select
        |player,count(season)
        |from  score
        |group by player
        |limit  3
      """.stripMargin)
    tableEnv.toDataSet(tableSql).print()


  }
}

case class StartBean(season: String, player: String, play_num: String, first_court: Integer, time: Double, assists: Double, steala: Double, blocks: Double, score: Double)
