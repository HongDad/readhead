package com.bernard.data.http

import scalaj.http.Http

object HttpUntils {
  def main(args: Array[String]): Unit = {
    val url = "http://openapi.yoyi.com.cn/openapi/v1/campaign/listAllCampaign"
    val body = "{\"userName\":\"adplus@yoyi.com.cn\",\"passWord\":\"Z4IaFHLHMPUQ2018\",\"systemId\":\"1\"}"
    val head = Map(
    //  "token" -> "13814O87nM48014339O9T03x735zN0gOLP08",
      "Content-Type" -> "application/json; charset=UTF-8",
      "Accept" -> "application/json; charset=UTF-8"
    )
    println(postHead(url, head,body))
  }

  def postHead(url: String, header: Map[String, String], body: String) = {
    val request = Http(url)
    for ((key, value) <- header) {
      request.header(key, value)
    }
     request.postData(body).asString
  }

  //从接口拿取数据,通过get的方式
  def get(url: String, header: Map[String, String]) = {
    val request = Http(url)
    for ((key, value) <- header) {
      request.header(key, value)
    }
    request.asString
  }
}
