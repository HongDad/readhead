package com.bernard.data.profile

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment

object StreamCountJob {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val input = env.socketTextStream("localhost",8080)
    env.execute("StreamCountJob")
  }
}
