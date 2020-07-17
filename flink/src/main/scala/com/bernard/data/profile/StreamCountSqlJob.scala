package com.bernard.data.profile

import org.apache.flink.api.scala.{ExecutionEnvironment, _}
import org.apache.flink.table.api.scala.BatchTableEnvironment

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
      StartBean(arr(0), arr(1), arr(2), arr(3), arr(4), arr(5), arr(6), arr(7), arr(8))
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
    tableSql.printSchema()
   // tableEnv.toDataSet(tableSql).print()


  }
}

case class StartBean(season: String, player: String, play_num: String, first_court: String, time: String, assists: String, steala: String, blocks: String, score: String)
