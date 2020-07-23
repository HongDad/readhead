package com.bernard.data.heard

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Heard {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setAppName(s"${this.getClass.getName}")
      .setMaster("local[*]")
    val ss = SparkSession
      .builder()
    //  .enableHiveSupport()
      .getOrCreate()
    //calayst optimization  & tungsten  excution
    ss.sql(
      """
        |select   1,2
      """.stripMargin).show()


    ss.stop()
  }
}
